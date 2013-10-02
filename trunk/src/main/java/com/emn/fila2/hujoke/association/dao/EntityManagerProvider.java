package com.emn.fila2.hujoke.association.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.FlushModeType;
import javax.persistence.Persistence;

// TODO Cette classe n'est utile que parceque je n'ai pas réussi à utiliser l'injection de dépendence,
// à supprimer si on arrive à l'utiliser

public class EntityManagerProvider {
	
	private static final String UNIT_NAME = "association";
	
	private static EntityManagerFactory emf;
	private static EntityManager em;
	
	public static EntityManagerFactory getEntityManagerFactory() {
		if (emf == null) {
			emf = Persistence.createEntityManagerFactory(UNIT_NAME);
		}
		return emf;
	}
	
	public static EntityManager getEntityManager() {
		if (em == null || em.isOpen() == false) {
			em = getEntityManagerFactory().createEntityManager();
		}
		return em;
	}
}
