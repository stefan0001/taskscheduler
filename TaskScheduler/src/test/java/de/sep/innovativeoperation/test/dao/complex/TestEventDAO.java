package de.sep.innovativeoperation.test.dao.complex;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolationException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import de.sep.innovativeoperation.taskscheduler.dao.EventDAO;
import de.sep.innovativeoperation.taskscheduler.exception.validation.ValueIsNotValidException;
import de.sep.innovativeoperation.taskscheduler.exception.validation.ValueIsNullException;
import de.sep.innovativeoperation.taskscheduler.model.data.Event;
import de.sep.innovativeoperation.taskscheduler.model.data.EventTask;
import de.sep.innovativeoperation.taskscheduler.model.data.IssueDraft;
import de.sep.innovativeoperation.taskscheduler.model.data.IssueType;

@Transactional
@TransactionConfiguration(defaultRollback = true)
@ContextConfiguration({ "classpath:applicationContext.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class TestEventDAO {

	@Autowired
	EventDAO eventDAO;
	
	private Event event;
	private Set<EventTask> eventTasksSet;
	
	@Before
	public void setUp() {
		eventTasksSet = new HashSet<EventTask>();
		event = new Event();
		event.setId(0);
		event.setEventTasks(eventTasksSet);
		event.setName("Tests schreiben");
		
	}
	
	@Test
	public void testSaveEvent() {
		Event savedEvent = eventDAO.save(event);
		assertTrue(savedEvent.getId()>0);
	}
	
	@Test
	public void testFindEventById() {		
		Event savedEvent = eventDAO.save(event);
		Event foundEvent = eventDAO.findById(savedEvent.getId());
		assertNotNull(foundEvent);
	}
	@Test
	public void testFetchAll() {		
		List<Event> events = eventDAO.fetchAll();		
		assertTrue(events.isEmpty());
		Event savedEvent = eventDAO.save(event);
		assertTrue(savedEvent.getId()>0);
		events = eventDAO.fetchAll();
		assertFalse(events.isEmpty());
	}
	
	@Test
	public void testRemoveEventById() {
		Event savedEvent = eventDAO.save(event);
		int savedEventId = savedEvent.getId();
		assertTrue(savedEventId > 0);
		eventDAO.remove(savedEvent);
		Event removedEvent = eventDAO.findById(savedEventId);
		assertNull(removedEvent);
	}
	
	@Test(expected = UnsupportedOperationException.class)
	public void testExceptionAtDeleteAll() {
		eventDAO.deleteAll();		
	}
	@Test(expected = ConstraintViolationException.class)//TODO Exception
	public void testExceptionAtSaveNullName() {
		event.setName(null);
		eventDAO.save(event);		
	}
	
	@Test(expected = ValueIsNotValidException.class)//TODO Exception
	public void testExceptionAtSave51letterName() {
		String invalidName = "bababababababababababababababababababababababababab";
		assertTrue(invalidName.length()==51);
		event.setName(invalidName);
		eventDAO.save(event);	
	}
	@Test(expected = ValueIsNullException.class)//TODO Exception
	public void testExceptionAtSaveNullEventTasks() {
		event.setEventTasks(null);
		eventDAO.save(event);		
	}
	
}
