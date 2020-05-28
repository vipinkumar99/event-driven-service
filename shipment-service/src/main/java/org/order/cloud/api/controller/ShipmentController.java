package org.order.cloud.api.controller;

import java.util.List;

import org.order.cloud.api.service.ShipmentService;
import org.order.cloud.pojo.ShipmentPojo;
import org.order.cloud.response.ShipmentResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shipments")
public class ShipmentController {

	@Autowired
	private ShipmentService shipmentService;

	@PostMapping("/save")
	public ShipmentResponse save(@RequestBody ShipmentPojo request) {
		return shipmentService.save(request);
	}

	@GetMapping("/{id}")
	public ShipmentResponse getById(@PathVariable("id") Long id) {
		return shipmentService.getById(id);

	}

	@GetMapping("/all")
	public List<ShipmentResponse> getAll() {
		return shipmentService.getAll();

	}
}
