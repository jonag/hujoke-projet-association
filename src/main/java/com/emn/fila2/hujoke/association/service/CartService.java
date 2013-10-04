package com.emn.fila2.hujoke.association.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.emn.fila2.hujoke.association.dao.ProductDao;
import com.emn.fila2.hujoke.association.exception.ServiceException;
import com.emn.fila2.hujoke.association.model.Product;
import com.emn.fila2.hujoke.association.model.User;

public class CartService {
	private static final String PARAM_PRODUCT = "product";
	private static final String ATTR_USER_SESSION = "userSession";
	
	public void add(HttpServletRequest request) throws ServiceException {
		String productCode = request.getParameter(PARAM_PRODUCT);
		if (null != productCode) {
			ProductDao productDao = new ProductDao();
			Product product = productDao.find(productCode);
			if (product == null) {
				throw new ServiceException("Le produit n'existe pas.");
			}
			
			User user = (User) request.getSession().getAttribute(ATTR_USER_SESSION);
			List<Product> cart = user.getCart();
			if (cart.contains(product) == false) {
				cart.add(product);
			}
		}
	}

	public void remove(HttpServletRequest request) throws ServiceException {
		String productCode = request.getParameter(PARAM_PRODUCT);
		if (null != productCode) {
			ProductDao productDao = new ProductDao();
			Product product = productDao.find(productCode);
			if (product == null) {
				throw new ServiceException("Le produit n'existe pas.");
			}
			
			User user = (User) request.getSession().getAttribute(ATTR_USER_SESSION);
			List<Product> cart = user.getCart();
			cart.remove(product);
		}
	}
}
