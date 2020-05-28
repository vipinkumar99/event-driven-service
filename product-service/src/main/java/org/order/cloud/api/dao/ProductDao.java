package org.order.cloud.api.dao;

import org.order.cloud.api.entity.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductDao extends CrudRepository<Product, Long> {

}
