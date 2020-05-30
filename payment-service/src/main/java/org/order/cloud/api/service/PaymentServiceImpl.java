package org.order.cloud.api.service;

import org.order.cloud.api.convertor.PaymentConvertor;
import org.order.cloud.api.dao.PaymentDao;
import org.order.cloud.api.entity.Payment;
import org.order.cloud.enums.OrderStatus;
import org.order.cloud.pojo.MessageData;
import org.order.cloud.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class PaymentServiceImpl implements PaymentService {

	@Autowired
	private PaymentDao paymentDao;

	@Override
	public void calculatePayment(MessageData message) {
		double totalTaxAmount = 0d;
		double totalAmount = 0d;
		double totalDiscountAmount = 0d;
		if (message != null) {
			Payment payment = PaymentConvertor.getEntity();
			payment.setOrderId(message.getOrderId());
			payment.setPaymentLastDate(DateUtil.modifyDate(message.getCreated(), 0, 0, 1));
			payment.setProductId(message.getProductId());
			payment.setShipmentId(message.getShipmentId());
			if (message.getProductTaxAmount() != null) {
				totalTaxAmount += message.getProductTaxAmount();
			}
			if (message.getProductDiscountAmount() != null) {
				totalDiscountAmount += message.getProductDiscountAmount();
			}
			if (message.getProductTotalAmount() != null) {
				totalAmount += message.getProductTotalAmount();
			}
			if (message.getShipmentTaxAmount() != null) {
				totalTaxAmount += message.getShipmentTaxAmount();
			}
			if (message.getShipmentDiscountAmount() != null) {
				totalDiscountAmount += message.getShipmentDiscountAmount();
			}
			if (message.getShipmentTotalAmount() != null) {
				totalAmount += message.getShipmentTotalAmount();
			}
			payment.setTotalAmount(totalAmount);
			payment.setTotalDiscountAmount(totalDiscountAmount);
			payment.setTotalTaxAmount(totalTaxAmount);
			double totalAmountToPay = totalAmount - (totalTaxAmount + totalDiscountAmount);
			payment.setTotalAmountToPay(totalAmountToPay);
			paymentDao.save(payment);
			message.setTotalAmountToPay(totalAmountToPay);
			if (!StringUtils.isEmpty(message.getProductStockStatus())
					&& !StringUtils.isEmpty(message.getShipmentStatus())) {
				if (message.getProductStockStatus().equals("PRESENT_IN_STOCK")
						&& message.getShipmentStatus().equals("CONFIRM")) {
					message.setOrderStatus(OrderStatus.DONE);
				} else {
					message.setOrderStatus(OrderStatus.PROCESSING);
				}
			} else {
				message.setOrderStatus(OrderStatus.ERROR);
			}
		}
	}

}
