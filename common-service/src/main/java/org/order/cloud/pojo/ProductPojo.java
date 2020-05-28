package org.order.cloud.pojo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductPojo {
	private String name;
	private Double taxAmount;
	private Double totalAmount;
	private Double discountAmount;
	private Integer quantity;
}
