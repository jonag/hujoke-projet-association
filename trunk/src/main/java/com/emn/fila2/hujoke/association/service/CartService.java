package com.emn.fila2.hujoke.association.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.emn.fila2.hujoke.association.dao.ProductDao;
import com.emn.fila2.hujoke.association.exception.ServiceException;
import com.emn.fila2.hujoke.association.model.Product;
import com.emn.fila2.hujoke.association.model.User;
import com.emn.fila2.hujoke.association.properties.Prop;

public class CartService {
	
	public void add(HttpServletRequest request) throws ServiceException {
		String productCode = request.getParameter(Prop.get("param.product"));
		if (productCode == null) {
			throw new ServiceException("Le code du produit est manquant.");
		}
		
		ProductDao productDao = new ProductDao();
		Product product = productDao.find(productCode);
		if (product == null) {
			throw new ServiceException("Le produit n'existe pas.");
		}
		
		User user = (User) request.getSession().getAttribute(Prop.get("attr.usersession"));
		if  (user == null) {
			throw new ServiceException("Vous n'êtes plus connecté.");
		}
		List<Product> cart = user.getCart();
		if (cart.contains(product) == false) {
			cart.add(product);
		}
	}

	public void remove(HttpServletRequest request) throws ServiceException {
		String productCode = request.getParameter(Prop.get("param.product"));
		if (productCode == null) {
			throw new ServiceException("Le code du produit est manquant.");
		}
		
		ProductDao productDao = new ProductDao();
		Product product = productDao.find(productCode);
		if (product == null) {
			throw new ServiceException("Le produit n'existe pas.");
		}
		
		User user = (User) request.getSession().getAttribute(Prop.get("attr.usersession"));
		if (null == user) {
			throw new ServiceException("Vous n'êtes plus connecté.");
		}
		List<Product> cart = user.getCart();
		cart.remove(product);
	}

	public void clear(HttpServletRequest request) throws ServiceException {
		User user = (User) request.getSession().getAttribute(Prop.get("attr.usersession"));
		if (null == user) {
			throw new ServiceException("Vous n'êtes plus connecté.");
		}
		List<Product> cart = user.getCart();
		cart.clear();
	}

	public void order(HttpServletRequest request) throws ServiceException {
		ProductDao productDao = new ProductDao();
		User user = (User) request.getSession().getAttribute(Prop.get("attr.usersession"));
		if (null == user) {
			throw new ServiceException("Vous n'êtes plus connecté.");
		}
		List<Product> cart = user.getCart();
		for (Product p : cart) {
			productDao.refresh(p);
			if (p.getStock() <= 0) {
				throw new ServiceException("Le produit " + p.getName() + " n'est plus en stock.");
			}
		}
		for (Product p : cart) {
			p.setStock(p.getStock() - 1);
		}
		productDao.merge(cart);
		cart.clear();
	}
}
