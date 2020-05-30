package org.order.cloud.api.repository;

import org.order.cloud.api.entity.ShipmentHistory;

public interface ShipmentHistoryDao {
ShipmentHistory find(Long orderId);
}
