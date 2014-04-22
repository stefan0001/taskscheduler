package de.sep.innovativeoperation.taskscheduler.dao.generic;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public interface GenericDAO <T> {
	//CREATE
	public T save(T entity);
	
	
	//READ
	public T findById(int id);
	
	public List<T> fetchAll();
	
	
	//DELETE
	public void deleteById(int id);
	
	public void deleteAll();
	
}
