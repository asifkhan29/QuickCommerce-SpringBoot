package com.Seller.Products;

public class ProductDTO {

	private int Id;
	private int productPrice;
	private int cartQuantity;
	private String name;
	private String description;
	private String shopName;
	private String sellerAddress;
	
	private Products product;
	
	
	
	public Products getProduct() {
		return product;
	}


	public void setProduct(Products product) {
		this.product = product;
	}


	public int getCartQuantity() {
		return cartQuantity;
	}


	public void setCartQuantity(int cartQuantity) {
		this.cartQuantity = cartQuantity;
	}


	public int getCartId() {
		return cartId;
	}


	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	private String sellerName;
	private String sellerEmail;
	private String img1;
	private int cartId;
	
	
	
	public ProductDTO(int id, int productPrice, String name, String description, String shopName, String sellerAddress,
			String sellerName, String sellerEmail, String img1) {
		super();
		Id = id;
		this.productPrice = productPrice;
		this.name = name;
		this.description = description;
		this.shopName = shopName;
		this.sellerAddress = sellerAddress;
		this.sellerName = sellerName;
		this.sellerEmail = sellerEmail;
		this.img1 = img1;
	}
	

	public String getImg1() {
		return img1;
	}

	public void setImg1(String img1) {
		this.img1 = img1;
	}

	public void setSellerAddress(String sellerAddress) {
		this.sellerAddress = sellerAddress;
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public String getSellerAddress() {
		return sellerAddress;
	}

	public void setAddress(String address) {
		this.sellerAddress = address;
	}

	public String getSellerName() {
		return sellerName;
	}

	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}

	public String getSellerEmail() {
		return  sellerEmail;
	}

	public ProductDTO(int id, int productPrice, String name, String description, String shopName, String address,
			String sellerName, String sellerEmail) {
		super();
		Id = id;
		this.productPrice = productPrice;
		this.name = name;
		this.description = description;
		this.shopName = shopName;
		this.sellerAddress = address;
		this.sellerName = sellerName;
		this.sellerEmail = sellerEmail;
	}

	public void setSellerEmail(String sellerEmail) {
		this.sellerEmail = sellerEmail;
	}

		public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}


	

	public int getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}



	public ProductDTO(int Id, int productPrice, String name, String description,String img1) {
		super();
		this.Id = Id;
		this.productPrice = productPrice;
		this.name = name;
		this.description = description;
		this.img1 = img1;
	}
	public ProductDTO(int Id, int productPrice, String name, String description,String img1,int cartQuantity) {
		super();
		this.Id = Id;
		this.productPrice = productPrice;
		this.name = name;
		this.description = description;
		this.img1 = img1;
		this.cartQuantity = cartQuantity;
		
	}
	public ProductDTO(int Id, int productPrice, String name, String description,String img1,int cartQuantity,int cartId) {
		super();
		this.Id = Id;
		this.productPrice = productPrice;
		this.name = name;
		this.description = description;
		this.img1 = img1;
		this.cartQuantity = cartQuantity;
		this.cartId = cartId;
		
		
	}
    
	
	public ProductDTO(int id, String name) {
		super();
		Id = id;
		this.name = name;
	}

	public ProductDTO() {
		super();
		// TODO Auto-generated constructor stub
	}


	public ProductDTO(Products product, int cartId) {
		super();
		this.product = product;
		this.cartId = cartId;
	}
   
	
}
