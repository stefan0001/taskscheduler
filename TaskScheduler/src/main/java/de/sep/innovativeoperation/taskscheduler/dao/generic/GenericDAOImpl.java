package de.sep.innovativeoperation.taskscheduler.dao.generic;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * 
 * @author Stefan
 * 
 * @param <E>
 */

public abstract class GenericDAOImpl<E> implements GenericDAO<E> {
	/**
	 * Inject the EntityManager
	 */
	@PersistenceContext(unitName = "H2Connection")
	protected EntityManager em;

	/**
	 * the name of the persistent class (IssueEntity, IssueEntity.... )
	 */
	private final Class<E> persistentClass;

	protected GenericDAOImpl() {
		// Initial the persistent class
		ParameterizedType parameterizedType = (ParameterizedType) getClass().getGenericSuperclass();
		this.persistentClass = (Class<E>) parameterizedType.getActualTypeArguments()[0];
	}

	@Transactional
	public E findById(int id) {
		return em.find(persistentClass, id);
	}


	@Transactional(propagation = Propagation.REQUIRED)
	public E save(E entity) {
		return em.merge(entity);

	}


	@Transactional
	public List<E> fetchAll() {
		// CREATE QUERY AND EXECUTE THE QUERY
		CriteriaQuery<E> selectQuery = em.getCriteriaBuilder().createQuery(
				persistentClass);
		selectQuery.from(persistentClass);
		return em.createQuery(selectQuery).getResultList();
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void deleteAll() {
		throw new UnsupportedOperationException();

	}

}
