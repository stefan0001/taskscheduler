package de.sep.innovativeoperation.taskscheduler.dao.generic.jpa;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import de.sep.innovativeoperation.taskscheduler.dao.generic.GenericDAO;
import de.sep.innovativeoperation.taskscheduler.model.IssueDraft;

@Repository
public abstract class GenericDAOjpa <T> implements GenericDAO <T>{
	
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
	
	
	
	protected abstract void addJoinsToRoot(Root<T> root);
	
	
	
	//TODO
	@Transactional
	public T findByIdWithRelations(int id) {
		CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
		
		CriteriaQuery<T> query = criteriaBuilder.createQuery(persistentClass);
		Root<T> root = query.from(persistentClass);
		
		//ADD ALL JOINS
		this.addJoinsToRoot(root);
		
		//Search for id
		query.where(criteriaBuilder.equal(root.get("id"), id));
		
		
		TypedQuery<T> result = em.createQuery(query);
		
		List<T> list = result.getResultList();
		if(list.size() > 0 ){
			return list.get(0);
		}
		//no result was found return null
		return null;
	}
	
	//TODo
	@Transactional
	public List<T> fetchAllWithRelations(){
		CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
		CriteriaQuery<T> query = criteriaBuilder.createQuery(persistentClass);
		Root<T> root = query.from(persistentClass);
		
		//ADD ALL JOINS
		this.addJoinsToRoot(root);
		
		TypedQuery<T> result = em.createQuery(query);
		
		return result.getResultList();
	}
	
	
	
}
