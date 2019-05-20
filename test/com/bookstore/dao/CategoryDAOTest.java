package com.bookstore.dao;

import static org.junit.Assert.*;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.bookstore.dao.CategoryDAO;
import com.bookstore.entity.Category;
import com.bookstore.entity.Users;

public class CategoryDAOTest extends BaseDAOTest{
	private static CategoryDAO categoryDAO;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		BaseDAOTest.setUpBeforeClass();
		categoryDAO = new CategoryDAO(entityManager);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		BaseDAOTest.tearDownAfterClass();
	}
	@Test
	public void testGet() {
		Integer cateId = 2;
		Category cat = categoryDAO.get(cateId);
		
		assertNotNull(cat);
	}

	@Test
	public void testGetCategory() {
		Category newCate = new Category("Buissness");
		Category category = categoryDAO.create(newCate);
		
		assertTrue(category!=null && category.getCategoryId()>0);
	
	}
	@Test
	public void testUpdateCategory() {
		Category cate = new Category("Buissness");
		cate.setCategoryId(1);
		Category category = categoryDAO.update(cate);
		assertEquals(cate.getName(),category.getName());
	
	}
	

	@Test
	public void testDeleteCategory() {
		Integer cateId = 5;
		categoryDAO.delete(cateId);
		Category cate = categoryDAO.get(cateId);
		assertNull(cate);
	}

	@Test
	public void testListAll() {
		List<Category> list  = categoryDAO.listAll();
		for(Category uu:list) {
			System.out.println(uu.getName());
			
		}
		assertTrue(list.size()>0);
	}

	@Test
	public void testCount() {
		long totalcategories = categoryDAO.count();
		
		assertEquals(4, totalcategories);
	}
	@Test
	public void testfindByName() {
		Category cat = categoryDAO.findByName("Java Core");
		assertNotNull(cat);
	}
	@Test
	public void testfindByNameNotFound() {
		Category cat = categoryDAO.findByName("Java Core1");
		assertNull(cat);
	}
	

	@Test
	public void testGetObject() {
		
	}

}
