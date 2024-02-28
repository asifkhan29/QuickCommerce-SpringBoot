package com.User.BuyProducts;

import java.lang.System.Logger;

public class BuyProductDTO {
	
	private String productName;
	private String Quantity;
	private String shopName;
	private String ShopAddress;
	private String userName;
	private String userAddress;
	private String paymentInfo;
	private String productColor;
    private String productPrice;
	private String userEmail;
	private String sellerEmail;
	private String orderStatus;
	private int orderId;
	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	
	
	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public BuyProductDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BuyProductDTO(int orderId,String productName, String quantity, String shopName, String paymentInfo, String productColor,
			String productPrice,String orderStatus) {
		super();
		this.productName = productName;
		this.Quantity = quantity;
		this.shopName = shopName;
		this.paymentInfo = paymentInfo;
		this.productColor = productColor;
		this.productPrice = productPrice;
		this.orderStatus = orderStatus;
		this.orderId = orderId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getQuantity() {
		return Quantity;
	}

	public void setQuantity(String quantity) {
		this.Quantity = quantity;
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public String getShopAddress() {
		return ShopAddress;
	}

	public void setShopAddress(String shopAddress) {
		this.ShopAddress = shopAddress;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	public String getPaymentInfo() {
		return paymentInfo;
	}

	public void setPaymentInfo(String paymentInfo) {
		this.paymentInfo = paymentInfo;
	}

	public String getProductColor() {
		return productColor;
	}

	public void setProductColor(String productColor) {
		this.productColor = productColor;
	}

	public String getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(String productPrice) {
		this.productPrice = productPrice;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getSellerEmail() {
		return sellerEmail;
	}

	public void setSellerEmail(String sellerEmail) {
		this.sellerEmail = sellerEmail;
	}

	public BuyProductDTO(int orderId,String productName, String quantity, String productColor, String productPrice,String orderStatus) {
		super();
		this.productName = productName;
		this.Quantity = quantity;
		this.productColor = productColor;
		this.productPrice = productPrice;
		this.orderStatus = orderStatus;
		this.orderId = orderId;
	}

	@Override
	public String toString() {
		return "BuyProductDTO [productName=" + productName + ", Quantity=" + Quantity + ", shopName=" + shopName
				+ ", ShopAddress=" + ShopAddress + ", userName=" + userName + ", userAddress=" + userAddress
				+ ", paymentInfo=" + paymentInfo + ", productColor=" + productColor + ", productPrice=" + productPrice
				+ ", userEmail=" + userEmail + ", sellerEmail=" + sellerEmail + ", orderStatus=" + orderStatus
				+ ", orderId=" + orderId + "]";
		  
	}

	
	

}
