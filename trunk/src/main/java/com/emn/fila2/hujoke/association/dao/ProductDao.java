package com.emn.fila2.hujoke.association.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.emn.fila2.hujoke.association.model.Product;

public class ProductDao {
	public List<Product> findAll() {
		EntityManager em = EntityManagerProvider.getEntityManager();
		Query query = em.createNamedQuery("Product.findAll");
		return (List<Product>) query.getResultList();
	}

}
