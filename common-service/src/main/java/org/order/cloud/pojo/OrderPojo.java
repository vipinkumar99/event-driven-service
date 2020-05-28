package org.order.cloud.pojo;

import java.util.Date;

import org.order.cloud.enums.OrderType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderPojo {
	private Long productId;
	private Long shipmentId;
	private OrderType type;
	@JsonFormat(shape = Shape.STRING, pattern = "dd-MM-yyyy", timezone = "IST")
	private Date date;
	private Integer quantity;
}
