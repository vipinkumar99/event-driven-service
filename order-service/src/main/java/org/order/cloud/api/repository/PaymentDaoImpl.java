package org.order.cloud.api.repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.order.cloud.api.entity.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PaymentDaoImpl implements PaymentDao {

	@Autowired
	private EntityManager entityManager;

	@Override
	public Payment find(Long orderId) {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Payment> criteria = builder.createQuery(Payment.class);
		Root<Payment> root = criteria.from(Payment.class);
		criteria.where(builder.equal(root.get("orderId"), orderId));
		TypedQuery<Payment> query = entityManager.createQuery(criteria);
		return query.getSingleResult();
	}

}
