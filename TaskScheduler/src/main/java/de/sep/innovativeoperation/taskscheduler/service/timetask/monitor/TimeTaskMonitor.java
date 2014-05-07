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
import de.sep.innovativeoperation.taskscheduler.model.data.IssueDraft;
import de.sep.innovativeoperation.taskscheduler.model.data.IssueEntity;
import de.sep.innovativeoperation.taskscheduler.model.data.IssueResolution;
import de.sep.innovativeoperation.taskscheduler.model.data.IssueStatus;
import de.sep.innovativeoperation.taskscheduler.model.data.TimeTask;
import de.sep.innovativeoperation.taskscheduler.service.issueentity.IssueEntityDataService;


@Service
@Transactional
public class TimeTaskMonitor {
	
	//Can't use generic cause of specific method
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
	
	/**
	 * Monitoring the persisted TimeTasks
	 */
	@Scheduled(fixedDelay = 6000)
	public void monitorTimTasks(){
		List<TimeTask> timeTasks = timeTaskDAO.getTimeTaskWithNextFireTimeOlderThan(currentTime);
		if(!timeTasks.isEmpty())createIssuesForTimeTasks(timeTasks);
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
			
			if(currentTimeTask.isActivated()){
				//first, lets create all IssueEntites related to this current timetask
				createIssueEntityForTimeTask(currentTimeTask);
			}
			
			//second, update NextFireTime of current timetask
			currentTimeTask.setNextFireTime(generateNextFireTime(currentTimeTask.getFirstFireTime(), currentTimeTask.getIntervall()));
		}
	}
	
	/**
	 * Creates IssueEntities for one TimeTask
	 * @param timeTask 
	 */
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
