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

import com.emn.fila2.hujoke.association.properties.Prop;

/**
 * Servlet Filter implementation class AuthentificationFilter
 */
@WebFilter(urlPatterns="/*")
public class AuthentificationFilter implements Filter {

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
		if (req.getRequestURI().matches(Prop.get("auth.assets")) == false) {
			// Si la page à laquelle on souhaite accéder necessite d'être identifié alors que l'utilisateur ne l'est pas on le redirige
			// vers la page de connexion
			if (req.getRequestURI().matches(req.getContextPath() + Prop.get("auth.anonymous")) == false
					&& req.getSession().getAttribute(Prop.get("attr.usersession")) == null) {
				res.sendRedirect(req.getContextPath() + Prop.get("path.signin")); 
			} else if (req.getRequestURI().matches(req.getContextPath() + Prop.get("auth.anonymous")) == true
					&& req.getSession().getAttribute(Prop.get("attr.usersession")) != null) {
				// En revanche, si on essaye d'accéder à la page de sign-in/sign-up alors qu'on est déjà connecté on est renvoyé vers la page d'accueil
				res.sendRedirect(req.getContextPath() + Prop.get("path.index"));
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
