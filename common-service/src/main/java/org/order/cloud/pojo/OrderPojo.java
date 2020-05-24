package org.order.cloud.pojo;

import java.time.LocalDateTime;

import org.order.cloud.enums.OrderStatus;
import org.order.cloud.enums.OrderType;

public class OrderPojo {
	private Integer id;
	private OrderType type;
	private LocalDateTime createdAt;
	private OrderStatus status;
	private ProductPojo product;
	private ShipmentPojo shipment;

	public OrderPojo() {
		super();

	}

	public OrderPojo(Integer id, OrderType type, LocalDateTime createdAt, OrderStatus status, ProductPojo product,
			ShipmentPojo shipment) {
		super();
		this.id = id;
		this.type = type;
		this.createdAt = createdAt;
		this.status = status;
		this.product = product;
		this.shipment = shipment;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public OrderType getType() {
		return type;
	}

	public void setType(OrderType type) {
		this.type = type;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public ProductPojo getProduct() {
		return product;
	}

	public void setProduct(ProductPojo product) {
		this.product = product;
	}

	public ShipmentPojo getShipment() {
		return shipment;
	}

	public void setShipment(ShipmentPojo shipment) {
		this.shipment = shipment;
	}

	@Override
	public String toString() {
		return "OrderPojo [id=" + id + ", type=" + type + ", createdAt=" + createdAt + ", status=" + status + ","
				+ product.toString() + "," + shipment.toString() + "]";
	}

}
