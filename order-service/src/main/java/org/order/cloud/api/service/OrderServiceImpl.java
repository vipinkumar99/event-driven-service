package org.order.cloud.api.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.order.cloud.api.config.MessageSender;
import org.order.cloud.api.entity.Order;
import org.order.cloud.api.mapper.OrderMapper;
import org.order.cloud.api.repository.OrderDao;
import org.order.cloud.pojo.MessageData;
import org.order.cloud.pojo.OrderPojo;
import org.order.cloud.response.OrderResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {
	@Autowired
	private OrderDao orderDao;
	@Autowired
	private MessageSender messageSender;

	@Override
	public OrderResponse save(OrderPojo request) {
		Order entity = OrderMapper.of(request);
		if (entity == null) {
			return null;
		}
		OrderResponse response = OrderMapper.of(orderDao.save(entity));
		messageSender.send(OrderMapper.of(response));
		return response;
	}

	@Override
	public OrderResponse getById(Long id) {
		return OrderMapper.of(orderDao.findById(id).orElse(null));
	}

	@Override
	public List<OrderResponse> getAll() {
		Iterable<Order> all = orderDao.findAll();
		if (all == null) {
			return null;
		}
		List<OrderResponse> res = new ArrayList<>();
		for (Order order : all) {
			res.add(OrderMapper.of(order));
		}
		return res;
	}

	@Override
	public void process(MessageData message) {
		if (message.getOrderId() != null) {
			Optional<Order> optional = orderDao.findById(message.getOrderId());
			if (optional.isPresent()) {
				Order order = optional.get();
				order.setProductStockStatus(message.getProductStockStatus());
				order.setShipmentStatus(message.getShipmentStatus());
				order.setStatus(message.getOrderStatus());
				order.setTotalAmountToPay(message.getTotalAmountToPay());
				orderDao.save(order);
			}
		}
	}

}
