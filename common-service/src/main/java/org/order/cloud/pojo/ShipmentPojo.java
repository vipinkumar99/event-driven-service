package org.order.cloud.pojo;

import java.time.LocalDate;

import org.order.cloud.enums.ShipmentType;

public class ShipmentPojo {
	private Integer id;
	private ShipmentType type;
	private LocalDate date;
	private Integer price;

	public ShipmentPojo() {
		super();
	}

	public ShipmentPojo(ShipmentType type) {
		super();
		this.type = type;
	}

	public ShipmentPojo(Integer id, ShipmentType type, LocalDate date, Integer price) {
		super();
		this.id = id;
		this.type = type;
		this.date = date;
		this.price = price;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public ShipmentType getType() {
		return type;
	}

	public void setType(ShipmentType type) {
		this.type = type;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "ShipmentPojo [id=" + id + ", type=" + type + ", date=" + date + ", price=" + price + "]";
	}

}
