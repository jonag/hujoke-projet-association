package com.emn.fila2.hujoke.association.service;

import javax.servlet.http.HttpServletRequest;

import com.emn.fila2.hujoke.association.dao.UserDao;
import com.emn.fila2.hujoke.association.exception.ServiceException;
import com.emn.fila2.hujoke.association.model.User;
import com.emn.fila2.hujoke.association.tools.MD5;
import com.emn.fila2.hujoke.association.properties.Prop;

/*
 * TODO Il faut peut être faire une interface que ce service implémenterait afin de faciliter les tests ?
 */

public class SignInFormService extends FormService {
	
	public User connectUser(HttpServletRequest request) throws ServiceException {		
		String login = getFieldValue(request, Prop.get("field.login"));
		if (login == null) {
			throw new ServiceException("Le champ identifiant est obligatoire");
		}
		
		String password = getFieldValue(request, Prop.get("field.password"));
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
