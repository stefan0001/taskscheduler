package de.sep.innovativeoperation.taskscheduler.dao.generic;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.ParameterizedType;;


public class GenericDAOjpa <T> implements GenericDAO <T>{
	
	/**
	 * Inject the EntityManager
	 */
	@PersistenceContext(unitName = "H2Connection")
	protected EntityManager em;

	/**
	 * the name of the persistent class (IssueEntity, IssueEntity.... )
	 */
	private final Class<T> persistentClass;

	protected GenericDAOjpa() {
		// Initial the persistent class
		ParameterizedType parameterizedType = (ParameterizedType) getClass().getGenericSuperclass();
		this.persistentClass = (Class<T>) parameterizedType.getActualTypeArguments()[0];
	}

	@Transactional
	public T findById(int id) {
		return em.find(persistentClass, id);
	}


	@Transactional(propagation = Propagation.REQUIRED)
	public T save(T entity) {
		return em.merge(entity);

	}


	@Transactional
	public List<T> fetchAll() {
		// CREATE QUERY AND EXECUTE THE QUERY
		CriteriaQuery<T> selectQuery = em.getCriteriaBuilder().createQuery(
				persistentClass);
		selectQuery.from(persistentClass);
		return em.createQuery(selectQuery).getResultList();
	}
	
	@Transactional(propagation = Propagation.REQUIRED)
	public void deleteById(int id) {
		throw new UnsupportedOperationException();

	}
	

	@Transactional(propagation = Propagation.REQUIRED)
	public void deleteAll() {
		throw new UnsupportedOperationException();

	}
	
}
