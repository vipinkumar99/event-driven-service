package org.order.cloud.response;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(value = Include.NON_NULL)
public class PaymentResponse {
	private Long id;
	private Long productId;
	private Long shipmentId;
	private Long orderId;
	private Double totalTaxAmount;
	private Double totalAmount;
	private Double totalDiscountAmount;
	private Double totalAmountToPay;
	@JsonFormat(shape = Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss", timezone = "IST")
	private Date created;
	@JsonFormat(shape = Shape.STRING, pattern = "dd-MM-yyyy", timezone = "IST")
	private Date paymentLastDate;
	private String paymentStatus;
}
