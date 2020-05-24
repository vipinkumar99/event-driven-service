package org.order.cloud.api;

import java.util.logging.Logger;

import org.order.cloud.api.config.ProductService;
import org.order.cloud.pojo.OrderPojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.handler.annotation.SendTo;

import brave.sampler.Sampler;

@EnableBinding(Processor.class)
@SpringBootApplication
public class ProductApplication {

	@Autowired
	private ProductService productService;

	protected Logger logger = Logger.getLogger(ProductApplication.class.getName());

	public static void main(String[] args) {
		SpringApplication.run(ProductApplication.class, args);
	}

	@StreamListener(Processor.INPUT)
	@SendTo(Processor.OUTPUT)
	public OrderPojo processOrder(OrderPojo order) {
		logger.info("Processing order: " + order);
		order.setProduct(productService.processOrder(order));
		logger.info("Output order: " + order);
		return order;
	}

	@Bean
	public Sampler defaultSampler() {
		return Sampler.ALWAYS_SAMPLE;
	}
}
