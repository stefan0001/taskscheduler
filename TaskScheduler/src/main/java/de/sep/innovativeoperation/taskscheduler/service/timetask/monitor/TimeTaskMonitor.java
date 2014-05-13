package de.sep.innovativeoperation.taskscheduler.service.timetask.monitor;

import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import de.sep.innovativeoperation.taskscheduler.dao.TimeTaskDAO;
import de.sep.innovativeoperation.taskscheduler.model.data.TimeTask;
import de.sep.innovativeoperation.taskscheduler.service.trigger.TimeTaskTrigger;


@Service
@Transactional
public class TimeTaskMonitor {
	
	
	@Autowired
	private TimeTaskTrigger trigger;
	
	//Can't use generic cause of specific method
	@Autowired
	TimeTaskDAO timeTaskDAO;
	
	private Locale locale = Locale.UK;
	private Calendar currentTime = Calendar.getInstance(locale);
	
	/**
	 * Calculates new next fire time
	 * @param firstFireTime of time task
	 * @param intervall of time task, given in milliseconds
	 * @return next fire time
	 */
	public Calendar generateNextFireTime(Calendar firstFireTime, int intervall){

		Calendar fireTime = (Calendar) firstFireTime.clone();
		
		while(currentTime.compareTo(fireTime) >= 0 && intervall > 0){
			System.out.println("change next firetime");
			fireTime.add(Calendar.SECOND, intervall);
		}
		return fireTime;
	}
	
	/**
	 * Monitoring the persisted TimeTasks
	 */
	@Scheduled(fixedDelay = 6000)
	public void monitorTimTasks(){
		
		currentTime = Calendar.getInstance(locale);
		
		System.out.println();
		/* get all time tasks which shall fire issues*/
		List<TimeTask> timeTasks = timeTaskDAO.getTimeTaskWithNextFireTimeOlderThan(currentTime);
		System.out.println(timeTasks.isEmpty());
		if(!timeTasks.isEmpty()){
			createIssuesForTimeTasks(timeTasks);
		}
	}
	
	/**
	 * Creates IssueEntites for all TimeTasks
	 * @param timeTasks List of timeTask
	 */
	private void createIssuesForTimeTasks(List<TimeTask> timeTasks){
		
		Iterator<TimeTask> timeTaskIterator = timeTasks.iterator();
		
		//Lets create IssueEntites for all TimeTasks in this list 
		while(timeTaskIterator.hasNext()){
			
			TimeTask currentTimeTask = timeTaskIterator.next();
			System.out.println(currentTimeTask.getId() + " " + currentTimeTask.getNextFireTime());
			if(currentTimeTask.isActivated()){
				//first, lets create all IssueEntites related to this current time task
				trigger.trigger(currentTimeTask);
			}
			
			//second, update NextFireTime of current time task
			System.out.println(currentTimeTask.getIntervall());
			currentTimeTask.setNextFireTime(generateNextFireTime(currentTimeTask.getFirstFireTime(), currentTimeTask.getIntervall()));
			System.out.println(currentTimeTask.getId() + " " + currentTimeTask.getNextFireTime());
		}
	}

}
