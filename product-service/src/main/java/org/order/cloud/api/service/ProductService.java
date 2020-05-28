package org.order.cloud.api.service;

import java.util.List;

import org.order.cloud.pojo.MessageData;
import org.order.cloud.pojo.ProductPojo;
import org.order.cloud.response.ProductResponse;

public interface ProductService {
ProductResponse save(ProductPojo request);
ProductResponse getById(Long id);
List<ProductResponse> getAll();
void processQuantity(MessageData message);
}
