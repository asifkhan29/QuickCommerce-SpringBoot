package com.Seller.Products;



import java.util.List;

import com.Review.ReviewEntity;
import com.SellerRegistrationCode.SellerEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Products {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int productId;
	private String productName;
	private int productPrice;
	private String productDescription;
	private String frontImage;
	@ManyToOne
	private SellerEntity sellerEntity;
	
	@OneToMany
	private List<ReviewEntity> reviewEntity;
	
	
	
	
	
	@Override
	public String toString() {
		return "Products [productId=" + productId + ", productName=" + productName + ", productPrice=" + productPrice
				+ ", productDescription=" + productDescription + ", sellerEntity=" + sellerEntity + "]";
	}
	
	public String getFrontImage() {
		return frontImage;
	}

	public void setFrontImage(String frontImage) {
		this.frontImage = frontImage;
	}

	public SellerEntity getSellerEntity() {
		return sellerEntity;
	}
	public void setSellerEntity(SellerEntity sellerEntity) {
		this.sellerEntity = sellerEntity;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}
	public String getProductDescription() {
		return productDescription;
	}
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}
	public List<ReviewEntity> getReviewEntity() {
		return reviewEntity;
	}
	public void setReviewEntity(List<ReviewEntity> reviewEntity) {
		this.reviewEntity = reviewEntity;
	}
	

}
