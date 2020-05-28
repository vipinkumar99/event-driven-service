package org.order.cloud.api.config;

import java.util.logging.Logger;

import org.order.cloud.api.service.ProductService;
import org.order.cloud.pojo.MessageData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.messaging.handler.annotation.SendTo;

@EnableBinding(Processor.class)
public class MessageReciever {
	private static Logger logger = Logger.getLogger(MessageReciever.class.getName());

	@Autowired
	private ProductService productService;

	@StreamListener(Processor.INPUT)
	@SendTo(Processor.OUTPUT)
	public MessageData orderProcessing(MessageData message) {
		if (message != null && message.getOrderId() != null) {
			logger.info("Order recieved for product processing:" + message.getOrderId());
			productService.processQuantity(message);
		} else {
			logger.info("Order recieved for product processing is empty");
		}
		return message;
	}
}
