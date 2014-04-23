package de.sep.innovativeoperation.taskscheduler.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import de.sep.innovativeoperation.taskscheduler.dao.EventTaskDAO;
import de.sep.innovativeoperation.taskscheduler.model.EventTask;

public class EventTaskService {
	
	@Autowired
	private EventTaskDAO eventTaskDAO;
	
	public List<EventTask> getAllEventTasks(){
		
		return eventTaskDAO.fetchAll();
	}
	
	public EventTask getEventTaskById(int id){
		return eventTaskDAO.findById(id);
	}
	
	public void deleteEventTaskById(int id){
		eventTaskDAO.deleteById(id);
	}
	
	public void deleteAllEventTasks(){
		eventTaskDAO.deleteAll();
	}
}
