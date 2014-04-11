package de.sep.innovativeoperation.taskscheduler.dao.generic;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;

import de.sep.innovativeoperation.taskscheduler.model.IssueEntity;

/**
 * 
 * @author Stefan
 * 
 * @param <E>
 */

public abstract class GenericDAOImpl<E> implements GenericDAO<E> {
	protected EntityManager em;

	protected final Class<E> persistentClass;

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
		
		return em.find(persistentClass, id);
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
