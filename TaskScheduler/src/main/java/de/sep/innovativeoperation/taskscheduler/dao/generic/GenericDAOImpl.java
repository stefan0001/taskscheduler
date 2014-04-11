package de.sep.innovativeoperation.taskscheduler.dao.generic;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

/**
 * 
 * @author Stefan
 * 
 * @param <E>
 */


public abstract class GenericDAOImpl<E> implements GenericDAO<E> {
	@PersistenceContext(unitName = "H2Connection")
	private EntityManager em;




	protected GenericDAOImpl() {
	}

	protected abstract String getClassName();
	
	/*
	 * get Name of the Table
	 */

	//TODO
	@Transactional
	public E findById(int id) {
		return null;
	}

	@Transactional
	public E save(E entity) {
		em.persist(entity);
		return entity;
	}

	@Transactional
	public List<E> fetchAll() {
		//CREATE QUERY AND EXECUTE THE QUERY
		List<E> list = (List<E>)( (em.createQuery("SELECT e FROM " + getClassName() + " e" )).getResultList() );
		
		return list;
	}
	
	
	@Transactional
	public void deleteAll() {
		//EXECUTE UPDATE QUERY
		(em.createQuery("DELETE FROM " + getClassName() + " e")).executeUpdate();

	}

}
	