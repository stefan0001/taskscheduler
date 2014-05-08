package de.sep.innovativeoperation.test.model;

import java.util.HashSet;
import java.util.Set;

import static junit.framework.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import de.sep.innovativeoperation.taskscheduler.model.data.Event;
import de.sep.innovativeoperation.taskscheduler.model.data.EventTask;

@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class TestEventModel {
	
	private Event event;
	private Set<EventTask> eventTaskSet;
	private EventTask eventTask;
	
	@Before
	public void setUp(){
		event = new Event();
		event.setId(0);
		event.setName("name");
		event.setId(42);
		
		eventTask = new EventTask();
		eventTaskSet = new HashSet<EventTask>();
		eventTaskSet.add(eventTask);
		event.setEventTasks(eventTaskSet);
		
//		System.out.println(event.getName());
//		System.out.println("setupende");

	}
	@Test
	public void testEventSetName() throws Exception {
		event.setName("newName");
		assertNotNull(event.getName());
		assertTrue(event.getName().equals("newName"));
	}
	
	@Test 
	public void testEventGetName() throws Exception {
		String eventName = event.getName();
		assertNotNull(eventName);
		assertTrue(eventName.equals("name"));
	}
	
	@Test
	public void testSetEventTasksSet() throws Exception {
		EventTask tempTask = new EventTask();
		Set<EventTask> tempSet = new HashSet<EventTask>();
		tempSet.add(tempTask);
		event.setEventTasks(tempSet);
		assertTrue(event.getEventTasks().contains(tempTask));
	}
	
	@Test
	public void testGetEventTasksSet() throws Exception {
		Set<EventTask> tempSet = new HashSet<EventTask>();
		tempSet = event.getEventTasks();
		assertTrue(tempSet.contains(eventTask));
	}
	
	@Test
	public void testSetAndGetEventID() throws Exception {
		event.setId(24);
		assertTrue(event.getId()==24);
		
	}
	
	
	
}
