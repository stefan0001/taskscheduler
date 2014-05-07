package de.sep.innovativeoperation.timetaskdao;

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

@TransactionConfiguration(defaultRollback = false)
@ContextConfiguration({ "classpath:applicationContext.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class TimeTaskDAOTest {
	@Autowired
	TimeTaskDAO timeTaskDAO;

	
	
	
	@Test
	public void test(){
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(1009926000000L);
		System.out.println(calendar.toString());
		List<TimeTask> timetasks = timeTaskDAO.getTimeTaskWithNextFireTimeOlderThan(calendar);
		System.out.println("---------------------------------");
		
		
		System.out.println("HOW MANY TIMETASK ARE IN THE DATABASE?");
		System.out.println("THE ANSWER IS: " +  timetasks.size());
	}
}