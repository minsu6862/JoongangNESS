package com.minsu.mybatistest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserOrderDto {
	private String user_id, user_name;
	private int order_id;
	private String order_name;
}
