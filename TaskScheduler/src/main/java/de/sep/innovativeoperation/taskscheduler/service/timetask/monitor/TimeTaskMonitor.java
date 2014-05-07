package de.sep.innovativeoperation.taskscheduler.service.timetask.monitor;

import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.sep.innovativeoperation.taskscheduler.dao.TimeTaskDAO;
import de.sep.innovativeoperation.taskscheduler.model.data.IssueDraft;
import de.sep.innovativeoperation.taskscheduler.model.data.IssueEntity;
import de.sep.innovativeoperation.taskscheduler.model.data.IssueResolution;
import de.sep.innovativeoperation.taskscheduler.model.data.IssueStatus;
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
		createIssues(timeTasks);
	}
	
	private void createIssues(List<TimeTask> timeTasks){
		Iterator<TimeTask> timeTaskIterator = timeTasks.iterator();
		
		while(timeTaskIterator.hasNext()){
			TimeTask currentTimeTask = timeTaskIterator.next();
			createIssueEntityForTimeTask(currentTimeTask);
		}
	}
	
	private void createIssueEntityForTimeTask(TimeTask timeTask){
		Iterator<IssueDraft> issueDraftIterator = timeTask.getIssueDrafts().iterator();
		
		//as long as there are IssueDrafts in the queue
		while(issueDraftIterator.hasNext()){
			IssueDraft currentIssueDraft = issueDraftIterator.next();
			
			//create and set up a new issueEntity for this issueDraft
			IssueEntity newIssueEntity = new IssueEntity();
			newIssueEntity.setId(0);
			newIssueEntity.setIssueResolution(IssueResolution.UNRESOLVED);
			newIssueEntity.setIssueStatus(IssueStatus.NEW);
			
			//let the service do the persistence thing
			issueEntityService.createIssueEntity(currentIssueDraft.getId(), newIssueEntity);
		}
	}
	
	
}