package de.sep.innovativeoperation.test.persistence.issuedraft;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import de.sep.innovativeoperation.taskscheduler.exception.validation.ValidationFailureException;
import de.sep.innovativeoperation.taskscheduler.service.IssueDraftService;

@TransactionConfiguration(defaultRollback = false)
@ContextConfiguration({ "classpath:applicationContext.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class TestIssueDraftService {
	@Autowired
	IssueDraftService issueDraftService;
	
	@Test
	public void test(){
		try {
			issueDraftService.test();
		} catch (ValidationFailureException e) {
			e.printStackTrace();
		}
	}
}
