package de.sep.innovativeoperation.taskscheduler.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.sep.innovativeoperation.taskscheduler.dao.IssueDraftDAO;
import de.sep.innovativeoperation.taskscheduler.model.IssueDraft;

@Service
public class IssueDraftService {
	
	@Autowired
	private IssueDraftDAO issueDraftDAO;
	
	public List<IssueDraft> getAllIssueDrafts(){
		return issueDraftDAO.fetchAll();
	}
	
	public IssueDraft getIssueDraftById(int id){
		return issueDraftDAO.findById(id);
	}
	
	public void deleteIssueDraftById(int id){
		issueDraftDAO.deleteById(id);
	}
	
	public void deleteAllIssueDrafts(){
		issueDraftDAO.deleteAll();
	}
	
}
