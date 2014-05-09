
package de.sep.innovativeoperation.taskscheduler.service.timetask;

import java.util.Calendar;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import de.sep.innovativeoperation.taskscheduler.dao.TimeTaskDAO;
import de.sep.innovativeoperation.taskscheduler.exception.http.ResourceNotFoundException;
import de.sep.innovativeoperation.taskscheduler.model.data.IssueDraft;
import de.sep.innovativeoperation.taskscheduler.model.data.TimeTask;
import de.sep.innovativeoperation.taskscheduler.service.AbstractGenericDataService;
import de.sep.innovativeoperation.taskscheduler.service.issuedraft.IssueDraftDataService;
import de.sep.innovativeoperation.taskscheduler.service.timetask.monitor.TimeTaskMonitor;
import de.sep.innovativeoperation.taskscheduler.service.validation.TimeTaskValidationService;

@Service
@Transactional
public class TimeTaskDataService extends AbstractGenericDataService<TimeTask> {
	//DAO
	@Autowired
	private TimeTaskDAO timeTaskDAO;

	@Autowired
	private TimeTaskMonitor timeTaskMonitor;
	
	//SERVICES
	@Autowired
	private IssueDraftDataService issueDraftDataService;
	
	//VALIDATION
	@Autowired
	private TimeTaskValidationService timeTaskValidationSerive;
	
	/**
	 * create a new timetask and save
	 * @param timetask
	 * @return the saved timetask
	 */
	public TimeTask createTimeTask(TimeTask timeTask){
		//id should be 0 for new entity
		timeTask.setId(0);
		
		//
		timeTaskValidationSerive.checkObject(timeTask);
		
		//generate nextfiretime
		Calendar nextFireTime = timeTaskMonitor.generateNextFireTime(timeTask.getFirstFireTime(), timeTask.getIntervall());

		timeTask.setNextFireTime(nextFireTime);
		
		
		return timeTaskDAO.save(timeTask);

	}
	
	/**
	 * update a TimeTask with the given id
	 * @param id	id of the TimeTask
	 * @param timeTask
	 * @return
	 */
	public TimeTask updateTimeTask(int id, TimeTask timeTask){
		
		//find 
		TimeTask timeTaskOld = this.getById(id);
		
		//find task
		timeTaskValidationSerive.checkObject(timeTask);
		
		//update object
		timeTaskOld.setName(timeTask.getName());
		timeTaskOld.setIntervall(timeTask.getIntervall());
		timeTaskOld.setFirstFireTime(timeTask.getFirstFireTime());
		
		Calendar nextFireTime = timeTaskMonitor.generateNextFireTime(timeTask.getFirstFireTime(), timeTask.getIntervall());

		timeTask.setNextFireTime(nextFireTime);
		
		timeTaskOld.setActivated(timeTask.isActivated());
		return timeTaskOld;
	}
	
	/**
	 * get all IssueDrafts for the TimeTask with the id
	 * @param id 	id of the TimeTask
	 * @return
	 */
	public Set<IssueDraft> getIssueDraftsforTimeTask(int id){
		TimeTask timeTask = this.getById(id);
		return timeTask.getIssueDrafts();
	}
	

	/**
	 * create a relation between a timetask and a issuedraft
	 * for id of issueDraft == 0 a new issuedraft is created
	 * @param timeTaskId
	 * @param issueDraft
	 * @return
	 */
	public IssueDraft createRelationTimeTaskIssueDraft(int timeTaskId, IssueDraft issueDraft){
		TimeTask timeTaskFromDB = this.getById(timeTaskId);
		IssueDraft issueDraftFromDB;
		
		if(issueDraft.getId() == 0){
			//for id == 0 create a new issuedraft
			issueDraftFromDB = issueDraftDataService.createIssueDraft(issueDraft);
		} else {
			//else try to finde the issuedraft
			issueDraftFromDB = issueDraftDataService.getById(issueDraft.getId());
		}
		
			
		return createRelationTimeTaskIssueDraft(timeTaskFromDB, issueDraftFromDB);
		
	}
	
	
	/**
	 * create a relation between a timetask and a issuedraft
	 * @param timeTaskId
	 * @param issueDraftId
	 */
	private IssueDraft createRelationTimeTaskIssueDraft(TimeTask timeTask, IssueDraft issueDraft){
		
		if(timeTask.getIssueDrafts().contains(issueDraft) ){
			//TODO
			throw new ResourceNotFoundException();
		}
		timeTask.getIssueDrafts().add(issueDraft);
		return issueDraft;
	}
	
	
	
	/**
	 * delete a relation between a timetask and a issuedraft
	 * @param timeTaskId
	 * @param issueDraftId
	 */
	public void deleteRelationTimeTaskIssueDraft(int timeTaskId, int issueDraftId){
		TimeTask timeTask = this.getById(timeTaskId);
		IssueDraft issueDraft = issueDraftDataService.getById(issueDraftId);
		
		
		if(!timeTask.getIssueDrafts().contains(issueDraft) ){
			throw new ResourceNotFoundException();
		}
		timeTask.getIssueDrafts().remove(issueDraft);
	}

	
	
	
	
	
	
}
