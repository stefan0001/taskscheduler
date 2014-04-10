package de.sep.innovativeoperation.taskscheduler.dao.generic;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

/**
 * 
 * @author Stefan
 * 
 * @param <E>
 */

public abstract class GenericDAOImpl<E> implements GenericDAO<E> {
	private EntityManagerFactory emf;

	@PersistenceUnit
	public void setEntityManagerFactory(EntityManagerFactory emf) {
		this.emf = emf;
	}

	private final Class<E> persistentClass;

	protected GenericDAOImpl() {
		ParameterizedType parameterizedType = (ParameterizedType) getClass().getGenericSuperclass();
		this.persistentClass = (Class<E>) parameterizedType.getActualTypeArguments()[0];

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
		EntityManager em = this.emf.createEntityManager();
		
		List<E> list = (List<E>)em.createQuery("SELECT e FROM " + getPersClassName() + " e" );
		em.close();
		
		return list;
		
	}

	public void deleteAll() {
		throw new UnsupportedOperationException("not implementet.");
	}

}
