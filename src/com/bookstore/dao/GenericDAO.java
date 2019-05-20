package com.bookstore.dao;

import java.util.List;

import com.bookstore.entity.Category;

public interface GenericDAO<E> {
public E create(E t);
public E get(Object id);
public E update(E t);
public void delete(Object id);
public List<E> listAll();
public long count();
Category get(Category category);


}
