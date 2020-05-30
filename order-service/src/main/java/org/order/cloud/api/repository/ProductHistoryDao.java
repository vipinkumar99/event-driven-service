package org.order.cloud.api.repository;

import org.order.cloud.api.entity.ProductHistory;

public interface ProductHistoryDao {
ProductHistory findOrder(Long orderId);
}
