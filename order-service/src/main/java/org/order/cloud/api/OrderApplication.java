package org.order.cloud.api;

import java.time.LocalDateTime;
import java.util.logging.Logger;

import org.order.cloud.enums.OrderStatus;
import org.order.cloud.enums.OrderType;
import org.order.cloud.enums.ShipmentType;
import org.order.cloud.pojo.OrderPojo;
import org.order.cloud.pojo.ProductPojo;
import org.order.cloud.pojo.ShipmentPojo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Poller;
import org.springframework.integration.core.MessageSource;
import org.springframework.messaging.support.GenericMessage;

import brave.sampler.Sampler;

@EnableBinding(Source.class)
@SpringBootApplication
public class OrderApplication {
	protected Logger logger = Logger.getLogger(OrderApplication.class.getName());
	private int index = 0;

	public static void main(String[] args) {
		SpringApplication.run(OrderApplication.class, args);
	}

	@Bean
	@InboundChannelAdapter(value = Source.OUTPUT, poller = @Poller(fixedDelay = "10000", maxMessagesPerPoll = "1"))
	public MessageSource<OrderPojo> orderSource() {
		return () -> {
			OrderPojo o = new OrderPojo(index++, OrderType.PURCHASE, LocalDateTime.now(), OrderStatus.NEW,
					new ProductPojo("Example#2"), new ShipmentPojo(ShipmentType.SHIP));
			logger.info("Sending order: " + o);
			return new GenericMessage<>(o);
		};
	}

	@Bean
	public Sampler defaultSampler() {
		return Sampler.ALWAYS_SAMPLE;
	}
}
