package org.order.cloud.api.convertor;

import org.order.cloud.api.entity.Shipment;
import org.order.cloud.pojo.ShipmentPojo;
import org.order.cloud.response.ShipmentResponse;

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

}
