package com.SellerRegistrationCode;

import java.util.List;


import com.Seller.Products.Products;
import com.User.BuyProducts.BuyProductsEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class SellerEntity {
	
	

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	private String shopName;
	private String address;
	private String email;
	private String phoneNumber;
	private String password;
	private String storePicture;
	
	@OneToMany
	private List<Products>  products;
	
	@OneToMany
	private List<BuyProductsEntity> numberOfOrder;
	
	
	public List<BuyProductsEntity> getNumberOfOrder() {
		return numberOfOrder;
	}
	public void setNumberOfOrder(List<BuyProductsEntity> numberOfOrder) {
		this.numberOfOrder = numberOfOrder;
	}
	public List<Products> getProducts() {
		return products;
	}
	public void setProducts(List<Products> products) {
		this.products = products;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getShopName() {
		return shopName;
	}
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public String getStorePicture() {
		return storePicture;
	}
	public void setStorePicture(String storePicture) {
		this.storePicture = storePicture;
	}
	public SellerEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public SellerEntity(int id, String name, String shopName, String address, String email, String phoneNumber,
			String password, String storePicture, List<Products> products, List<BuyProductsEntity> numberOfOrder) {
		super();
		this.id = id;
		this.name = name;
		this.shopName = shopName;
		this.address = address;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.password = password;
		this.storePicture = storePicture;
		this.products = products;
		this.numberOfOrder = numberOfOrder;
	}
	public SellerEntity(int id, String name, String shopName, String address, String email, String phoneNumber,
			String password, List<Products> products, List<BuyProductsEntity> numberOfOrder) {
		super();
		this.id = id;
		this.name = name;
		this.shopName = shopName;
		this.address = address;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.password = password;
		this.products = products;
		this.numberOfOrder = numberOfOrder;
	}
	
	
}
