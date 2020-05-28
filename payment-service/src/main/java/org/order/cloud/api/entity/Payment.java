package org.order.cloud.api.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "payment")
public class Payment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Long productId;
	private Long shipmentId;
	private Long orderId;
	private Double totalTaxAmount;
	private Double totalAmount;
	private Double totalDiscountAmount;
	private Double totalAmountToPay;
	@CreationTimestamp
	private Date created;
	private Date paymentLastDate;
	private String paymentStatus;
}
