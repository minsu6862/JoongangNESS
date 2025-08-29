package com.minsu.mybatistest.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.minsu.mybatistest.dao.OrderDao;
import com.minsu.mybatistest.dto.UserOrderDto;

@Controller
public class OrderController {
	
	@Autowired
	private SqlSession sqlSession;
	
	@RequestMapping(value = "/orderlist")
	public String orderlist(HttpServletRequest request, Model model) {
		
		OrderDao orderDao = sqlSession.getMapper(OrderDao.class);
		List<UserOrderDto> userOrderDtos = orderDao.userOrderListDao("tiger");
		
		model.addAttribute("userOrderDtos", userOrderDtos);
		
		return "orderlist";
	}
}
