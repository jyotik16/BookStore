package com.bookstore.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.AfterClass;
import org.junit.BeforeClass;

public class BaseDAOTest {
	protected static EntityManagerFactory entityManagerfactory;
	protected static EntityManager entityManager;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		entityManagerfactory = Persistence.createEntityManagerFactory("BookStoreWebsite");
		entityManager = entityManagerfactory.createEntityManager();

}
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		entityManager.close();
		entityManagerfactory.close();		
	}
}