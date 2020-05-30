package org.order.cloud.api.repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.order.cloud.api.entity.ShipmentHistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ShipmentHistoryDaoImpl implements ShipmentHistoryDao {

	@Autowired
	private EntityManager entityManager;

	@Override
	public ShipmentHistory find(Long orderId) {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<ShipmentHistory> criteria = builder.createQuery(ShipmentHistory.class);
		Root<ShipmentHistory> root = criteria.from(ShipmentHistory.class);
		criteria.where(builder.equal(root.get("orderId"), orderId));
		TypedQuery<ShipmentHistory> query = entityManager.createQuery(criteria);
		return query.getSingleResult();
	}

}
