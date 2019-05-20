package com.bookstore.dao;

import static org.junit.Assert.*;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.bookstore.dao.UsersDAO;
import com.bookstore.entity.Users;

public class UsersDAOTest extends BaseDAOTest{
	
	private static UsersDAO userDAO;

	@BeforeClass
	public static void setupClass() throws Exception {
		BaseDAOTest.setUpBeforeClass();

		userDAO = new UsersDAO(entityManager);
	}

	@Test
	public void testCreateUsers() {
		Users newUser = new Users();
		newUser.setEmail("jhonjoy@gmail.com");
		newUser.setFullname("jhon Joy");
		newUser.setPassword("billi");

		newUser = userDAO.create(newUser);
		assertTrue(newUser.getUserid() > 0);

	}

	@Test(expected = PersistenceException.class)
	public void testCreateUsersFliedsNotSet() {
		Users newUser = new Users();

		newUser = userDAO.create(newUser);
	}

	@Test
	public void testUpdateUsers() {
		Users newUser = new Users();
		newUser.setUserid(20);
		newUser.setEmail("mnkmail.com");
		newUser.setFullname("leyla");
		newUser.setPassword("123");
		newUser = userDAO.update(newUser);
		String expected = "password";
		String actual = newUser.getPassword();
		assertEquals(expected, actual);

	}
	@Test
	public void testCheckLoginSucess() {
		
		boolean result = userDAO.checkLogin("aman@mail.com ", "12345");
		assertTrue(result);
	}
	@Test
	public void testCheckLoginFailure() {
		
		boolean result = userDAO.checkLogin("aman@mail.com ", "1234");
		assertFalse(result);
	}

	@Test
	public void testGetUsersFound() {
		Integer userid = 21;
		Users newUser = userDAO.get(userid);
		if (newUser != null)
			System.out.println(newUser.getEmail());

		assertNotNull(newUser);

	}
	@Test
	public void testGetUserNotFound() {
		Integer userid = 1;
		Users newUser = userDAO.get(userid);
		assertNull(newUser);
		
	}
	@Test
	public void testDeleteUsers() {
		Integer userid = 21;
		userDAO.delete(userid);
		Users newUser = userDAO.get(userid);
		assertNull(newUser);
		
	}
	@Test(expected = EntityNotFoundException.class)
	public void testDeleteUsersNotExit() {
		Integer userid = 19;
		userDAO.delete(userid);
				
	}
	@Test
	public void testListAll() {
		List<Users> list  = userDAO.listAll();
		for(Users uu:list) {
			System.out.println(uu.getEmail());
			
		}
		assertTrue(list.size()>0);
		
	}
	@Test
	public void testcountAll() {
		long totalusers = userDAO.count();
		
		assertEquals(4, totalusers);
		
	}
	@Test
	public void testFindByEmail() {
		String email = "abc@gmail.com";
		Users user = userDAO.findByEmail(email);
		if(user==null) {
			System.out.println("Oops!");
		}else {
			System.out.println(user.getEmail());;
		}
		
		assertNotNull(user);
	}
	
	@AfterClass
	public static void tearDownClass() throws Exception {
		BaseDAOTest.tearDownAfterClass();
		

	}

}
