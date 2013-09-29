package com.emn.fila2.hujoke.association.service;

import javax.servlet.http.HttpServletRequest;

public class FormService {
	/**
	 * Retourne la valeur d'un champ ou null s'il est vide ou non fourni
	 * @param request
	 * @param fieldName
	 * @return
	 */
	protected String getFieldValue(HttpServletRequest request, String fieldName) {
		if (request.getParameter(fieldName) == null || request.getParameter(fieldName).trim().length() == 0) {
			return null;
		} else {
			return request.getParameter(fieldName).trim();
		}
	}
}
