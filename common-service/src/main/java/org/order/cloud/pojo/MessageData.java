package org.order.cloud.pojo;

import java.util.Date;

import org.order.cloud.enums.OrderStatus;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MessageData {
	private Long orderId;
	private Date created;
	private Long productId;
	private Long shipmentId;
	private Integer quantity;
	private Double productTaxAmount;
	private Double productTotalAmount;
	private Double productDiscountAmount;
	private Double shipmentTaxAmount;
	private Double shipmentTotalAmount;
	private Double shipmentDiscountAmount;
	private String productStockStatus;
	private String shipmentStatus;
	private Double totalAmountToPay;
	private OrderStatus orderStatus;
}
