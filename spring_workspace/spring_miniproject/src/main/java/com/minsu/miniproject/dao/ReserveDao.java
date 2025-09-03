package com.minsu.miniproject.dao;

import java.util.List;
import java.util.Map;

import com.minsu.miniproject.dto.ReserveDto;

public interface ReserveDao {
	List<ReserveDto> selectAllSeats();
	int updateSeatReservation(Map<String, Object> params);
    int cancelSeatReservation(String seatname);
    ReserveDto selectSeatByName(String seatname);
}
