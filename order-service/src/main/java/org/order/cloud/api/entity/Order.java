package org.order.cloud.api.entity;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicUpdate;
import org.order.cloud.enums.OrderStatus;
import org.order.cloud.enums.OrderType;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@DynamicUpdate
@Entity
@Table(name = "customerOrders")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Enumerated(EnumType.STRING)
	@Column(columnDefinition = OrderType.COL_DEF, nullable = false)
	private OrderType type;
	@Basic
	@Temporal(TemporalType.DATE)
	private Date date;
	@CreationTimestamp
	private Date created;
	@Enumerated(EnumType.STRING)
	@Column(columnDefinition = OrderStatus.COL_DEF, nullable = false)
	private OrderStatus status;
	private Long productId;
	private Long shipmentId;
	private Integer quantity;
	private String productStockStatus;
	private String shipmentStatus;
	private Double totalAmountToPay;

}
