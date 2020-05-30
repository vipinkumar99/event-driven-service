package org.order.cloud.api.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.order.cloud.api.config.MessageSender;
import org.order.cloud.api.entity.Order;
import org.order.cloud.api.mapper.OrderMapper;
import org.order.cloud.api.repository.OrderDao;
import org.order.cloud.api.repository.PaymentDao;
import org.order.cloud.api.repository.ProductHistoryDao;
import org.order.cloud.api.repository.ShipmentHistoryDao;
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
	@Autowired
	private ProductHistoryDao productHistoryDao;
	@Autowired
	private ShipmentHistoryDao shipmentHistoryDao;
	@Autowired
	private PaymentDao paymentDao;

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
		return getResponse(orderDao.findById(id).orElse(null));
	}

	@Override
	public List<OrderResponse> getAll() {
		return getResponseList(orderDao.findAll());
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

	private List<OrderResponse> getResponseList(Iterable<Order> entities) {
		if (entities == null) {
			return new ArrayList<>();
		}
		List<OrderResponse> responseList = new ArrayList<>();
		for (Order order : entities) {
			responseList.add(getResponse(order));
		}
		return responseList;
	}

	private OrderResponse getResponse(Order entity) {
		OrderResponse response = OrderMapper.getResponse(orderDao.save(entity));
		if (response != null) {
			response.setPaymentDetails(OrderMapper.of(paymentDao.find(entity.getId())));
			response.setShipmentDetails(OrderMapper.of(shipmentHistoryDao.find(entity.getId())));
			response.setProductDetails(OrderMapper.of(productHistoryDao.findOrder(entity.getId())));
		}
		return response;
	}

}
