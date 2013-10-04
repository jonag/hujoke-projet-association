package com.emn.fila2.hujoke.association.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.emn.fila2.hujoke.association.dao.ProductDao;
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
		ProductDao productDao = new ProductDao();
		List<Product> products = productDao.findAll();
		
		// On transmet la liste des produits à la vue
		request.setAttribute("products", products);
		getServletContext().getRequestDispatcher(VIEW).forward(request, response);
	}
}