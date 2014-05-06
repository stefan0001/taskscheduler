package sample;

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
public class TestCREATESAMPLETASK {
	@Autowired
	TimeTaskDAO timeTaskDAO;
	
	@Test
	public void test(){
		TimeTask timeTask = new TimeTask("test");
		
		timeTaskDAO.save(timeTask);
	}
}
