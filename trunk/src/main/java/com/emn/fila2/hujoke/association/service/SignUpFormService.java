package com.emn.fila2.hujoke.association.service;

import javax.servlet.http.HttpServletRequest;

import com.emn.fila2.hujoke.association.dao.UserDao;
import com.emn.fila2.hujoke.association.exception.ServiceException;
import com.emn.fila2.hujoke.association.model.User;
import com.emn.fila2.hujoke.association.tools.MD5;
import com.emn.fila2.hujoke.association.properties.Prop;

// TODO Création d'une interface ?
// TODO Relation avec la base de données : stockage et vérification si l'identifiant n'est pas déjà utilisé
// TODO Ne pas stocker le mot de passe en clair

public class SignUpFormService extends FormService {
	
	public User createUser(HttpServletRequest request) throws ServiceException {
		User user = new User();
		UserDao userDao = new UserDao();
		
		String login = getFieldValue(request, Prop.get("field.login"));
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
		
		String password = getFieldValue(request, Prop.get("field.password"));
		if (password == null) {
			throw new ServiceException("Le champ mot de passe est obligatoire.");
		}
		String passwordConfirmation = getFieldValue(request, Prop.get("field.passwordconfirm"));
		if (passwordConfirmation == null) {
			throw new ServiceException("Le champ confirmation du mot de passe est obligatoire.");
		}
		if (password.equals(passwordConfirmation) == false) {
			throw new ServiceException("Les deux mot de passe ne correspondent pas.");
		}
		password = MD5.hash(password);
		user.setPassword(password);
		
		String lastName = getFieldValue(request, Prop.get("field.lastName"));
		if (lastName == null) {
			throw new ServiceException("Le champ nom de famille est obligatoire.");
		}
		user.setLastName(lastName);
		
		String firstName = getFieldValue(request, Prop.get("field.firstName"));
		if (firstName == null) {
			throw new ServiceException("Le champ prénom est obligatoire.");
		}
		user.setFirstName(firstName);
		
		String street = getFieldValue(request, Prop.get("field.street"));
		user.setStreet(street);
		
		String zipCode = getFieldValue(request, Prop.get("field.zipcode"));
		user.setZipCode(zipCode);
		
		String city = getFieldValue(request, Prop.get("field.city"));
		user.setCity(city);
		
		userDao.creer(user);
		return user;
	}
}
