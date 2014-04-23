package de.sep.innovativeoperation.taskscheduler.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.sep.innovativeoperation.taskscheduler.dao.EventDAO;
import de.sep.innovativeoperation.taskscheduler.model.Event;

@Service
public class EventService {

	@Autowired
	private EventDAO eventDAO;
	
	public List<Event> getAllEvents(){
		return eventDAO.fetchAll();
	}
	
	public Event getEventById(int id){
		return eventDAO.findById(id);
	}
	
	public void deleteEventById(int id){
		eventDAO.deleteById(id);
	}
	
	public void deleteAllEvents(){
		eventDAO.deleteAll();
	}
	
}
