package com.emn.fila2.hujoke.association.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="\"USER\"")
@NamedQueries({
	@NamedQuery(name="User.findAll", query="SELECT u FROM User u"),
	@NamedQuery(name="User.findByLogin", query="SELECT u FROM User u WHERE u.login = :login")
})
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	private String city;

	@Column(name="FIRST_NAME")
	private String firstName;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Column(name="LAST_NAME")
	private String lastName;

	private String login;

	private String password;

	private String street;

	@Column(name="ZIP_CODE")
	private String zipCode;
	
	@Transient
	private List<Product> cart;

	public User() {
		cart = new ArrayList<Product>();
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getStreet() {
		return this.street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getZipCode() {
		return this.zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public List<Product> getCart() {
		return cart;
	}

	public void setCart(List<Product> panier) {
		this.cart = panier;
	}
}