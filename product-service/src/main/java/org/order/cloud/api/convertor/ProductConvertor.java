package org.order.cloud.api.convertor;

import org.order.cloud.api.entity.Product;
import org.order.cloud.api.entity.ProductHistory;
import org.order.cloud.pojo.MessageData;
import org.order.cloud.pojo.ProductPojo;
import org.order.cloud.response.ProductResponse;

public class ProductConvertor {

	public static ProductResponse of(Product request) {
		if (request == null) {
			return null;
		}
		ProductResponse response = new ProductResponse();
		response.setId(request.getId());
		response.setName(request.getName());
		response.setTaxAmount(request.getTaxAmount());
		response.setDiscountAmount(request.getDiscountAmount());
		response.setTotalAmount(request.getTotalAmount());
		response.setQuantity(request.getQuantity());
		return response;
	}

	public static Product of(ProductPojo request) {
		if (request == null) {
			return null;
		}
		Product response = new Product();
		response.setName(request.getName());
		response.setTaxAmount(request.getTaxAmount());
		response.setDiscountAmount(request.getDiscountAmount());
		response.setTotalAmount(request.getTotalAmount());
		response.setQuantity(request.getQuantity());
		return response;
	}

	public static ProductHistory of(MessageData message, Product product) {
		ProductHistory history = new ProductHistory();
		history.setName(product.getName());
		history.setOrderId(message.getOrderId());
		history.setProductId(message.getProductId());
		history.setTaxAmount(product.getTaxAmount());
		history.setTotalAmount(product.getTotalAmount());
		history.setDiscountAmount(product.getDiscountAmount());
		history.setQuantity(message.getQuantity());
		history.setStatus(message.getProductStockStatus());
		return history;
	}

}
