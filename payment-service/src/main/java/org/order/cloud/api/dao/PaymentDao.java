package org.order.cloud.api.dao;

import org.order.cloud.api.entity.Payment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentDao extends CrudRepository<Payment, Long> {

}
