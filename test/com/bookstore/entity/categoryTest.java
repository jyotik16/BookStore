package com.bookstore.entity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.bookstore.entity.Category;

public class categoryTest {
	 public static void main(String[] args) {
	        EntityManagerFactory factory = Persistence.createEntityManagerFactory("BookStoreWebsite");
	        EntityManager entityManager = factory.createEntityManager();

	        entityManager.getTransaction().begin();
	       Category cate = new Category("JavaBook");
	        entityManager.persist(cate);
	        entityManager.getTransaction().commit();
	        entityManager.close();
	        factory.close();
	    }
}
