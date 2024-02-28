package com.UserRegesterationCode;

import java.util.List;

import com.User.BuyProducts.BuyProductsEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class UserRegester {
	
	
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	private String email;
	private String state;
	private String city;
	private String password;
	private long phoneNumber;
	
	@OneToMany
	private List<BuyProductsEntity> buyProductsEntity;
	

	
	
	public List<BuyProductsEntity> getBuyProducts() {
		return buyProductsEntity;
	}



	public void setBuyProducts(List<BuyProductsEntity> buyProductsEntity) {
		this.buyProductsEntity = buyProductsEntity;
	}



	@Override
	public String toString() {
		return "UserRegester [id=" + id + ", name=" + name + ", email=" + email + ", state=" + state + ", city=" + city
				+ ", password=" + password + ", phoneNumber=" + phoneNumber + "]";
	}
	
	
	
	public long getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	

}
