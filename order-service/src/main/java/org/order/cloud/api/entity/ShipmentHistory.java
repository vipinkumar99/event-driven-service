package org.order.cloud.api.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class ShipmentHistory {
	@Id
	private Long id;
	private Long orderId;
	private Long shipmentId;
	private String name;
	private Double taxAmount;
	private Double totalAmount;
	private Double discountAmount;
	private Integer quantity;
	private String status;	
	private Date shipmentDate;
	private Date shipmentTime;
	private Date created;
}
