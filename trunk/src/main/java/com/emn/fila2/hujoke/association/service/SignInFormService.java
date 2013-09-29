package com.emn.fila2.hujoke.association.service;

import javax.servlet.http.HttpServletRequest;

import com.emn.fila2.hujoke.association.exception.FormException;
import com.emn.fila2.hujoke.association.model.User;

/*
 * TODO Il faut peut être faire une interface que ce service implémenterait afin de faciliter les tests ?
 * TODO Pour l'instant n'importe quel mdp/password fonctionne, il faut récupérer l'utilisateur dans la base de données quand elle sera prête
 */

public class SignInFormService extends FormService {
	private static final String FIELD_LOGIN = "login";
	private static final String FIELD_PASSWORD = "password";
	
	public User connectUser(HttpServletRequest request) throws FormException {
		User user = new User();
		
		String login = getFieldValue(request, FIELD_LOGIN);
		if (login == null) {
			throw new FormException("Le champ identifiant est obligatoire");
		} else {
			user.setLogin(login);
		}
		
		String password = getFieldValue(request, FIELD_PASSWORD);
		if (password == null) {
			throw new FormException("Le champ mot de passe est obligatoire");
		} else {
			user.setPassword(password);
		}
		
		return user;
	}
}
