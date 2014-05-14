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
import de.sep.innovativeoperation.taskscheduler.model.data.IssueType;
import de.sep.innovativeoperation.taskscheduler.service.validation.EventTaskValidationService;
import de.sep.innovativeoperation.taskscheduler.service.validation.EventValidationService;
import de.sep.innovativeoperation.taskscheduler.service.validation.IssueDraftValidationService;

@TransactionConfiguration(defaultRollback = true)
@ContextConfiguration({ "classpath:applicationContext.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class IssueDraftValidationServiceTest {

	// private EventTask eventTask;
	private IssueDraft issueDraft;
	@Autowired
	IssueDraftValidationService issueDraftValidationService;

	@Before
	public void setUp() throws Exception {
		issueDraft = new IssueDraft();
		issueDraft.setIssueName("foo");
		issueDraft.setIssueDescription("foo");
		issueDraft.setIssueType(IssueType.BUG);
	}

	@Test(expected = ValueIsNullException.class)
	public void testCheckNullNameObject() {
		issueDraft.setIssueName(null);
		issueDraftValidationService.checkObject(issueDraft);
	}

	@Test(expected = ValueIsNotValidException.class)
	public void testCheckOverlength51IssueNameObject() {
		issueDraft.setIssueName(generateStringWithLength(51));		
		issueDraftValidationService.checkObject(issueDraft);
	}

	// TODO testCheckEmptyNameObject Name = "";
	@Test(expected = ValueIsNotValidException.class)
	public void testCheckEmptyNameObject() {
		issueDraft.setIssueName("");		
		issueDraftValidationService.checkObject(issueDraft);
	}

	@Test(expected = ValueIsNullException.class)
	public void testCheckNullIssueDescription() {
		issueDraft.setIssueDescription(null);

		issueDraftValidationService.checkObject(issueDraft);
	}

	@Test(expected = ValueIsNotValidException.class)
	public void testCheckOverlength501IssueDescription() {

		issueDraft.setIssueDescription(generateStringWithLength(501));

		issueDraftValidationService.checkObject(issueDraft);
	}

	@Test(expected = ValueIsNullException.class)
	public void testCheckNullIssueType() {

		issueDraft.setIssueType(null);

		issueDraftValidationService.checkObject(issueDraft);
	}

	public String generateStringWithLength(int length) {
		StringBuffer outputBuffer = new StringBuffer(length);
		for (int i = 0; i < length; i++) {
			outputBuffer.append("a");
		}
		return outputBuffer.toString();
	}

}
