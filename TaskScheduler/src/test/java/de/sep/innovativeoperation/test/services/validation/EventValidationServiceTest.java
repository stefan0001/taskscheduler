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
import de.sep.innovativeoperation.taskscheduler.service.validation.EventValidationService;

@TransactionConfiguration(defaultRollback = true)
@ContextConfiguration({ "classpath:applicationContext.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class EventValidationServiceTest {

	// private EventTask eventTask;
	private Event event;
	@Autowired
	EventValidationService eventValidationService;

	@Before
	public void setUp() throws Exception {
		event = new Event("eventName");
		event.setId(0);
	}

	@Test(expected = ValueIsNotValidException.class)
	public void testCheckNullNameObject() {
		event.setName(null);
		eventValidationService.checkObject(event);
	}

	@Test(expected = ValueIsNotValidException.class)
	public void testCheckOverlengthNameObject() {
		event.setName("abababababababababababababababaabababababababababababababababababaababababababababaaaaaababababababab");
		// System.out.println(eventTask.getName() +
		// eventTask.getName().length());
		eventValidationService.checkObject(event);
	}

	// TODO testCheckEmptyNameObject Name = "";
	@Test(expected = ValueIsNotValidException.class)
	public void testCheckEmptyNameObject() {
		event.setName("");
		// System.out.println(eventTask.getName() +
		// eventTask.getName().length());
		eventValidationService.checkObject(event);
	}

	// @Test
	// TODO testgoodObject? wie und überhaupt?
	// public void testCheckGoodObject() {
	// eventTaskValidationService.checkObject(eventTask);
	// assertTrue(eventTask.getId()>0);
	// }
	//

}
