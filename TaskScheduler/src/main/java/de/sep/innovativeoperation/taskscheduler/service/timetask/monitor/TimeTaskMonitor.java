package de.sep.innovativeoperation.taskscheduler.service.timetask.monitor;

import java.util.Calendar;

import org.springframework.stereotype.Service;


@Service
public class TimeTaskMonitor {
	
	
	public Calendar generateNextFireTime(Calendar firstFireTime, int intervall){
		Calendar now = Calendar.getInstance();

		Calendar fireTime = (Calendar) firstFireTime.clone();
		
		while(now.compareTo(fireTime) >= 0){
			fireTime.add(Calendar.SECOND, intervall);
		}
		return fireTime;
	}
	
	
}
