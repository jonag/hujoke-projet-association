package com.emn.fila2.hujoke.association.controller;

import java.io.IOException;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.emn.fila2.hujoke.association.exception.ServiceException;
import com.emn.fila2.hujoke.association.properties.Prop;
import com.emn.fila2.hujoke.association.service.CartService;

/**
 * Servlet implementation class Cart
 */
@WebServlet(urlPatterns={"/cart"})
public class CartController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter(Prop.get("param.action"));
		if (action != null) {
			CartService cartService = new CartService();
			try {
				if (action.equals(Prop.get("action.add"))) {
					cartService.add(request);
					request.getSession().setAttribute(Prop.get("attr.info"), "Le produit a été ajouté au panier. "+
							"<a href=\"" + request.getContextPath() + Prop.get("path.catalog") + "\">Retour au catalogue.</a>");
				} else if (action.equals(Prop.get("action.action"))) {
					cartService.remove(request);
					request.getSession().setAttribute(Prop.get("attr.info"), "Le produit a été retiré du panier.");
				} else if (action.equals(Prop.get("action.clear"))) {
					cartService.clear(request);
					request.getSession().setAttribute(Prop.get("attr.info"), "Le panier a été vidé.");
				} else if (action.equals(Prop.get("action.order"))) {
					cartService.order(request);
					request.getSession().setAttribute(Prop.get("attr.info"), "La commande a été passée.");
				}
			} catch (ServiceException e) {
				request.getSession().setAttribute(Prop.get("attr.error"), e.getMessage());
			}
			response.sendRedirect(request.getContextPath() + Prop.get("path.cart"));
		} else {
			getServletContext().getRequestDispatcher(Prop.get("view.cart")).forward(request, response);
		}
	}
}
