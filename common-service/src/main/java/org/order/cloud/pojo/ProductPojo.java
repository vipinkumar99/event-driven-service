package org.order.cloud.pojo;

public class ProductPojo {
	private Integer id;
	private String name;
	private Integer price;

	public ProductPojo() {
		super();
	}

	public ProductPojo(String name) {
		super();
		this.name = name;
	}

	public ProductPojo(Integer id, Integer price) {
		super();
		this.id = id;
		this.price = price;
	}

	public ProductPojo(Integer id, String name, Integer price) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "ProductPojo [id=" + id + ", name=" + name + ", price=" + price + "]";
	}

}
