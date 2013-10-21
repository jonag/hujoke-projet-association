package com.emn.fila2.hujoke.association;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import javax.servlet.http.HttpServletRequest;

import org.junit.Before;
import org.junit.Test;

import com.emn.fila2.hujoke.association.service.SignUpFormService;

public class SignUpFormServiceTest {
	
	private SignUpFormService service;

	@Before
	public void setUp() {
		this.service = new SignUpFormService();
	}

	@Test
	public void loginMissing() {
		HttpServletRequest request = mock(HttpServletRequest.class);

		when(request.getParameter("login")).thenReturn(null);

		try {
			this.service.createUser(request);
			fail("Le login n'était pas fourni.");
			verify(request);
		} catch (Exception e) {
			if (e.getMessage().equals("Le champ identifiant est obligatoire.") == false) {
				fail("Ce n'est pas la bonne exception qui a été levée.");
			}
		}
	}
	
	@Test
	public void checkPassword() {
		HttpServletRequest request = mock(HttpServletRequest.class);
		
		when(request.getParameter("login")).thenReturn("lgn");
		when(request.getParameter("password")).thenReturn(null);
		
		try {
			this.service.createUser(request);
			fail("Le password n'était pas fourni");
			verify(request);
		} catch (Exception e) {
			if (e.getMessage().equals("Le champ mot de passe est obligatoire.") == false) {
				fail("Ce n'est pas la bonne exception qui a été levée.");
			}
		}

		when(request.getParameter("login")).thenReturn("lgn");
		when(request.getParameter("password")).thenReturn("pswd");
		when(request.getParameter("passwordConfirm")).thenReturn(null);
		
		try {
			this.service.createUser(request);
			fail("Le password confirmation n'était pas fourni");
			verify(request);
		} catch (Exception e) {
			if (e.getMessage().equals("Le champ confirmation du mot de passe est obligatoire.") == false) {
				fail("Ce n'est pas la bonne exception qui a été levée.");
			}
		}
		
		when(request.getParameter("login")).thenReturn("lgn");
		when(request.getParameter("password")).thenReturn("pswd");
		when(request.getParameter("passwordConfirmation")).thenReturn("pswd2");
		
		try {
			this.service.createUser(request);
			fail("Le password et la confirmation ne matchaient pas");
			verify(request);
		} catch (Exception e) {
			if (e.getMessage().equals("Les deux mot de passe ne correspondent pas.") == false) {
				fail("Ce n'est pas la bonne exception qui a été levée.");
			}
		}
	}
	
	@Test
	public void lastNameMissing() {
		HttpServletRequest request = mock(HttpServletRequest.class);
		
		when(request.getParameter("login")).thenReturn("lgn");
		when(request.getParameter("password")).thenReturn("pswd");
		when(request.getParameter("passwordConfirmation")).thenReturn("pswd");
		when(request.getParameter("lastName")).thenReturn(null);
		
		try {
			this.service.createUser(request);
			fail("Le nom n'était pas fourni");
			verify(request);
		} catch (Exception e) {
			if (e.getMessage().equals("Le champ nom de famille est obligatoire.") == false) {
				fail("Ce n'est pas la bonne exception qui a été levée.");
			}
		}
	}
	
	@Test
	public void firstNameMissing() {
		HttpServletRequest request = mock(HttpServletRequest.class);
		
		when(request.getParameter("login")).thenReturn("lgn");
		when(request.getParameter("password")).thenReturn("pswd");
		when(request.getParameter("passwordConfirmation")).thenReturn("pswd");
		when(request.getParameter("lastName")).thenReturn("lastName");
		when(request.getParameter("firstName")).thenReturn(null);
		
		try {
			this.service.createUser(request);
			fail("Le prénom n'était pas fourni");
			verify(request);
		} catch (Exception e) {
			if (e.getMessage().equals("Le champ prénom est obligatoire.") == false) {
				fail("Ce n'est pas la bonne exception qui a été levée.");
			}
		}
	}

}
