package de.sep.innovativeoperation.taskscheduler.service.timetask;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import de.sep.innovativeoperation.taskscheduler.dao.TimeTaskDAO;
import de.sep.innovativeoperation.taskscheduler.exception.http.ResourceNotFoundException;
import de.sep.innovativeoperation.taskscheduler.model.data.TimeTask;
import de.sep.innovativeoperation.taskscheduler.service.AbstractGenericDataService;
import de.sep.innovativeoperation.taskscheduler.service.validation.TimeTaskValidationService;

@Service
@Transactional
public class TimeTaskDataService extends AbstractGenericDataService<TimeTask> {
	@Autowired
	private TimeTaskDAO timeTaskDAO;
	
	@Autowired
	private TimeTaskValidationService timeTaskValidationSerive;
	
	/**
	 * create a new timetask and save
	 * @param timetask
	 * @return the saved timetask
	 */
	public TimeTask createTimeTask(TimeTask timetask){
		//id should be 0 for new entity
		timetask.setId(0);
		
		timeTaskValidationSerive.checkObject(timetask);
		
		return timeTaskDAO.save(timetask);
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
		
		timeTaskValidationSerive.checkObject(timeTask);
		
		//id change is not allowed
		timeTask.setId(id);
		
		//changing Relations is not allowed
		timeTask.setIssueDrafts(timeTaskOld.getIssueDrafts());
		
		
		return timeTaskDAO.save(timeTask);
	}
	
	
	
	
	
}
