package com.minsu.transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class PayDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	//결제내역 DB에 저장하는 메서드
	public void inserPayment(int product_id, int quantity, int payment_amount) {
		String sql = "INSERT INTO payment(product_id, quantity, payment_amount) VALUES (?, ?, ?)";
		jdbcTemplate.update(sql, product_id, quantity, payment_amount);
	}
	
	//결제내역에 따라 재고 차감하는 메서드
	public void reduceStock(int product_id, int quantity) {
		String sql = "UPDATE product SET product_stock = product_stock - ? WHERE product_id = ?";
		
		//업데이트가 완료된 레코드의 수 반환
		int result = jdbcTemplate.update(sql, quantity, product_id);
		
		if(result == 0) {
			throw new RuntimeException("재고 수량 에러");
		}
	}
	
}
