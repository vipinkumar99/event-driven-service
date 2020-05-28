package org.order.cloud.api.service;

import java.util.List;

import org.order.cloud.pojo.MessageData;
import org.order.cloud.pojo.OrderPojo;
import org.order.cloud.response.OrderResponse;

public interface OrderService {
	OrderResponse save(OrderPojo request);
	OrderResponse getById(Long id);
	List<OrderResponse> getAll();
	void process(MessageData message);
}
