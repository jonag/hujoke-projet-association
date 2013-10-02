package com.emn.fila2.hujoke.association.service;

import javax.servlet.http.HttpServletRequest;

import com.emn.fila2.hujoke.association.dao.UserDao;
import com.emn.fila2.hujoke.association.exception.FormException;
import com.emn.fila2.hujoke.association.model.User;

/*
 * TODO Il faut peut être faire une interface que ce service implémenterait afin de faciliter les tests ?
 */

public class SignInFormService extends FormService {
	private static final String FIELD_LOGIN = "login";
	private static final String FIELD_PASSWORD = "password";
	
	public User connectUser(HttpServletRequest request) throws FormException {		
		String login = getFieldValue(request, FIELD_LOGIN);
		if (login == null) {
			throw new FormException("Le champ identifiant est obligatoire");
		}
		
		String password = getFieldValue(request, FIELD_PASSWORD);
		if (password == null) {
			throw new FormException("Le champ mot de passe est obligatoire");
		}
		
		UserDao userDao = new UserDao();
		User user = userDao.findByLogin(login);
		if (user == null) {
			throw new FormException("Le nom d'utilisateur n'existe pas");
		}
		// TODO Si on crypte le mot de passe de l'utilisateur il faut également crypter le mot de passe ici avant de faire le test
		if (user.getPassword().equals(password) == false) {
			throw new FormException("Le mot de passe n'est pas correct");
		}
		
		return user;
	}
}
