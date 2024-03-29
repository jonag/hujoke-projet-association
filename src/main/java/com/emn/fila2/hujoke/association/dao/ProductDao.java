package com.emn.fila2.hujoke.association.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.emn.fila2.hujoke.association.model.Product;

@SuppressWarnings("unchecked")
public class ProductDao {
	public List<Product> findAll() {
		EntityManager em = EntityManagerProvider.getEntityManager();
		Query query = em.createNamedQuery("Product.findAll");
		return (List<Product>) query.getResultList();
	}

	public Product find(String code) {
		EntityManager em = EntityManagerProvider.getEntityManager();
		return em.find(Product.class, code);
	}

	public void merge(List<Product> products) {
		EntityManager em = EntityManagerProvider.getEntityManager();
		em.getTransaction().begin();
		for (Product p : products) {
			em.merge(p);
		}
		em.getTransaction().commit();
	}
	
	public void refresh(Product product) {
		EntityManager em = EntityManagerProvider.getEntityManager();
		em.refresh(product);
	}
}
