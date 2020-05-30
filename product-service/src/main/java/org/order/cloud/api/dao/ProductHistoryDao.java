package org.order.cloud.api.dao;

import org.order.cloud.api.entity.ProductHistory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductHistoryDao extends CrudRepository<ProductHistory, Long> {

}
