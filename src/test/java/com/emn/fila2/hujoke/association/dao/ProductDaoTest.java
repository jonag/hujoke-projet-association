package com.emn.fila2.hujoke.association.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.*;

import com.emn.fila2.hujoke.association.model.Product;

public class ProductDaoTest {

	private ProductDao dao;
	
	@Before
	public void setUp(){
		dao = new ProductDao();
	}
	
	@Test
	public void testFindAll(){
		List<Product> products = dao.findAll();
		assertTrue(products.size() == 4);
	}
	
	@Test
	public void testFind(){
		Product product = dao.find("T1");
		assertNotNull(product);
	}
	
}
