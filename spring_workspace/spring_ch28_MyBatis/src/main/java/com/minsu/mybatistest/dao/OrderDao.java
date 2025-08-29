package com.minsu.mybatistest.dao;

import java.util.List;

import com.minsu.mybatistest.dto.UserOrderDto;

public interface OrderDao {
	
	public List<UserOrderDto> userOrderListDao(String user_id);
	
	
}
