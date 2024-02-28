package com.Review;

public class ReviewDTO {
	private int rating;
	private String reviews;
	private String reviewer;
	
	
	public ReviewDTO(int rating, String reviews, String reviewer) {
		super();
		this.rating = rating;
		this.reviews = reviews;
		this.reviewer = reviewer;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getReviews() {
		return reviews;
	}

	public void setReviews(String reviews) {
		this.reviews = reviews;
	}



	public ReviewDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getReviewer() {
		return reviewer;
	}

	public void setReviewer(String reviewer) {
		this.reviewer = reviewer;
	}

		

}
