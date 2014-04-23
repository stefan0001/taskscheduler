package de.sep.innovativeoperation.taskscheduler.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.sep.innovativeoperation.taskscheduler.dao.TimeTaskDAO;
import de.sep.innovativeoperation.taskscheduler.model.TimeTask;

@Service
public class TimeTaskService {
	
	@Autowired
	private TimeTaskDAO timeTaskDAO;
	
	public List<TimeTask> getAllTimeTasks(){
		return timeTaskDAO.fetchAll();
	}
	
	public TimeTask getTimeTaskById(int id){
		return timeTaskDAO.findById(id);
	}
	
	public void deleteTimeTaskById(int id){
		timeTaskDAO.deleteById(id);
	}
	
	public void deleteAllTimeTasks(){
		timeTaskDAO.deleteAll();
	}
}
