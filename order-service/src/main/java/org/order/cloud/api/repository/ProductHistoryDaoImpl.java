package org.order.cloud.api.repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.order.cloud.api.entity.ProductHistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ProductHistoryDaoImpl implements ProductHistoryDao {

	@Autowired
	private EntityManager entityManager;

	@Override
	public ProductHistory findOrder(Long orderId) {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<ProductHistory> criteria = builder.createQuery(ProductHistory.class);
		Root<ProductHistory> root = criteria.from(ProductHistory.class);
		criteria.where(builder.equal(root.get("orderId"), orderId));
		TypedQuery<ProductHistory> query = entityManager.createQuery(criteria);
		return query.getSingleResult();
	}

}
