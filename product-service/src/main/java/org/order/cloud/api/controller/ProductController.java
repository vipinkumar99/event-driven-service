package org.order.cloud.api.controller;

import java.util.List;

import org.order.cloud.api.service.ProductService;
import org.order.cloud.pojo.ProductPojo;
import org.order.cloud.response.ProductResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private ProductService productService;

	@PostMapping("/save")
	public ProductResponse save(@RequestBody ProductPojo request) {
		return productService.save(request);
	}

	@GetMapping("/{id}")
	public ProductResponse getById(@PathVariable("id") Long id) {
		return productService.getById(id);

	}

	@GetMapping("/all")
	public List<ProductResponse> getAll() {
		return productService.getAll();

	}
}
