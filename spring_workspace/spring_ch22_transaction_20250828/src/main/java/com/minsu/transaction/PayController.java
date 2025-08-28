package com.minsu.transaction;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PayController {
	
	@Autowired
	private PayService payService;
	
	@RequestMapping(value = "/payForm")
	public String payForm() {
		return "pay";
	}
	
	@RequestMapping(value = "/payOk")
	public String payOk(HttpServletRequest request, Model model) {
		
		int product_id = Integer.parseInt(request.getParameter("product_id"));
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		
		/*
		 * //기존 방식대로 만들면 데이터가 충돌날 경우 문제가 생길수 있음(ex. 재고는20인데 주문이 15, 10개가 동시에 들어오는 경우)
		 * PayDao payDao = new PayDao(); payDao.inserPayment(product_id, quantity,
		 * quantity * 1000); payDao.reduceStock(product_id, quantity);
		 */
		
		payService.ProcessPayment(product_id, quantity);
		
		return "pay";
	}
}	
