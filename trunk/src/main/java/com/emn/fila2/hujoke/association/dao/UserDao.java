package com.emn.fila2.hujoke.association.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.emn.fila2.hujoke.association.model.User;

public class UserDao {
	
	// TODO Je n'ai pas réussi à utiliser l'injection de dépendence (via @PersistenceContext) pour récupérer l'EntityManager
	// j'utilise donc un pattern singleton à la place...
	
	public void creer(User user) {
		EntityManager em = EntityManagerProvider.getEntityManager();
		em.getTransaction().begin();
		em.persist(user);
		em.getTransaction().commit();
	}
	
	public User findByLogin(String login) {
		Query query = EntityManagerProvider.getEntityManager().createNamedQuery("User.findByLogin");
		query.setParameter("login", login);
		List<User> result = query.getResultList();
		if (result.isEmpty() == false) {
			return result.get(0);
		} else {
			return null;
		}
	}

}
