package com.bookstore.dao;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bookstore.entity.Category;
import com.bookstore.entity.Review;

public class ReviewDAO extends JpaDAO<Review> implements GenericDAO<Review> {

	@Override
	public Review create(Review review) {
		review.setReviewTime(new Date());
		return super.create(review);
	}

	@Override
	public Review get(Object reviewId) {
		return super.find(Review.class, reviewId);
		
	}

	@Override
	public Review update(Review reviewId) {
		
		return super.update(reviewId);
	}

	@Override
	public void delete(Object reviewId) {
		 super.delete(Review.class, reviewId);
		
	}

	@Override
	public List<Review> listAll() {
		
		return super.findWithNamedQuery("Review.listAll");
	}

	@Override
	public long count() {
		return super.countWithNamedQuery("Review.countAll");
	}

	@Override
	public Category get(Category category) {
		// TODO Auto-generated method stub
		return null;
	}
	public Review findByCustomerAndBook(Integer CustomerId,Integer BookId) {
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("customerId",CustomerId);
		parameters.put("bookId",BookId);
		
		List<Review> result = super.findWithNamedQuery("Review.findByCustomerAndBook", parameters);
		if(!result.isEmpty()) {
			return result.get(0);
		}
		return null;
		
	}
}
