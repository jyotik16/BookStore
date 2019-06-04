package com.bookstore.dao;

import static org.junit.Assert.*;

import java.util.List;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import com.bookstore.dao.CategoryDAO;
import com.bookstore.entity.Category;


public class CategoryDAOTest {
	private static CategoryDAO categoryDAO;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		categoryDAO = new CategoryDAO();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		categoryDAO.close();
	}
	@Test
	public void testGet() {
		Integer cateId = 2;
		Category cat = categoryDAO.get(cateId);
		
		assertNotNull(cat);
	}

	@Test
	public void testGetCategory() {
		Category newCate = new Category("Spring");
		Category category = categoryDAO.create(newCate);
		
		assertTrue(category!=null && category.getCategoryId()>0);
	
	}
	@Test
	public void testUpdateCategory() {
		Category cate = new Category("Ruby");
		cate.setCategoryId(23);
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
		
		assertTrue(totalcategories > 0);
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
