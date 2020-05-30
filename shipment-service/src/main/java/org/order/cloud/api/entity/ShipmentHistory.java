package org.order.cloud.api.entity;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "shipmentHistory")
public class ShipmentHistory {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Long orderId;
	private Long shipmentId;
	private String name;
	private Double taxAmount;
	private Double totalAmount;
	private Double discountAmount;
	private Integer quantity;
	private String status;
	@Basic
	@Temporal(TemporalType.DATE)
	private Date shipmentDate;
	@Basic
	@Temporal(TemporalType.TIME)
	private Date shipmentTime;
	@CreationTimestamp
	private Date created;
}
