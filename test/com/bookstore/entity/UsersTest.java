package com.bookstore.entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.bookstore.entity.Users;

public class UsersTest {
	 public static void main(String[] args) {
	        EntityManagerFactory factory = Persistence.createEntityManagerFactory("BookStoreWebsite");
	        EntityManager entityManager = factory.createEntityManager();

	        entityManager.getTransaction().begin();
	        Users newUser = new Users("abc","abd","123");
	        newUser.setEmail("joy@gmail.com");
	        newUser.setFullname("alex Joy");
	        newUser.setPassword("123");

	        entityManager.persist(newUser);
	        entityManager.getTransaction().commit();
	        entityManager.close();
	        factory.close();
	    }
}
