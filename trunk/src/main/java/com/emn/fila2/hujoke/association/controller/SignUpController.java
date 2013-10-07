package com.emn.fila2.hujoke.association.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.emn.fila2.hujoke.association.exception.ServiceException;
import com.emn.fila2.hujoke.association.model.User;
import com.emn.fila2.hujoke.association.service.SignUpFormService;
import com.emn.fila2.hujoke.association.tools.Prop;

/**
 * Servlet implementation class SignUpController
 */
@WebServlet(urlPatterns={"/sign-up"})
public class SignUpController extends HttpServlet {
	private static final long serialVersionUID = 2650413671545548254L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		getServletContext().getRequestDispatcher(Prop.get("view.signup")).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SignUpFormService signUpForm = new SignUpFormService();
		try {
			// Le service se charge de vérifier l'utilisateur et de créer l'utilisateur qu'il nous retourne ensuite
			User user = signUpForm.createUser(request);
			
			// L'identification s'est bien déroulée, on stocke l'objet en session et on redirige l'utilisateur vers la page d'accueil
			request.getSession().setAttribute(Prop.get("attr.usersession"), user);
			request.getSession().setAttribute(Prop.get("attr.info"), "Votre compte a été créé.");
			response.sendRedirect(request.getContextPath() + Prop.get("path.index"));
		} catch (ServiceException e) {
			// Si une erreur survient pendant l'inscription on renvoi l'utilisateur vers la page d'inscription et on affiche le message d'erreur
			request.getSession().setAttribute(Prop.get("attr.error"), e.getMessage());
			getServletContext().getRequestDispatcher(Prop.get("view.signup")).forward(request, response);
		}
	}
}
