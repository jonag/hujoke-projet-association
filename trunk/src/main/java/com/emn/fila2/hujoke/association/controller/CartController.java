package com.emn.fila2.hujoke.association.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Cart
 */
@WebServlet(urlPatterns={"/cart"})
public class CartController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/**
	 * La vue à afficher
	 */
	private static final String VIEW = "/WEB-INF/jsp/cart.jsp";

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		getServletContext().getRequestDispatcher(VIEW).forward(request, response);
	}
}
