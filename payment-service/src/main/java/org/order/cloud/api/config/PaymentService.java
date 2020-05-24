package org.order.cloud.api.config;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.order.cloud.pojo.OrderPojo;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {
	private List<OrderPojo> orders = new ArrayList<>();

	public OrderPojo processOrder(OrderPojo order) {
		Optional<OrderPojo> oo = orders.stream().filter(o -> o.getId().intValue() == order.getId().intValue())
				.findFirst();
		if (oo.isPresent()) {
			OrderPojo o = oo.get();
			if (o.getProduct().getId() != null)
				order.setProduct(o.getProduct());
			else if (o.getShipment().getId() != null)
				order.setShipment(o.getShipment());
			return order;
		} else
			orders.add(order);
		return null;
	}

}
