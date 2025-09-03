package com.minsu.miniproject.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.minsu.miniproject.dao.ReserveDao;
import com.minsu.miniproject.dto.ReserveDto;

@Controller
public class ReserveController {
	
	@Autowired
	private SqlSession sqlSession;
	
	@RequestMapping(value = "/reserveForm")
	public String reserve(Model model) {
		
		ReserveDao reserveDao = sqlSession.getMapper(ReserveDao.class);
		
		// 데이터베이스에서 모든 좌석 정보 조회
		List<ReserveDto> seats = reserveDao.selectAllSeats();
				
		// JSP로 좌석 정보 전달
		model.addAttribute("seats", seats);
		
		return "reserve/reserve";
	}
	
	@RequestMapping(value = "/reservation/reserve")
	@ResponseBody
	public String bookSeat(@RequestParam String seatId, HttpSession session) {
		// 로그인 체크
		String sessionId = (String) session.getAttribute("sessionId");
		if (sessionId == null) {
			return "login_required";
		}
		
		try {
			ReserveDao reserveDao = sqlSession.getMapper(ReserveDao.class);
			
			// 좌석 상태 확인
			ReserveDto seat = reserveDao.selectSeatByName(seatId);
			if (seat == null) {
				return "seat_not_found";
			}
			
			if (seat.getReserved() == 1) {
				return "already_reserved";
			}
			
			// 예약 처리
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("seatname", seatId);
			params.put("sessionId", sessionId);
			
			int result = reserveDao.updateSeatReservation(params);
			/*
			 * if (result > 0) { return "success"; } else { return "fail"; }
			 */
			return result > 0 ? "success" : "fail";
			
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}
	
	@RequestMapping(value = "/reservation/cancel")
	@ResponseBody
	public String cancelSeat(@RequestParam String seatId, HttpSession session) {
		// 로그인 체크
		String sessionId = (String) session.getAttribute("sessionId");
		if (sessionId == null) {
			return "login_required";
		}
		
		try {
			ReserveDao reserveDao = sqlSession.getMapper(ReserveDao.class);
			
			// 좌석 상태 및 권한 확인
			ReserveDto seat = reserveDao.selectSeatByName(seatId);
			if (seat == null || seat.getReserved() == 0) {
				return "not_reserved";
			}
			
			// 본인 예약인지 확인
			if (!sessionId.equals(seat.getReserveid())) {
				return "not_your_reservation";
			}
			
			// 예약 취소 처리
			int result = reserveDao.cancelSeatReservation(seatId);
			
			/*
			 * if (result > 0) { return "success"; } else { return "fail"; }
			 */
			return result > 0 ? "success" : "fail";
			
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}
	
	@RequestMapping(value = "/reservation/check")
	@ResponseBody
	public String checkSeat(@RequestParam String seatId, HttpSession session) {
		// 로그인 체크
		String sessionId = (String) session.getAttribute("sessionId");
		if (sessionId == null) {
			return "login_required";
		}
		
		try {
			ReserveDao reserveDao = sqlSession.getMapper(ReserveDao.class);
			
			// 좌석 상태 확인
			ReserveDto seat = reserveDao.selectSeatByName(seatId);
			if (seat == null) {
				return "seat_not_found";
			}
			
			if (seat.getReserved() == 0) {
				return "available";
			}
			
			// 예약된 좌석인 경우 본인 예약인지 확인
			if (sessionId.equals(seat.getReserveid())) {
				return "my_reservation";
			} else {
				return "others_reservation";
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}
}
