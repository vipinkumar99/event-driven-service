package org.order.cloud.api.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.order.cloud.api.convertor.ShipmentConvertor;
import org.order.cloud.api.dao.ShipmentDao;
import org.order.cloud.api.entity.Shipment;
import org.order.cloud.enums.ShipmentStatus;
import org.order.cloud.pojo.MessageData;
import org.order.cloud.pojo.ShipmentPojo;
import org.order.cloud.response.ShipmentResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShipmentServiceImpl implements ShipmentService {

	@Autowired
	private ShipmentDao shipmentDao;

	@Override
	public ShipmentResponse save(ShipmentPojo request) {
		Shipment entity = ShipmentConvertor.of(request);
		if (entity == null) {
			return null;
		}
		return ShipmentConvertor.of(shipmentDao.save(entity));
	}

	@Override
	public ShipmentResponse getById(Long id) {
		return ShipmentConvertor.of(shipmentDao.findById(id).orElse(null));
	}

	@Override
	public List<ShipmentResponse> getAll() {
		Iterable<Shipment> all = shipmentDao.findAll();
		if (all == null) {
			return null;
		}
		List<ShipmentResponse> response = new ArrayList<>();
		for (Shipment s : all) {
			response.add(ShipmentConvertor.of(s));
		}
		return response;
	}

	@Override
	public void processShipment(MessageData message) {
		if (message != null && message.getShipmentId() != null) {
			Optional<Shipment> optional = shipmentDao.findById(message.getShipmentId());
			if (optional.isPresent()) {
				Shipment shipment = optional.get();
				if (message.getQuantity() != null && shipment.getBookingLimit() != null) {
					if (shipment.getBookingLimit() != null && shipment.getBookingLimit() > 0) {
						Integer limit = shipment.getBookingLimit() - message.getQuantity();
						shipment.setBookingLimit(limit);
						shipmentDao.save(shipment);
						message.setShipmentStatus(ShipmentStatus.CONFIRM.name());
					} else {
						message.setShipmentStatus(ShipmentStatus.WAITING.name());
					}
				}
				message.setShipmentTaxAmount(shipment.getTaxAmount());
				message.setShipmentTotalAmount(shipment.getTotalAmount());
				message.setShipmentTotalAmount(shipment.getDiscountAmount());
			}
		}
	}

}
