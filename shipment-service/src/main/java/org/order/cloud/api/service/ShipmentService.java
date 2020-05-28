package org.order.cloud.api.service;

import java.util.List;

import org.order.cloud.pojo.MessageData;
import org.order.cloud.pojo.ShipmentPojo;
import org.order.cloud.response.ShipmentResponse;

public interface ShipmentService {
ShipmentResponse save(ShipmentPojo request);
ShipmentResponse getById(Long id);
List<ShipmentResponse> getAll();
void processShipment(MessageData message);
}
