package org.order.cloud.api.dao;

import org.order.cloud.api.entity.Shipment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShipmentDao extends CrudRepository<Shipment, Long> {

}
