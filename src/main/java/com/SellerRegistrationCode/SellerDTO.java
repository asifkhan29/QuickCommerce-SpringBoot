package com.SellerRegistrationCode;

public class SellerDTO {
	
	private int Id;
	private String name;
	private String shopName;
	private String address;
	private String email;
	private String phoneNumber;
	private String storePicture;
	
	public SellerDTO(int Id,String name, String shopName, String address, String email, String phoneNumber ,String storePicture) {
		super();
		this.name = name;
		this.shopName = shopName;
		this.address = address;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.Id = Id;
		this.storePicture = storePicture;
		
	}
	
	
	public String getStorePicture() {
		return storePicture;
	}


	public void setStorePicture(String storePicture) {
		this.storePicture = storePicture;
	}


	public SellerDTO(int id, String shopName) {
		super();
		Id = id;
		this.shopName = shopName;
	}
    
	public SellerDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
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

}
