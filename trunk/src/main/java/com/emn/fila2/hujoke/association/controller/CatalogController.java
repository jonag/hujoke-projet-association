package com.emn.fila2.hujoke.association.controller;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.emn.fila2.hujoke.association.model.Product;

/**
 * Servlet implementation class Catalog
 */
@WebServlet(urlPatterns={"/catalog"})
public class CatalogController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/**
	 * La vue à afficher 
	 */
	private static final String VIEW = "/WEB-INF/jsp/catalog.jsp";

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// /!\ Uniquement pour tester la connexion à la base de données, il faut déplacer ce traitement dans un service /!\
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("association");
		EntityManager em = emf.createEntityManager();
		Query query = em.createNamedQuery("Product.findAll");
		List<Product> products = query.getResultList(); // C'est cette liste que doit nous retourner notre service
		// /!\ Fin traitement à déplacer dans un service /!\
		
		// On transmet la liste des produits à la vue
		request.setAttribute("products", products);
		getServletContext().getRequestDispatcher(VIEW).forward(request, response);
	}
}
