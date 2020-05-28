package org.order.cloud.api.repository;

import org.order.cloud.api.entity.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDao extends CrudRepository<Order, Long> {

}
