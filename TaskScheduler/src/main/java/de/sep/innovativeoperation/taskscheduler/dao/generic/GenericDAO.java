package de.sep.innovativeoperation.taskscheduler.dao.generic;

import java.util.List;

import org.springframework.stereotype.Component;

/**
 * 
 * @author Stefan
 * 
 * @param <E>
 */

public interface GenericDAO<E> {

	public E findById(int id);

	public E save(E entity);

	public List<E> fetchAll();

	public void deleteAll();
}
