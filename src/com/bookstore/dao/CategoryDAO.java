package com.bookstore.dao;

import java.util.List;
import javax.persistence.EntityManager;

import com.bookstore.entity.Category;
import com.bookstore.entity.Users;

public class CategoryDAO extends JpaDAO<Category> implements GenericDAO<Category> {

	public CategoryDAO() {
	}
	public Category findByName(String categoryName) {
		List<Category> listResult = super.findWithNamedQuery("Category.findByName","name",categoryName);
		if(listResult!=null && listResult.size()>0) {
			return listResult.get(0);
		}
		return null;
	}
	@Override
	public Category get(Category category) {
		
		return super.create(category);
		
	}

	@Override
	public void delete(Object cateId) {
		super.delete(Category.class,cateId);
		
	}
	@Override
	public Category update(Category category) {
		return super.update(category);
		
		
	}

	@Override
	public List<Category> listAll() {
		
		return super.findWithNamedQuery("Category.findAll");
	}

	@Override
	public long count() {
		
		return super.countWithNamedQuery("Category.countAll");
		
	}

	@Override
	public Category get(Object cateId) {
		
		return super.find(Category.class, cateId);
	}

	
}
