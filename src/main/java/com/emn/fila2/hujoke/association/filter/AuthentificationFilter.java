package com.emn.fila2.hujoke.association.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class AuthentificationFilter
 */
@WebFilter(urlPatterns="/*")
public class AuthentificationFilter implements Filter {
	/**
	 * Expression régulière permettant de définir les URL accessibles sans être identifié 
	 */
	private static final String ASSETS = ".*(\\.css|\\.js|\\.eot|\\.svg|\\.ttf|\\.woff).*";
	private static final String ANONYMOUS_AREA = "/(sign-in|sign-up)";
	
	/**
	 * Chemin vers la page de connexion
	 */
	private static final String PATH_LOGIN = "/sign-in";
	
	/**
	 * Chemin vers la page d'accueil
	 */
	private static final String PATH_INDEX = "/index";
	
	/**
	 * Nom de l'attribut où est stocké l'utilisateur dans la session
	 */
	private static final String ATTR_USER_SESSION = "userSession";
	
	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
	}
	
	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		
		// On laisse passer toutes les requêtes visant à récupérer des fichiers css, js, ...
		if (req.getRequestURI().matches(ASSETS) == false) {
			// Si la page à laquelle on souhaite accéder necessite d'être identifié alors que l'utilisateur ne l'est pas on le redirige
			// vers la page de connexion
			if (req.getRequestURI().matches(req.getContextPath() + ANONYMOUS_AREA) == false
					&& req.getSession().getAttribute(ATTR_USER_SESSION) == null) {
				res.sendRedirect(req.getContextPath() + PATH_LOGIN); 
			} else if (req.getRequestURI().matches(req.getContextPath() + ANONYMOUS_AREA) == true
					&& req.getSession().getAttribute(ATTR_USER_SESSION) != null) {
				// En revanche, si on essaye d'accéder à la page de sign-in/sign-up alors qu'on est déjà connecté on est renvoyé vers la page d'accueil
				res.sendRedirect(req.getContextPath() + PATH_INDEX);
			} else {
				chain.doFilter(request, response);
			}
		} else {
			chain.doFilter(request, response);
		}
	}

	public void destroy() {	
	}

}
