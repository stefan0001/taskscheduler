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
import de.sep.innovativeoperation.taskscheduler.model.data.Event;
import de.sep.innovativeoperation.taskscheduler.model.data.EventTask;
import de.sep.innovativeoperation.taskscheduler.model.data.IssueDraft;
import de.sep.innovativeoperation.taskscheduler.service.validation.EventTaskValidationService;

@TransactionConfiguration(defaultRollback = true)
@ContextConfiguration({ "classpath:applicationContext.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class EventTaskValidationServiceTest {
	
private EventTask eventTask;
private Event event;
private Set<IssueDraft> issueDrafts;
@Autowired
EventTaskValidationService eventTaskValidationService;

	@Before
	public void setUp() throws Exception {
		event = new Event("eventName");
		eventTask = new EventTask();
		issueDrafts=new HashSet<IssueDraft>();
		eventTask.setId(42);
		eventTask.setName("startingTestName");
		eventTask.setEvent(event);
		eventTask.setIssueDrafts(issueDrafts);
	}

	//checkObject //TODO testCheckNullObject?
//	@Test(expected = ValidationFailureException.class)
//	public void testCheckNullObject() {		
//		eventTaskValidationService.checkObject(null);
//	}
//	
	@Test(expected = ValueIsNotValidException.class)
	public void testCheckNullNameObject() {		
		eventTask.setName(null);
		eventTaskValidationService.checkObject(eventTask);
	}
	
	@Test(expected = ValueIsNotValidException.class)
	public void testCheckOverlengthNameObject() {		
		eventTask.setName("abababababababababababababababaabababababababababababababababababaababababababababaaaaaababababababab");
//		System.out.println(eventTask.getName() + eventTask.getName().length());
		eventTaskValidationService.checkObject(eventTask);
	}
	
	//TODO testCheckEmptyNameObject Name = "";
	@Test(expected = ValueIsNotValidException.class)
	public void testCheckEmptyNameObject() {		
		eventTask.setName("");
//		System.out.println(eventTask.getName() + eventTask.getName().length());
		eventTaskValidationService.checkObject(eventTask);
	}

//	@Test
	//TODO testgoodObject? wie und überhaupt?
//	public void testCheckGoodObject() {		
//		eventTaskValidationService.checkObject(eventTask);
//		assertTrue(eventTask.getId()>0);
//	}
//	

}
