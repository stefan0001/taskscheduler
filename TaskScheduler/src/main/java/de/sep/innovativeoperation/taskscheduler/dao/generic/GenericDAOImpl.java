package de.sep.innovativeoperation.taskscheduler.dao.generic;

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


	protected GenericDAOImpl() {


	}

	protected abstract String getClassName();
	
	/*
	 * get Name of the Table
	 */


	public E findById(int id) {
		throw new UnsupportedOperationException("not implementet.");
	}

	public E save(E entity) {
		throw new UnsupportedOperationException("not implementet.");
	}

	public List<E> fetchAll() {
		EntityManager em = this.emf.createEntityManager();
		//CREATE QUERY AND EXECUTE NA DGET THE LIST
		List<E> list = (List<E>)( (em.createQuery("SELECT e FROM " + getClassName() + " e" )).getResultList() );
		em.close();
		
		return list;
	}

	public void deleteAll() {
		EntityManager em = this.emf.createEntityManager();
		
		em.getTransaction().begin();
		//EXECUTE UPDATE QUERY
		(em.createQuery("DELETE FROM " + getClassName() + " e")).executeUpdate();
		em.getTransaction().commit();
		
		em.close();
		

	}

}
