package org.order.cloud.api.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.order.cloud.api.convertor.ProductConvertor;
import org.order.cloud.api.dao.ProductDao;
import org.order.cloud.api.entity.Product;
import org.order.cloud.enums.ProductStockStatus;
import org.order.cloud.pojo.MessageData;
import org.order.cloud.pojo.ProductPojo;
import org.order.cloud.response.ProductResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDao productDao;

	@Override
	public ProductResponse save(ProductPojo request) {
		Product entity = ProductConvertor.of(request);
		if (entity == null) {
			return null;
		}
		return ProductConvertor.of(productDao.save(entity));
	}

	@Override
	public ProductResponse getById(Long id) {
		return ProductConvertor.of(productDao.findById(id).orElse(null));
	}

	@Override
	public List<ProductResponse> getAll() {
		Iterable<Product> all = productDao.findAll();
		if (all == null) {
			return null;
		}
		List<ProductResponse> response = new ArrayList<>();
		for (Product s : all) {
			response.add(ProductConvertor.of(s));
		}
		return response;
	}

	@Override
	public void processQuantity(MessageData message) {
		if (message != null && message.getProductId() != null) {
			Optional<Product> optional = productDao.findById(message.getProductId());
			if (optional.isPresent()) {
				Product product = optional.get();
				if (message.getQuantity() != null) {
					if (product.getQuantity() != null && product.getQuantity() > 0) {
						Integer qty = product.getQuantity() - message.getQuantity();
						product.setQuantity(qty);
						productDao.save(product);
						message.setProductStockStatus(ProductStockStatus.PRESENT_IN_STOCK.name());
					} else {
						message.setProductStockStatus(ProductStockStatus.NOT_PRESENT_IN_STOCK.name());
					}
				}
				message.setProductTaxAmount(product.getTaxAmount());
				message.setProductTotalAmount(product.getTotalAmount());
				message.setProductDiscountAmount(product.getDiscountAmount());
			}
		}
	}

}
