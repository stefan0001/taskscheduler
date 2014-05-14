package de.sep.innovativeoperation.test.services.validation;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import de.sep.innovativeoperation.taskscheduler.exception.validation.ValidationFailureException;
import de.sep.innovativeoperation.taskscheduler.exception.validation.ValueIsNotValidException;
import de.sep.innovativeoperation.taskscheduler.exception.validation.ValueIsNullException;
import de.sep.innovativeoperation.taskscheduler.model.data.Event;
import de.sep.innovativeoperation.taskscheduler.model.data.EventTask;
import de.sep.innovativeoperation.taskscheduler.model.data.IssueDraft;
import de.sep.innovativeoperation.taskscheduler.model.data.IssueEntity;
import de.sep.innovativeoperation.taskscheduler.model.data.IssueResolution;
import de.sep.innovativeoperation.taskscheduler.model.data.IssueStatus;
import de.sep.innovativeoperation.taskscheduler.model.data.IssueType;
import de.sep.innovativeoperation.taskscheduler.service.validation.EventTaskValidationService;
import de.sep.innovativeoperation.taskscheduler.service.validation.EventValidationService;
import de.sep.innovativeoperation.taskscheduler.service.validation.IssueDraftValidationService;
import de.sep.innovativeoperation.taskscheduler.service.validation.IssueEntityValidationService;

@TransactionConfiguration(defaultRollback = true)
@ContextConfiguration({ "classpath:applicationContext.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class IssueEntityValidationServiceTest {
	
	private IssueEntity issueEntity;
	
	@Autowired
	IssueEntityValidationService issueEntityValidationService;

	@Before
	public void setUp() throws Exception {
		issueEntity = new IssueEntity();
		issueEntity.setIssueResolution(IssueResolution.DONE);
		issueEntity.setIssueStatus(IssueStatus.RESOLVED);
	}

	@Test(expected = ValueIsNullException.class)
	public void testCheckNullResolution() {
		issueEntity.setIssueResolution(null);
		issueEntityValidationService.checkObject(issueEntity);
	}

	@Test(expected = ValueIsNullException.class)
	public void testCheckNullIssueStatus() {
		issueEntity.setIssueStatus(null);		
		issueEntityValidationService.checkObject(issueEntity);
	}	

//	public String generateStringWithLength(int length) {
//		StringBuffer outputBuffer = new StringBuffer(length);
//		for (int i = 0; i < length; i++) {
//			outputBuffer.append("a");
//		}
//		return outputBuffer.toString();
//	}

}
