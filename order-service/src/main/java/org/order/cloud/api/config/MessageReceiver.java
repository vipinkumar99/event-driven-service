package org.order.cloud.api.config;

import java.util.logging.Logger;

import org.order.cloud.api.service.OrderService;
import org.order.cloud.pojo.MessageData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

@EnableBinding(Sink.class)
public class MessageReceiver {
	private static Logger logger = Logger.getLogger(MessageReceiver.class.getName());

	@Autowired
	private OrderService orderService;

	@StreamListener(Sink.INPUT)
	public void receiver(MessageData message) {
		if (message != null) {
			logger.info("Order recived after processing:" + message.getOrderId());
			orderService.process(message);
		}

	}
}
