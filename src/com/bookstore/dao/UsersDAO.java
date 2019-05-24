
package com.bookstore.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;

import com.bookstore.entity.Category;
import com.bookstore.entity.Users;

public class UsersDAO extends JpaDAO<Users> implements GenericDAO<Users> {

	public UsersDAO() {
			
	}
	public Users create(Users user) {
		return super.create(user);
	}

	@Override
	public Users get(Object userid) {
		return super.find(Users.class, userid);
	}
	
	public Users findByEmail(String email) {
		List<Users> listResult = super.findWithNamedQuery("Users.findByEmail","email",email);
		if(listResult!=null && listResult.size()>0) {
			return listResult.get(0);
		}
		return null;
		
	}
	@Override
	public Users update(Users user) {
		
		return super.update(user);
		
	}

	@Override
	public void delete(Object userid) {
	 super.delete(Users.class, userid);
		
	}

	@Override
	public List<Users> listAll() {
		
		return super.findWithNamedQuery("Users.findAll");
	}

	@Override
	public long count() {
		
		return super.countWithNamedQuery("Users.countAll");
	}
	public boolean checkLogin(String email,String password) {
		Map<String,Object> parameter = new HashMap<>();
		parameter.put("email",email);
		parameter.put("password",password);
		List<Users> listusers = super.findWithNamedQuery("Users.checkLogin", parameter);
		if(listusers.size()==1) {
			return true;
		}else {
			return false;
		}
		
	}
	@Override
	public Category get(Category category) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
