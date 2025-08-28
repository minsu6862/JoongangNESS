package com.minsu.transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PayService {

	@Autowired
	private PayDao payDao;
	
	//트렌잭션이 적용되는 메소드
	@Transactional
	public void ProcessPayment(int product_id, int quantity) {
		
		int productPrice = 1000;
		
		payDao.inserPayment(product_id, quantity, quantity * productPrice);
		payDao.reduceStock(product_id, quantity);
		
	}
}
