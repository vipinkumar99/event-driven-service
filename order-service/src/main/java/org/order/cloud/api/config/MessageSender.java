package org.order.cloud.api.config;

import java.util.logging.Logger;

import org.order.cloud.pojo.MessageData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.support.MessageBuilder;

@EnableBinding(Source.class)
public class MessageSender {
	private static Logger logger = Logger.getLogger(MessageSender.class.getName());

	@Autowired
	private Source source;

	public void send(MessageData message) {
		if (message != null && message.getOrderId() != null) {
			logger.info("Order send for processing:" + message.getOrderId());
			source.output().send(MessageBuilder.withPayload(message).build());
		} else {
			logger.info("Order is empty unable to send message!");
		}
	}
}
