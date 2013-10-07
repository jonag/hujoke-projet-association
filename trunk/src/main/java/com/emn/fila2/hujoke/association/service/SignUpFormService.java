package com.emn.fila2.hujoke.association.service;

import javax.servlet.http.HttpServletRequest;

import com.emn.fila2.hujoke.association.dao.UserDao;
import com.emn.fila2.hujoke.association.exception.ServiceException;
import com.emn.fila2.hujoke.association.model.User;
import com.emn.fila2.hujoke.association.tools.MD5;

// TODO Création d'une interface ?
// TODO Relation avec la base de données : stockage et vérification si l'identifiant n'est pas déjà utilisé
// TODO Ne pas stocker le mot de passe en clair

public class SignUpFormService extends FormService {
	private static final String FIELD_LOGIN = "login";
	private static final String FIELD_PASSWORD = "password";
	private static final String FIELD_PASSWORD_CONFIRM = "passwordConfirmation";
	private static final String FIELD_LASTNAME = "lastName";
	private static final String FIELD_FIRSTNAME = "firstName";
	private static final String FIELD_STREET = "street";
	private static final String FIELD_ZIPCODE = "zipCode";
	private static final String FIELD_CITY = "city";
	
	public User createUser(HttpServletRequest request) throws ServiceException {
		User user = new User();
		UserDao userDao = new UserDao();
		
		String login = getFieldValue(request, FIELD_LOGIN);
		if (login == null) {
			throw new ServiceException("Le champ identifiant est obligatoire.");
		}
		if (login.indexOf(" ") != -1) {
			throw new ServiceException("Les espaces ne sont pas utilisés dans le nom d'utilisateur.");
		}
		if (userDao.findByLogin(login) != null) {
			throw new ServiceException("Ce nom d'utilisateur est déjà utilisé.");
		}
		user.setLogin(login);
		
		String password = getFieldValue(request, FIELD_PASSWORD);
		if (password == null) {
			throw new ServiceException("Le champ mot de passe est obligatoire.");
		}
		String passwordConfirmation = getFieldValue(request, FIELD_PASSWORD_CONFIRM);
		if (passwordConfirmation == null) {
			throw new ServiceException("Le champ confirmation du mot de passe est obligatoire.");
		}
		if (password.equals(passwordConfirmation) == false) {
			throw new ServiceException("Les deux mot de passe ne correspondent pas.");
		}
		password = MD5.hash(password);
		user.setPassword(password);
		
		String lastName = getFieldValue(request, FIELD_LASTNAME);
		if (lastName == null) {
			throw new ServiceException("Le champ nom de famille est obligatoire.");
		}
		user.setLastName(lastName);
		
		String firstName = getFieldValue(request, FIELD_FIRSTNAME);
		if (firstName == null) {
			throw new ServiceException("Le champ prénom est obligatoire.");
		}
		user.setFirstName(firstName);
		
		String street = getFieldValue(request, FIELD_STREET);
		user.setStreet(street);
		
		String zipCode = getFieldValue(request, FIELD_ZIPCODE);
		user.setZipCode(zipCode);
		
		String city = getFieldValue(request, FIELD_CITY);
		user.setCity(city);
		
		userDao.creer(user);
		return user;
	}
}
