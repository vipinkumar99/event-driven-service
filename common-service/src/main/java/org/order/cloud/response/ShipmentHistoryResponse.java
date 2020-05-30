package org.order.cloud.response;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(value = Include.NON_NULL)
public class ShipmentHistoryResponse {
	private Long id;
	private Long orderId;
	private Long shipmentId;
	private String name;
	private Double taxAmount;
	private Double totalAmount;
	private Double discountAmount;
	private Integer quantity;
	private String status;
	@JsonFormat(shape = Shape.STRING, pattern = "dd-MM-yyyy", timezone = "IST")
	private Date shipmentDate;
	@JsonFormat(shape = Shape.STRING, pattern = "hh:mm:ss", timezone = "IST")
	private Date shipmentTime;
	@JsonFormat(shape = Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss", timezone = "IST")
	private Date created;
}
