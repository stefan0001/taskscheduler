package de.sep.innovativeoperation.taskscheduler.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;




import de.sep.innovativeoperation.taskscheduler.dao.IssueEntityDAO;
import de.sep.innovativeoperation.taskscheduler.model.IssueEntity;

/**
 * Logic for IssueEntity management
 * 
 * @author Stefan
 * 
 */
@Service
public class IssueEntityService {

	@Autowired
	private IssueEntityDAO issueEntityDAO;
	
	
	
	public IssueEntity getIssueEntityById(int id){
		IssueEntity entity;
		
		entity = issueEntityDAO.findById(id);
		
		return entity;
	}
	
	public List<IssueEntity> getAllIssueEntities(){
		return issueEntityDAO.fetchAll();
	}
	
	public void deleteAll(){
		issueEntityDAO.deleteAll();
	}
	
	
	

}
