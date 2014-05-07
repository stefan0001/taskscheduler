package de.sep.innovativeoperation.taskscheduler.service.timetask.monitor;

import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.sep.innovativeoperation.taskscheduler.dao.TimeTaskDAO;
import de.sep.innovativeoperation.taskscheduler.model.data.TimeTask;
import de.sep.innovativeoperation.taskscheduler.service.issueentity.IssueEntityDataService;
import de.sep.innovativeoperation.taskscheduler.service.timetask.TimeTaskDataService;


@Service
public class TimeTaskMonitor {
	
	//Cant use generic cause of specific method
	@Autowired
	private TimeTaskDAO timeTaskDAO;
	
	@Autowired
	private IssueEntityDataService issueEntityService;
	
	private Locale locale = Locale.UK;
	private Calendar currentTime = Calendar.getInstance(locale);
	
	public Calendar generateNextFireTime(Calendar firstFireTime, int intervall){

		Calendar fireTime = (Calendar) firstFireTime.clone();
		
		while(currentTime.compareTo(fireTime) >= 0){
			fireTime.add(Calendar.SECOND, intervall);
		}
		return fireTime;
	}
	
	public void monitorTimTasks(){
		List<TimeTask> timeTasks = timeTaskDAO.getTimeTaskWithNextFireTimeOlderThan(currentTime);
		createIssue(timeTasks);
	}
	
	private void createIssue(List<TimeTask> timeTasks){
		Iterator<TimeTask> timeTaskiterator = timeTasks.iterator();
	}
	
}
