package org.order.cloud.api.config;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.order.cloud.enums.ShipmentType;
import org.order.cloud.pojo.OrderPojo;
import org.order.cloud.pojo.ShipmentPojo;
import org.springframework.stereotype.Service;

@Service
public class ShipmentService {
	private List<ShipmentPojo> shipments;

	public ShipmentService() {
		shipments = new ArrayList<>();
		shipments.add(new ShipmentPojo(1, ShipmentType.CAR, LocalDate.now(), 50));
		shipments.add(new ShipmentPojo(2, ShipmentType.PLANE, LocalDate.now(), 200));
		shipments.add(new ShipmentPojo(3, ShipmentType.SHIP, LocalDate.now(), 100));
		shipments.add(new ShipmentPojo(4, ShipmentType.TRAIN, LocalDate.now(), 20));
	}

	public ShipmentPojo processOrder(OrderPojo order) {
		return shipments.stream().filter(s -> s.getType().equals(order.getShipment().getType())).findAny().get();
	}
}
