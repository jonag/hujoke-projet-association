package com.emn.fila2.hujoke.association.service;

import static org.junit.Assert.*;

import javax.servlet.http.HttpServletRequest;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

import com.emn.fila2.hujoke.association.service.SignInFormService;

public class SignInFormServiceTest {

	private SignInFormService service;

	@Before
	public void setUp() {
		this.service = new SignInFormService();
	}

	@Test
	public void loginMissing() {
		HttpServletRequest request = mock(HttpServletRequest.class);

		when(request.getParameter("login")).thenReturn(null);

		try {
			this.service.connectUser(request);
			fail("Le login n'était pas fourni.");
			verify(request);
		} catch (Exception e) {
			if (e.getMessage().equals("Le champ identifiant est obligatoire") == false) {
				fail("Ce n'est pas la bonne exception qui a été levée.");
			}
		}

	}

	@Test
	public void passwordMissing() {
		HttpServletRequest request = mock(HttpServletRequest.class);

		when(request.getParameter("login")).thenReturn("login");
		when(request.getParameter("password")).thenReturn(null);

		try {
			this.service.connectUser(request);
			fail("Le password n'était pas fourni.");
			verify(request);
		} catch (Exception e) {
			if (e.getMessage().equals("Le champ mot de passe est obligatoire") == false) {
				fail("Ce n'est pas la bonne exception qui a été levée.");
			}
		}
	}

}
