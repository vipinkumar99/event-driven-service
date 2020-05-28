package org.order.cloud.api.controller;

import java.util.List;

import org.order.cloud.api.service.OrderService;
import org.order.cloud.pojo.OrderPojo;
import org.order.cloud.response.OrderResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {

	@Autowired
	private OrderService orderService;

	@PostMapping("/save")
	public OrderResponse save(@RequestBody OrderPojo request) {
		return orderService.save(request);
	}

	@GetMapping("/{id}")
	public OrderResponse getById(@PathVariable("id") Long id) {
		return orderService.getById(id);

	}

	@GetMapping("/all")
	public List<OrderResponse> getAll() {
		return orderService.getAll();

	}

}
