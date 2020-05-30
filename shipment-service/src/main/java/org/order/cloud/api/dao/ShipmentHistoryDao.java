package org.order.cloud.api.dao;

import org.order.cloud.api.entity.ShipmentHistory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShipmentHistoryDao extends CrudRepository<ShipmentHistory, Long>{
}
