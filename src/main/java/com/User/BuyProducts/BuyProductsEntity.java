package com.User.BuyProducts;



import com.Review.ReviewEntity;
import com.SellerRegistrationCode.SellerEntity;
import com.UserRegesterationCode.UserRegester;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class BuyProductsEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String productName;
	private int productId;
	private String Quantity;
	private String shopName;
	private String ShopAddress;
	private String customerName;
	private String customerAddress;
	private String paymentInfo;
	private String productColor;
    private String productPrice;
    private String customerNumber;
    private String orderStatus;
    
    
    
    public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	@ManyToOne
	private UserRegester userRegester;
    
    @ManyToOne
    private SellerEntity sellerEntity;
    
    
    
    
	
	public String getCustomerNumber() {
		return customerNumber;
	}

	public void setCustomerNumber(String customerNumber) {
		this.customerNumber = customerNumber;
	}

	public SellerEntity getSellerEntity() {
		return sellerEntity;
	}

	public void setSellerEntity(SellerEntity sellerEntity) {
		this.sellerEntity = sellerEntity;
	}

	public BuyProductsEntity(int id, String productName, int productId, String quantity, String shopName,
			String shopAddress, String customerName, String customerAddress, String paymentInfo, String productColor,
			String productPrice, UserRegester userRegester) {
		super();
		this.id = id;
		this.productName = productName;
		this.productId = productId;
		this.Quantity = quantity;
		this.shopName = shopName;
		this.ShopAddress = shopAddress;
		this.customerName = customerName;
		this.customerAddress = customerAddress;
		this.paymentInfo = paymentInfo;
		this.productColor = productColor;
		this.productPrice = productPrice;
		this.userRegester = userRegester;
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

	

	

	public String getPaymentInfo() {
		return paymentInfo;
	}

	public void setPaymentInfo(String paymentInfo) {
		this.paymentInfo = paymentInfo;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public UserRegester getUserRegester() {
		return userRegester;
	}

	public void setUserRegester(UserRegester userRegester) {
		this.userRegester = userRegester;
	}

	public BuyProductsEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
