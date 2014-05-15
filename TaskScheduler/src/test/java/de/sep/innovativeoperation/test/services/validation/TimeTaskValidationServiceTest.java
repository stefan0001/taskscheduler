package de.sep.innovativeoperation.test.services.validation;

import static org.junit.Assert.*;

import java.util.Calendar;
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
import de.sep.innovativeoperation.taskscheduler.model.data.IssueResolution;
import de.sep.innovativeoperation.taskscheduler.model.data.IssueStatus;
import de.sep.innovativeoperation.taskscheduler.model.data.IssueType;
import de.sep.innovativeoperation.taskscheduler.model.data.TimeTask;
import de.sep.innovativeoperation.taskscheduler.service.validation.EventTaskValidationService;
import de.sep.innovativeoperation.taskscheduler.service.validation.EventValidationService;
import de.sep.innovativeoperation.taskscheduler.service.validation.IssueDraftValidationService;
import de.sep.innovativeoperation.taskscheduler.service.validation.IssueEntityValidationService;
import de.sep.innovativeoperation.taskscheduler.service.validation.TimeTaskValidationService;

@TransactionConfiguration(defaultRollback = true)
@ContextConfiguration({ "classpath:applicationContext.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class TimeTaskValidationServiceTest {

	private TimeTask timeTask;

	@Autowired
	TimeTaskValidationService timeTaskValidationService;

	@Before
	public void setUp() {
		timeTask = new TimeTask();
		timeTask.setName("foo");
		Calendar firstFireTime = Calendar.getInstance();
		timeTask.setFirstFireTime(firstFireTime);
		timeTask.setIntervall(0);
	}

	@Test(expected = ValueIsNullException.class)
	public void testCheckNullName() {
		timeTask.setName(null);
		timeTaskValidationService.checkObject(timeTask);
	}

	@Test(expected = ValueIsNotValidException.class)
	public void testCheckOverlength501Name() {
		timeTask.setName(generateStringWithLength(101));
		timeTaskValidationService.checkObject(timeTask);
	}

	@Test(expected = ValueIsNotValidException.class)
	public void testCheckEmptyName() {
		timeTask.setName("");
		timeTaskValidationService.checkObject(timeTask);
	}

	@Test(expected = ValueIsNullException.class)
	public void testCheckNullFirstFireTime() {
		timeTask.setFirstFireTime(null);
		timeTaskValidationService.checkObject(timeTask);
	}

	@Test(expected = ValueIsNotValidException.class)
	public void testCheckIntervallOver3600() {
		timeTask.setIntervall(3599);
		timeTaskValidationService.checkObject(timeTask);
	}

	@Test(expected = ValueIsNotValidException.class)
	public void testCheckIntervallMAX_VALUE() {
		timeTask.setIntervall(Integer.MAX_VALUE);
		timeTaskValidationService.checkObject(timeTask);
	}

	@Test(expected = ValueIsNotValidException.class)
	public void testCheckIntervallMIN_VALUE() {
		timeTask.setIntervall(Integer.MIN_VALUE);
		timeTaskValidationService.checkObject(timeTask);
	}

	public String generateStringWithLength(int length) {
		StringBuffer outputBuffer = new StringBuffer(length);
		for (int i = 0; i < length; i++) {
			outputBuffer.append("a");
		}
		return outputBuffer.toString();
	}

}
