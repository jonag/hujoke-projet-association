package com.emn.fila2.hujoke.association.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.emn.fila2.hujoke.association.exception.ServiceException;
import com.emn.fila2.hujoke.association.model.User;
import com.emn.fila2.hujoke.association.properties.Prop;
import com.emn.fila2.hujoke.association.service.SignInFormService;

/**
 * Servlet implementation class SignIn
 */
@WebServlet(urlPatterns={"/sign-in"})
public class SignInController extends HttpServlet {

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		getServletContext().getRequestDispatcher(Prop.get("view.signin")).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SignInFormService signInForm = new SignInFormService();
		try {
			// Le service de connexion se charge de vérifier le formulaire et nous retourne l'utilisateur connecté
			User user = signInForm.connectUser(request);
		
			// L'identification s'est bien déroulée, on stocke l'objet en session et on redirige l'utilisateur vers la page d'accueil
			request.getSession().setAttribute(Prop.get("attr.usersession"), user);
			request.getSession().setAttribute(Prop.get("attr.info"), "Vous êtes maintenant connecté.");
			response.sendRedirect(request.getContextPath() + Prop.get("path.cart"));
		} catch (ServiceException e) {
			// Si une erreur survient pendant la connexion on renvoi l'utilisateur vers la page de connexion et on affiche le message d'erreur
			request.getSession().setAttribute(Prop.get("attr.error"), e.getMessage());
			getServletContext().getRequestDispatcher(Prop.get("view.signin")).forward(request, response);
		}
	}
}
