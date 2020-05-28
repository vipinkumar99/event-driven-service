package org.order.cloud.api.convertor;

import org.order.cloud.api.entity.Payment;
import org.order.cloud.response.PaymentResponse;

public class PaymentConvertor {

	public static PaymentResponse of(Payment request) {
		if (request == null) {
			return null;
		}
		PaymentResponse response = new PaymentResponse();
		response.setId(request.getId());
		response.setProductId(request.getProductId());
		response.setShipmentId(request.getShipmentId());
		response.setOrderId(request.getOrderId());
		response.setTotalTaxAmount(request.getTotalTaxAmount());
		response.setTotalAmount(request.getTotalAmount());
		response.setTotalDiscountAmount(request.getTotalDiscountAmount());
		response.setCreated(request.getCreated());
		response.setPaymentLastDate(request.getPaymentLastDate());
		response.setTotalAmountToPay(request.getTotalAmountToPay());
		response.setPaymentStatus(request.getPaymentStatus());
		return response;
	}

	public static Payment getEntity() {
		Payment response = new Payment();
		response.setPaymentStatus("NOT_PAID");
		return response;
	}

}
