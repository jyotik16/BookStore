package com.bookstore.dao;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.bookstore.entity.Book;


public class JpaDAO<E> {
	private static EntityManagerFactory entityManagerFactory;
	
	static {
		entityManagerFactory = Persistence.createEntityManagerFactory("BookStoreWebsite");
	}
	public JpaDAO() {
		
	}
	public E create(E entity) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(entity);
		entityManager.flush();
		entityManager.refresh(entity);
		entityManager.getTransaction().commit();
		entityManager.close();
		return entity;

	}

	public E update(E entity) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.merge(entity);
		entityManager.getTransaction().commit();		
		entityManager.close();
		return entity;
	}

	public E find(Class<E> type, Object userid) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		E entity = entityManager.find(type, userid);
		if (entity != null)
			entityManager.refresh(entity);
		entityManager.close();
		return entity;

	}

	public void delete(Class<E> type, Object userid) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		Object reference = entityManager.getReference(type, userid);
		entityManager.remove(reference);
		entityManager.getTransaction().commit();
		entityManager.close();

	}

	public List<E> findWithNamedQuery(String queryName) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		Query query = entityManager.createNamedQuery(queryName);
		@SuppressWarnings("unchecked")
		List<E> resultList = query.getResultList();
		entityManager.close();
		return resultList;
		
	}
	public List<E> findWithNamedQuery(String queryName,int firstResult,int maxResult) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		Query query = entityManager.createNamedQuery(queryName);
		query.setFirstResult(firstResult);
		query.setMaxResults(maxResult);
		
		List<E> resultList = query.getResultList();
		entityManager.close();
		return resultList;
		
	}
	@SuppressWarnings("unchecked")
	public List<E> findWithNamedQuery(String queryName,String paramName,Object paramValue){
		EntityManager entityManager = entityManagerFactory.createEntityManager();
			Query query = entityManager.createNamedQuery(queryName);
			query.setParameter(paramName, paramValue);
			List<E> resultlist = query.getResultList();
			entityManager.close();
			return resultlist;
	}
	public List<E> findWithNamedQuery(String queryName,Map<String,Object> parameters){
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		Query query = entityManager.createNamedQuery(queryName);
		Set<Entry<String,Object>> setParameters = parameters.entrySet();
		for(Entry<String,Object> entry:setParameters) {
			query.setParameter(entry.getKey(), entry.getValue());
			
		}
		List<E> resultlist = query.getResultList();
		entityManager.close();
		return resultlist;
}

	public long countWithNamedQuery(String queryName) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		Query query = entityManager.createNamedQuery(queryName);
		long resultcount = (long)query.getSingleResult();
		entityManager.close();
		return resultcount;
	}
	public long countWithNamedQuery(String queryName,String paramName,int categoryId) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		Query query = entityManager.createNamedQuery(queryName);
		query.setParameter(paramName, categoryId);
		long resultcount = (long)query.getSingleResult();
		entityManager.close();
		return resultcount;
	}
	public void close() {
		if(entityManagerFactory!=null) {
			entityManagerFactory.close();
		}
	}
	public List<Object[]> findWithNamedQueryObjects(String queryName, int firstResult, int maxResult) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		Query query = entityManager.createNamedQuery(queryName);		
		query.setFirstResult(firstResult);
		query.setMaxResults(maxResult);
		
		List<Object[]> result = query.getResultList();
		
		entityManager.close();
		
		return result;
	}

}
