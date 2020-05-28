package org.order.cloud.response;

import java.util.Date;

import org.order.cloud.enums.OrderStatus;
import org.order.cloud.pojo.OrderPojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderResponse extends OrderPojo {
	private Long id;
	@JsonFormat(shape = Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss", timezone = "IST")
	private Date created;
	private OrderStatus status;
}
