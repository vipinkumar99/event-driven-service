package org.order.cloud.api.config;

import java.util.logging.Logger;

import org.order.cloud.api.service.PaymentService;
import org.order.cloud.pojo.MessageData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.messaging.handler.annotation.SendTo;

//@EnableBinding(Sink.class)
@EnableBinding(Processor.class)
public class MessageReciever {
	private static Logger logger = Logger.getLogger(MessageReciever.class.getName());

	@Autowired
	private PaymentService paymentService;

//	@StreamListener(Sink.INPUT)
//	public void orderProcessing(MessageData message) {
//		if (message != null) {
//			logger.info("Order recieved for payment processing:" + message.getOrderId());
//			paymentService.calculatePayment(message);
//		} else {
//			logger.info("Order recieved for payment processing is empty");
//		}
//	}

	@StreamListener(Processor.INPUT)
	@SendTo(Processor.OUTPUT)
	public MessageData orderProcessing(MessageData message) {
		if (message != null && message.getOrderId() != null) {
			logger.info("Order recieved for payment processing:" + message.getOrderId());
			paymentService.calculatePayment(message);
		} else {
			logger.info("Order recieved for payment processing is empty");
		}
		return message;
	}
}
