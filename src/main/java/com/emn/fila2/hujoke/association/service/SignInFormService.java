package com.emn.fila2.hujoke.association.service;

import javax.servlet.http.HttpServletRequest;

import com.emn.fila2.hujoke.association.dao.UserDao;
import com.emn.fila2.hujoke.association.exception.ServiceException;
import com.emn.fila2.hujoke.association.model.User;
import com.emn.fila2.hujoke.association.tools.MD5;

/*
 * TODO Il faut peut être faire une interface que ce service implémenterait afin de faciliter les tests ?
 */

public class SignInFormService extends FormService {
	private static final String FIELD_LOGIN = "login";
	private static final String FIELD_PASSWORD = "password";
	
	public User connectUser(HttpServletRequest request) throws ServiceException {		
		String login = getFieldValue(request, FIELD_LOGIN);
		if (login == null) {
			throw new ServiceException("Le champ identifiant est obligatoire");
		}
		
		String password = getFieldValue(request, FIELD_PASSWORD);
		if (password == null) {
			throw new ServiceException("Le champ mot de passe est obligatoire");
		}
		
		UserDao userDao = new UserDao();
		User user = userDao.findByLogin(login);
		if (user == null) {
			throw new ServiceException("Le nom d'utilisateur n'existe pas");
		}
		password = MD5.hash(password);
		if (user.getPassword().equals(password) == false) {
			throw new ServiceException("Le mot de passe n'est pas correct");
		}
		
		return user;
	}
}
