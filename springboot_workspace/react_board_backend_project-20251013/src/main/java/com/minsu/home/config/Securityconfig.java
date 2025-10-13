package com.minsu.home.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.minsu.home.service.UserSecurityService;

import jakarta.servlet.http.HttpServletResponse;

@Configuration
@EnableWebSecurity //모든 요청 url이 스프링 시큐리티의 제어를 받도록 하는 annotation
public class Securityconfig {	
	
	@Autowired
	private UserSecurityService userSecurityService;
	
	@Bean
	public SecurityFilterChain fiteChain(HttpSecurity http) throws Exception {
		http
		.csrf(csrf -> csrf.disable()) //csrf 인증을 비활성화->리액트, vue 같은 프론트엔+백엔드 구조->불필요
		.cors(Customizer.withDefaults()) //cors->활성화
        .authorizeHttpRequests(auth -> auth
            .requestMatchers("/api/auth/signup", "/api/auth/login", "/api/board", "/api/board/**").permitAll()
            .anyRequest().authenticated()
        )
        .formLogin(login -> login //아이디와 비밀번호 확인은 여기서!->확인되면 세션까지 생성
            .loginProcessingUrl("/api/auth/login") //로그인 요청 url
            .usernameParameter("username")
            .passwordParameter("password")           
            //로그인이 성공시 -> ok -> 200
            .successHandler((req, res, auth) -> {
            	res.setStatus(HttpServletResponse.SC_OK);
            	res.setContentType("application/json"); // 추가
                res.getWriter().write("{\"message\":\"로그인 성공\"}"); // 추가
            })
            //로그인이 실패시 -> fail -> 401
            .failureHandler((req, res, ex) -> {
            	res.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            	res.setContentType("application/json"); // 추가
                res.getWriter().write("{\"message\":\"로그인 실패\"}"); // 추가
            })            
            
        )
        .logout(logout -> logout
        	.logoutUrl("/api/auth/logout") //로그아웃 요청이 들어오는 url
        	.logoutSuccessHandler((req, res, auth) -> res.setStatus(HttpServletResponse.SC_OK))
        	//로그아웃 성공시 200 응답
        ).userDetailsService(userSecurityService); // ===== 추가: UserDetailsService 등록 =====

    return http.build();
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}	
	
	@Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }
	
	//프론트엔드 리액트에서 요청하는 주소 허용
	@Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowedOrigins(List.of("http://localhost:3000")); // React 개발 서버
        config.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "OPTIONS"));
        config.setAllowedHeaders(List.of("*"));
        config.setAllowCredentials(true); // 쿠키, 세션 허용 시 필요

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);
        return source;
    }	
	
}