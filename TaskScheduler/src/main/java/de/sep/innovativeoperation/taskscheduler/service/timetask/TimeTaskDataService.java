
package de.sep.innovativeoperation.taskscheduler.service.timetask;

import java.util.Calendar;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import de.sep.innovativeoperation.taskscheduler.dao.TimeTaskDAO;
import de.sep.innovativeoperation.taskscheduler.model.data.IssueDraft;
import de.sep.innovativeoperation.taskscheduler.model.data.TimeTask;
import de.sep.innovativeoperation.taskscheduler.model.resource.IssueDraftResource;
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
	 * add a IssueDraft to a TimeTask
	 * @param id 	id of the TimeTask
	 * @return
	 */
	public IssueDraft addIssueDraftstoTimeTask(int id, IssueDraft issueDraft){
		//find timetask with the id
		TimeTask timeTask = this.getById(id);
		
		//check issuedraft id 
		//if 0 create a new issuedraft
		if(issueDraft.getId() == 0){
			issueDraft = issueDraftDataService.createIssueDraft(issueDraft);
		} else {
			//find issueDraft
			issueDraft = issueDraftDataService.getById(issueDraft.getId());
		}
		
		//assign relation
		timeTask.getIssueDrafts().add(issueDraft);
		
		return issueDraft;
		
	}
	
	
	
	
}
