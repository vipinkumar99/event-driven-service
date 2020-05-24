package org.order.cloud.api.controller;

import org.order.cloud.pojo.OrderPojo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {

	@PostMapping("/save")
	public boolean save(@RequestBody OrderPojo request) {
		return false;

	}

}
