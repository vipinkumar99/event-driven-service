package org.order.cloud.api.mapper;

import org.order.cloud.api.entity.Order;
import org.order.cloud.api.entity.Payment;
import org.order.cloud.api.entity.ProductHistory;
import org.order.cloud.api.entity.ShipmentHistory;
import org.order.cloud.enums.OrderStatus;
import org.order.cloud.pojo.MessageData;
import org.order.cloud.pojo.OrderPojo;
import org.order.cloud.response.OrderResponse;
import org.order.cloud.response.PaymentResponse;
import org.order.cloud.response.ProductHistoryResponse;
import org.order.cloud.response.ShipmentHistoryResponse;

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

	public static PaymentResponse of(Payment request) {
		if (request == null) {
			return null;
		}
		PaymentResponse response = new PaymentResponse();
		response.setId(request.getId());
		response.setTotalTaxAmount(request.getTotalTaxAmount());
		response.setTotalAmount(request.getTotalAmount());
		response.setTotalDiscountAmount(request.getTotalDiscountAmount());
		response.setCreated(request.getCreated());
		response.setPaymentLastDate(request.getPaymentLastDate());
		response.setTotalAmountToPay(request.getTotalAmountToPay());
		response.setPaymentStatus(request.getPaymentStatus());
		return response;
	}

	public static ProductHistoryResponse of(ProductHistory product) {
		ProductHistoryResponse history = new ProductHistoryResponse();
		history.setId(product.getId());
		history.setName(product.getName());
		history.setTaxAmount(product.getTaxAmount());
		history.setTotalAmount(product.getTotalAmount());
		history.setDiscountAmount(product.getDiscountAmount());
		history.setQuantity(product.getQuantity());
		history.setStatus(product.getStatus());
		return history;
	}

	public static ShipmentHistoryResponse of(ShipmentHistory shipment) {
		ShipmentHistoryResponse history = new ShipmentHistoryResponse();
		history.setId(shipment.getId());
		history.setName(shipment.getName());
		history.setQuantity(shipment.getQuantity());
		history.setTotalAmount(shipment.getTotalAmount());
		history.setDiscountAmount(shipment.getDiscountAmount());
		history.setTaxAmount(shipment.getTaxAmount());
		history.setStatus(shipment.getStatus());
		history.setShipmentTime(shipment.getShipmentTime());
		history.setShipmentDate(shipment.getShipmentDate());
		history.setCreated(shipment.getCreated());
		return history;
	}

	public static OrderResponse getResponse(Order request) {
		if (request == null) {
			return null;
		}
		OrderResponse response = new OrderResponse();
		response.setId(request.getId());
		response.setCreated(request.getCreated());
		response.setDate(request.getDate());
		response.setStatus(request.getStatus());
		response.setType(request.getType());
		response.setQuantity(request.getQuantity());
		return response;
	}
}
