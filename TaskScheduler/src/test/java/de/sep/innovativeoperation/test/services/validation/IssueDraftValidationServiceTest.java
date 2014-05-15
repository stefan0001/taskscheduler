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
import de.sep.innovativeoperation.taskscheduler.test.MyUtil;

@TransactionConfiguration(defaultRollback = true)
@ContextConfiguration({ "classpath:applicationContext.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class IssueDraftValidationServiceTest {

	// private EventTask eventTask;
	private IssueDraft issueDraft;
	private int maxNameLetters = 100;
	private int maxDescriptionLetters = 500;
	
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
	public void testCheckOverlength101IssueNameObject() {
		issueDraft.setIssueName(MyUtil.generateStringWithLength(maxNameLetters,"a"));		
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

		issueDraft.setIssueDescription(MyUtil.generateStringWithLength(maxDescriptionLetters+1, "a"));

		issueDraftValidationService.checkObject(issueDraft);
	}

	@Test(expected = ValueIsNullException.class)
	public void testCheckNullIssueType() {

		issueDraft.setIssueType(null);

		issueDraftValidationService.checkObject(issueDraft);
	}


}
