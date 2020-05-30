package org.order.cloud.api.repository;

import org.order.cloud.api.entity.Payment;

public interface PaymentDao{
Payment find(Long orderId);
}
