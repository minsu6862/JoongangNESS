<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Request 세부사항</title>
<style>
    body { font-family: Arial, sans-serif; margin: 20px; }
    .info-section { margin-bottom: 20px; }
    .info-title { color: #333; font-weight: bold; font-size: 16px; }
    .info-item { margin: 5px 0; padding-left: 10px; }
    hr { border: 1px solid #ccc; margin: 20px 0; }
</style>
</head>
<body>
    <h1>Request 객체 정보</h1>
    
    <div class="info-section">
        <div class="info-title">🌐 서버 정보</div>
        <%
        out.println("<div class='info-item'>서버 이름 : " + request.getServerName() + "</div>");
        out.println("<div class='info-item'>포트 번호 : " + request.getServerPort() + "</div>");
        out.println("<div class='info-item'>요청 방식 : " + request.getMethod() + "</div>");
        out.println("<div class='info-item'>프로토콜 : " + request.getProtocol() + "</div>");
        out.println("<div class='info-item'>URL : " + request.getRequestURL() + "</div>");
        out.println("<div class='info-item'>URI : " + request.getRequestURI() + "</div>");
        out.println("<div class='info-item'>컨텍스트 경로 : " + request.getContextPath() + "</div>");
        out.println("<div class='info-item'>서블릿 경로 : " + request.getServletPath() + "</div>");
        %>
    </div>

    <hr>

    <div class="info-section">
        <div class="info-title">👤 클라이언트 정보</div>
        <%
        out.println("<div class='info-item'>IP 주소 : " + request.getRemoteAddr() + "</div>");
        out.println("<div class='info-item'>호스트 : " + request.getRemoteHost() + "</div>");
        out.println("<div class='info-item'>포트 : " + request.getRemotePort() + "</div>");
        
        String userAgent = request.getHeader("User-Agent");
        out.println("<div class='info-item'>웹브라우저 : " + (userAgent != null ? userAgent : "정보없음") + "</div>");
        
        String referer = request.getHeader("Referer");
        out.println("<div class='info-item'>이전 페이지 : " + (referer != null ? referer : "직접 접근") + "</div>");
        
        String acceptLanguage = request.getHeader("Accept-Language");
        out.println("<div class='info-item'>언어 설정 : " + (acceptLanguage != null ? acceptLanguage : "정보없음") + "</div>");
        %>
    </div>

    <hr>

    <div class="info-section">
        <div class="info-title">📋 요청 세부 정보</div>
        <%
        out.println("<div class='info-item'>쿼리 스트링 : " + 
                   (request.getQueryString() != null ? request.getQueryString() : "없음") + "</div>");
        out.println("<div class='info-item'>Content Type : " + 
                   (request.getContentType() != null ? request.getContentType() : "없음") + "</div>");
        out.println("<div class='info-item'>Content Length : " + 
                   (request.getContentLength() != -1 ? request.getContentLength() + " bytes" : "없음") + "</div>");
        out.println("<div class='info-item'>Character Encoding : " + 
                   (request.getCharacterEncoding() != null ? request.getCharacterEncoding() : "기본값") + "</div>");
        out.println("<div class='info-item'>세션 ID : " + request.getRequestedSessionId() + "</div>");
        %>
    </div>

    <hr>

    <div class="info-section">
        <div class="info-title">🔧 추가 헤더 정보</div>
        <%
        java.util.Enumeration<String> headerNames = request.getHeaderNames();
        while(headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            String headerValue = request.getHeader(headerName);
            out.println("<div class='info-item'>" + headerName + " : " + headerValue + "</div>");
        }
        %>
    </div>

</body>
</html>