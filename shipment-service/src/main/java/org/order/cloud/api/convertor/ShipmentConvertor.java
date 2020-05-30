package org.order.cloud.api.convertor;

import java.util.Date;

import org.order.cloud.api.entity.Shipment;
import org.order.cloud.api.entity.ShipmentHistory;
import org.order.cloud.pojo.MessageData;
import org.order.cloud.pojo.ShipmentPojo;
import org.order.cloud.response.ShipmentResponse;
import org.order.cloud.util.DateUtil;

public class ShipmentConvertor {

	public static ShipmentResponse of(Shipment request) {
		if (request == null) {
			return null;
		}
		ShipmentResponse response = new ShipmentResponse();
		response.setId(request.getId());
		response.setName(request.getName());
		response.setTaxAmount(request.getTaxAmount());
		response.setDiscountAmount(request.getDiscountAmount());
		response.setTotalAmount(request.getTotalAmount());
		response.setBookingLimit(request.getBookingLimit());
		return response;
	}

	public static Shipment of(ShipmentPojo request) {
		if (request == null) {
			return null;
		}
		Shipment response = new Shipment();
		response.setName(request.getName());
		response.setTaxAmount(request.getTaxAmount());
		response.setDiscountAmount(request.getDiscountAmount());
		response.setTotalAmount(request.getTotalAmount());
		response.setBookingLimit(request.getBookingLimit());
		return response;
	}

	public static ShipmentHistory of(MessageData message, Shipment shipment) {
		ShipmentHistory history = new ShipmentHistory();
		history.setOrderId(message.getOrderId());
		history.setShipmentId(message.getShipmentId());
		history.setName(shipment.getName());
		history.setQuantity(message.getQuantity());
		history.setTotalAmount(shipment.getTotalAmount());
		history.setDiscountAmount(shipment.getDiscountAmount());
		history.setTaxAmount(shipment.getTaxAmount());
		history.setStatus(message.getShipmentStatus());
		Date date = DateUtil.modifyDate(message.getCreated(), 0, 0, 2);
		history.setShipmentTime(date);
		history.setShipmentDate(date);
		return history;
	}
}
