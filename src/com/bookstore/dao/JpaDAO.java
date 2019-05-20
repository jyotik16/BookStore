package com.bookstore.dao;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.bookstore.entity.Book;

public class JpaDAO<E> {
	protected EntityManager entitymanager;

	public JpaDAO(EntityManager entitymanager) {
		super();
		this.entitymanager = entitymanager;
	}

	public E create(E entity) {
		entitymanager.getTransaction().begin();
		entitymanager.persist(entity);
		entitymanager.flush();
		entitymanager.refresh(entity);
		entitymanager.getTransaction().commit();
		return entity;

	}

	public E update(E entity) {
		entitymanager.getTransaction().begin();
		entitymanager.merge(entity);
		entitymanager.getTransaction().commit();
		return entity;
	}

	public E find(Class<E> type, Object userid) {
		E entity = entitymanager.find(type, userid);
		if (entity != null)
			entitymanager.refresh(entity);
		return entity;

	}

	public void delete(Class<E> type, Object userid) {
		entitymanager.getTransaction().begin();
		Object reference = entitymanager.getReference(type, userid);
		entitymanager.remove(reference);
		entitymanager.getTransaction().commit();

	}

	public List<E> findWithNamedQuery(String queryName) {
		Query query = entitymanager.createNamedQuery(queryName);
		@SuppressWarnings("unchecked")
		List<E> resultList = query.getResultList();
		return resultList;
		
	}
	@SuppressWarnings("unchecked")
	public List<E> findWithNamedQuery(String queryName,String paramName,Object paramValue){
			Query query = entitymanager.createNamedQuery(queryName);
			query.setParameter(paramName, paramValue);
			List<E> resultlist = query.getResultList();
			return resultlist;
	}
	public List<E> findWithNamedQuery(String queryName,Map<String,Object> parameters){
		Query query = entitymanager.createNamedQuery(queryName);
		Set<Entry<String,Object>> setParameters = parameters.entrySet();
		for(Entry<String,Object> entry:setParameters) {
			query.setParameter(entry.getKey(), entry.getValue());
		}
		
		List<E> resultlist = query.getResultList();
		return resultlist;
}

	public long countWithNamedQuery(String queryName) {
		Query query = entitymanager.createNamedQuery(queryName);

		return (long) query.getSingleResult();
	}


}
