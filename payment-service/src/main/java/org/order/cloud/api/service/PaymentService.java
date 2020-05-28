package org.order.cloud.api.service;

import org.order.cloud.pojo.MessageData;

public interface PaymentService {
void calculatePayment(MessageData message);
}
