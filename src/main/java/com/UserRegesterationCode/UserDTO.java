package com.UserRegesterationCode;

public class UserDTO {
	
	private String name;
	private String email;
	private String state;
	private String city;
	private int id;
	
  
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
	public String getEmail() {
		return email;
	}
	public UserDTO(int id,String name, String email, String state, String city, long phoneNumber) {
		super();
		this.name = name;
		this.email = email;
		this.state = state;
		this.city = city;
		this.phoneNumber = phoneNumber;
		this.id = id;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public long getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	private long phoneNumber;

}
