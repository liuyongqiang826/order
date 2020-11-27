package com.hope.order.controller.trade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hope.risk.order.OrderRiskRelatedApi;

import lombok.extern.log4j.Log4j2;

@RestController
@Log4j2
public class GoodsOrderController {

	@Autowired
	private OrderRiskRelatedApi orderRiskRelatedApi;
	
	@PostMapping("/front/order")
	public String order(@RequestParam String orderId) {
		log.info("GoodsOrderController-order mas = {}", orderId);
		
		orderRiskRelatedApi.handleOrderAmtRisk(orderId);
		return orderId;
	}
	
}
