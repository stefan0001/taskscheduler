package de.sep.innovativeoperation.taskscheduler.dao.generic;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;

/**
 * 
 * @author Stefan
 * 
 * @param <E>
 */

public abstract class GenericDAOImpl<E> implements GenericDAO<E> {
	EntityManager em;

	private final Class<E> persistentClass;

	protected GenericDAOImpl() {
		ParameterizedType parameterizedType = (ParameterizedType) getClass()
				.getGenericSuperclass();
		this.persistentClass = (Class<E>) parameterizedType
				.getActualTypeArguments()[0];

	}

	/*
	 * get Name of the Table
	 */
	protected String getPersClassName() {
		return persistentClass.getSimpleName().toUpperCase();
	}

	public E findById(int id) {
		throw new UnsupportedOperationException("not implementet.");
	}

	public E save(E entity) {
		throw new UnsupportedOperationException("not implementet.");
	}

	public List<E> fetchAll() {
		throw new UnsupportedOperationException("not implementet.");
	}

	public void deleteAll() {
		throw new UnsupportedOperationException("not implementet.");
	}

}
