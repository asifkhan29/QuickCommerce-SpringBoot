package com.Cart;

import java.util.List;

import com.Seller.Products.Products;
import com.UserRegesterationCode.UserRegester;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class CartEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	private Products products;
	
	@ManyToOne
	private UserRegester userRegester;
	
	private double price;
	
	
	
	
	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
		
	}

	private int quantity;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Products getProducts() {
		return products;
	}

	public void setProducts(Products products) {
		this.products = products;
	}

	public UserRegester getUserRegister() {
		return userRegester;
	}

	public void setUserRegister(UserRegester userRegester) {
		this.userRegester = userRegester;
	}
	
	

}
