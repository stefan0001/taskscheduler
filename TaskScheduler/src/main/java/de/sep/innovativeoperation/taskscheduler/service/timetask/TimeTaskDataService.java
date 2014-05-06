package de.sep.innovativeoperation.taskscheduler.service.timetask;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import de.sep.innovativeoperation.taskscheduler.dao.TimeTaskDAO;
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
	public TimeTask createTimeTask(TimeTask timeTask){
		//id should be 0 for new entity
		timeTask.setId(0);
		
		//
		timeTaskValidationSerive.checkObject(timeTask);
		
		//set  NextFireTime
		timeTask.setNextFireTime(generateNextFireTime(timeTask.getFirstFireTime(),timeTask.getIntervall()) );
		
		
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
		timeTaskOld.setNextFireTime( generateNextFireTime(timeTask.getFirstFireTime(),timeTask.getIntervall()) );
		timeTaskOld.setActivated(timeTask.isActivated());
		return timeTaskOld;
	}
	
	
	private Calendar generateNextFireTime(Calendar firstFireTime, int intervall){
		Calendar now = Calendar.getInstance();
		System.out.println("NOW="+now.getTimeInMillis());
		Calendar fireTime = (Calendar) firstFireTime.clone();
		System.out.println("NOW="+fireTime.getTimeInMillis());
		
		while(now.compareTo(fireTime) >= 0){
			fireTime.add(Calendar.SECOND, intervall);
		}
		return fireTime;
	}
	
	
	
	
	
}
