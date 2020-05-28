package org.order.cloud.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import brave.sampler.Sampler;

//@EnableBinding(Sink.class)
@SpringBootApplication
public class PaymentApplication {
	//protected Logger logger = Logger.getLogger(PaymentApplication.class.getName());

//	@Autowired
//	private MessageReciever paymentService;

	public static void main(String[] args) {
		SpringApplication.run(PaymentApplication.class, args);
	}

//	@StreamListener(Sink.INPUT)
//	public void processOrder(OrderPojo order) {
//		logger.info("Processing order: " + order);
//		OrderPojo o = paymentService.processOrder(order);
//		if (o != null && o.getProduct() != null && o.getShipment() != null)
//			logger.info("Final response=========>" + (o.getProduct().getPrice() + o.getShipment().getPrice()));
//	}

	@Bean
	public Sampler defaultSampler() {
		return Sampler.ALWAYS_SAMPLE;
	}
}
