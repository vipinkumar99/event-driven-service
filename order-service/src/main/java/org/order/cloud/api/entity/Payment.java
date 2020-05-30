package org.order.cloud.api.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Payment {
	@Id
	private Long id;
	private Long productId;
	private Long shipmentId;
	private Long orderId;
	private Double totalTaxAmount;
	private Double totalAmount;
	private Double totalDiscountAmount;
	private Double totalAmountToPay;
	private Date created;
	private Date paymentLastDate;
	private String paymentStatus;
}
