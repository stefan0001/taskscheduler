package de.sep.innovativeoperation.taskscheduler.test;

import java.util.Calendar;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import de.sep.innovativeoperation.taskscheduler.dao.TimeTaskDAO;
import de.sep.innovativeoperation.taskscheduler.model.data.TimeTask;

@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(defaultRollback = true)
@Transactional
public class TimeTaskMonitorTest {
	@Autowired
	TimeTaskDAO timeTaskDAO;
	
	@Test
	public void test(){
		
		Calendar time = Calendar.getInstance();
		time.setTimeInMillis(1009929600000L);
		System.out.println(time.getTime());
		List<TimeTask> timeTasks = timeTaskDAO.getTimeTaskWithNextFireTimeOlderThan(time);
		System.out.println(timeTasks.size() );
	}
}
