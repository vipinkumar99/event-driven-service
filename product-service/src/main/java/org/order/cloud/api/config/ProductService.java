package org.order.cloud.api.config;

import java.util.ArrayList;
import java.util.List;

import org.order.cloud.pojo.OrderPojo;
import org.order.cloud.pojo.ProductPojo;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

private List<ProductPojo> products;
	
	public ProductService() {
		products = new ArrayList<>();
		products.add(new ProductPojo(1, "Example#1", 500));
		products.add(new ProductPojo(2, "Example#2", 100));
		products.add(new ProductPojo(3, "Example#3", 1000));
		products.add(new ProductPojo(4, "Example#4", 200));
	}
	
	public ProductPojo processOrder(OrderPojo order) {
		return products.stream().filter(p -> p.getName().equals(order.getProduct().getName())).findAny().get();
	}
}
