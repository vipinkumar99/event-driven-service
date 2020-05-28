package org.order.cloud.api.mapper;

import org.order.cloud.api.entity.Order;
import org.order.cloud.enums.OrderStatus;
import org.order.cloud.pojo.MessageData;
import org.order.cloud.pojo.OrderPojo;
import org.order.cloud.response.OrderResponse;

public class OrderMapper {

	public static Order of(OrderPojo request) {
		if (request == null) {
			return null;
		}
		Order response = new Order();
		response.setDate(request.getDate());
		response.setProductId(request.getProductId());
		response.setShipmentId(request.getShipmentId());
		response.setStatus(OrderStatus.NEW);
		response.setType(request.getType());
		response.setQuantity(request.getQuantity());
		return response;
	}

	public static OrderResponse of(Order request) {
		if (request == null) {
			return null;
		}
		OrderResponse response = new OrderResponse();
		response.setId(request.getId());
		response.setCreated(request.getCreated());
		response.setDate(request.getDate());
		response.setProductId(request.getProductId());
		response.setShipmentId(request.getShipmentId());
		response.setStatus(request.getStatus());
		response.setType(request.getType());
		response.setQuantity(request.getQuantity());
		return response;
	}

	public static MessageData of(OrderResponse request) {
		if (request == null) {
			return null;
		}
		MessageData response = new MessageData();
		response.setOrderId(request.getId());
		response.setCreated(request.getCreated());
		response.setProductId(request.getProductId());
		response.setShipmentId(request.getShipmentId());
		response.setQuantity(request.getQuantity());
		return response;
	}
}
