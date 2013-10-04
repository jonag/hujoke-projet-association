package com.emn.fila2.hujoke.association.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.emn.fila2.hujoke.association.exception.ServiceException;
import com.emn.fila2.hujoke.association.service.CartService;

/**
 * Servlet implementation class Cart
 */
@WebServlet(urlPatterns={"/cart"})
public class CartController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final String VIEW = "/WEB-INF/jsp/cart.jsp";
	private static final String PATH_CART = "/cart";
	private static final String PARAM_ACTION = "action";
	private static final String ACTION_ADD = "add";
	private static final String ACTION_REMOVE = "remove";
	private static final String ATTR_ERROR = "error";

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter(PARAM_ACTION);
		if (action != null) {
			CartService cartService = new CartService();
			if (action.equals(ACTION_ADD)) {
				try {
					cartService.add(request);
				} catch (ServiceException e) {
					request.getSession().setAttribute(ATTR_ERROR, e.getMessage());
				}
			} else if (action.equals(ACTION_REMOVE)) {
				try {
					cartService.remove(request);
				} catch (ServiceException e) {
					request.getSession().setAttribute(ATTR_ERROR, e.getMessage());
				}
			}
			response.sendRedirect(request.getContextPath() + PATH_CART);
		} else {
			getServletContext().getRequestDispatcher(VIEW).forward(request, response);
		}
	}
}
