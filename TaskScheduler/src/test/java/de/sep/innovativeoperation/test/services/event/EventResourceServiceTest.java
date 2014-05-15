package de.sep.innovativeoperation.test.services.event;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import de.sep.innovativeoperation.taskscheduler.exception.validation.ValueIsNotValidException;
import de.sep.innovativeoperation.taskscheduler.exception.validation.ValueIsNullException;
import de.sep.innovativeoperation.taskscheduler.model.data.Event;
import de.sep.innovativeoperation.taskscheduler.model.resource.EventResource;
import de.sep.innovativeoperation.taskscheduler.service.assembler.event.EventResourceAssembler;
import de.sep.innovativeoperation.taskscheduler.service.event.EventDataService;
import de.sep.innovativeoperation.taskscheduler.test.MyUtil;

@Transactional
@TransactionConfiguration(defaultRollback = true)
@ContextConfiguration({ "classpath:applicationContext.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class EventResourceServiceTest {

	@Autowired
	EventDataService eventDataService;

	// ASSEMBLER
	@Autowired
	EventResourceAssembler eventResourceAssembler;

	private Event event;
	private EventResource eventResource;
	private Event otherEvent;
	private int maxNameLength = 100;

	@Before
	public void setUp() throws Exception {
		event = new Event();
		event.setName("foo");
		event.setId(0);
		event.setEventTasks(null);

		otherEvent = new Event("baa", null);

	}

	@Test
	public void testEventToResource() {
		// event.setId(11);
		Event savedEvent = eventDataService.createEvent(event);
		EventResource savedEventResource = eventResourceAssembler.toResource(savedEvent);
		// List<Link> links = eventResource.getLinks();
		// System.out.println(""+links.get(0).toString());
		// for (Link link : links) {
		// System.out.println(""+link.toString());
		// }
//		assertTrue
		assertTrue(savedEventResource.hasLinks());
		// assertTrue(savedEvent.getName().equals("foo"));
	}

//	@Test
//	public void testEventToResources() {
//		// event.setId(11);
//		Event otherEvent = new Event("otherEvent");
//		Event rhirdEvent = new Event("thirdEvent");
//		Event savedEvent = eventDataService.createEvent(event);
//		Event savedOtherEvent = eventDataService.createEvent(otherEvent);
//		Event savedThirdEvent = eventDataService.createEvent(rhirdEvent);
//		Set<Event> events = new HashSet<Event>();
//		events.add(savedEvent);
//		events.add(savedOtherEvent);
//		events.add(savedThirdEvent);
//
//		eventResource = eventResourceAssembler.toResources();
//		// List<Link> links = eventResource.getLinks();
//		// System.out.println(""+links.get(0).toString());
//		// for (Link link : links) {
//		// System.out.println(""+link.toString());
//		// }
//		assertTrue(eventResource.hasLinks());
//		// assertTrue(savedEvent.getName().equals("foo"));
//	}
	//
	// @Test(expected = ValueIsNotValidException.class)
	// public void testCreateNullNameEvent() {
	// event.setName(null);
	// eventDataService.createEvent(event);
	// }
	//
	// @Test
	// public void testCreateMaxNameEvent() {
	//
	// String hugeName = MyUtil.generateStringWithLength(maxNameLength, "a");
	// event.setName(hugeName);
	// // System.out.println(hugeName==null);
	// // System.out.println(hugeName);
	// assertTrue(event.getId() == 0);
	// Event savedEvent = eventDataService.createEvent(event);
	//
	// assertTrue(savedEvent.getId() > 0);
	// assertFalse(savedEvent.getName().equals("foo"));
	// assertTrue(savedEvent.getName().equals(hugeName));
	// assertTrue(savedEvent.getName().length() == hugeName.length());
	// }
	//
	// @Test(expected = ValueIsNotValidException.class)
	// public void testCreateOverSizedNameEvent() {
	//
	// String hugeName = MyUtil.generateStringWithLength(maxNameLength + 1,
	// "a");
	// event.setName(hugeName);
	// // System.out.println(hugeName==null);
	// // System.out.println(hugeName);
	// eventDataService.createEvent(event);
	// // assertTrue(savedEvent.getId() > 0);
	// // assertFalse(savedEvent.getName().equals("foo"));
	// // assertTrue(savedEvent.getName().length() == hugeName.length());
	// }
	//
	// @Test(expected = ValueIsNotValidException.class)
	// public void testCreateMultipleNameEvent() {
	//
	// for (int i = 0; i < 101; i++) {
	// event.setName(MyUtil.generateStringWithLength(i, "\""));
	// Event savedEvent = new Event();
	// savedEvent = eventDataService.createEvent(event);
	// assertNotNull(savedEvent);
	// System.out.println(savedEvent.getId() + " = "
	// + savedEvent.getName());
	// assertTrue(savedEvent.getId() > 0);
	// }
	// event.setName(MyUtil.generateStringWithLength(101, "\""));
	// assertTrue(event.getName().length() == (maxNameLength + 1));
	// eventDataService.createEvent(event);
	// }
	//
	// @Test
	// public void testUpdateGoodEvent() {
	// assertTrue(event.getId() == 0);
	// Event savedEvent = eventDataService.createEvent(event);
	// int savedId = savedEvent.getId();
	// assertTrue(savedId > 0);
	// Event updatedEvent = eventDataService.updateEvent(savedId, otherEvent);
	// assertTrue(updatedEvent.getId() > 0);
	// assertTrue(updatedEvent.getName().equals(otherEvent.getName()));
	// }
	//
	// @Test(expected = ValueIsNotValidException.class)
	// public void testUpdateEventWithNull() {
	// assertTrue(event.getId() == 0);
	// Event savedEvent = eventDataService.createEvent(event);
	// int savedId = savedEvent.getId();
	// assertTrue(savedId > 0);
	// eventDataService.updateEvent(savedId, null);
	// // assertTrue(updatedEvent.getId() > 0);
	// // assertTrue(updatedEvent.getName().equals(otherEvent.getName()));
	// }
	// @Test(expected = ValueIsNotValidException.class)
	// public void testUpdateEventWithNoName() {
	// assertTrue(event.getId() == 0);
	// Event savedEvent = eventDataService.createEvent(event);
	// int savedId = savedEvent.getId();
	// assertTrue(savedId > 0);
	// otherEvent.setName("");
	// Event updatedEvent = eventDataService.updateEvent(savedId, otherEvent);
	// // assertTrue(updatedEvent.getId() > 0);
	// // assertTrue(updatedEvent.getName().equals(otherEvent.getName()));
	// }
	//
	//
	//
	// @Test(expected = ValueIsNotValidException.class)
	// public void testUpdateUnsavedEventWithSavedEvent() {
	//
	// Event otherSavedEvent = eventDataService.createEvent(otherEvent);
	// assertTrue(otherSavedEvent.getId()>0);
	//
	// eventDataService.updateEvent(event.getId(), otherEvent);
	// }
	// @Test(expected = ValueIsNotValidException.class)
	// public void testUpdateSavedEventWithUnsavedEvent() {
	//
	// Event savedEvent = eventDataService.createEvent(event);
	// assertTrue(savedEvent.getId()>0);
	//
	// eventDataService.updateEvent(event.getId(), otherEvent);
	// }
	// @Test(expected = ValueIsNotValidException.class)
	// public void testUpdateUnsavedEventWithUnsavedEvent() {
	// assertTrue(event.getId() == 0);
	// assertNotNull(otherEvent);
	// assertNotNull(event);
	//
	// eventDataService.updateEvent(event.getId(), otherEvent);
	// }
	//
	// @Test
	// public void testTrigger() {
	// fail("Not yet implemented");
	// }

	// @After
	// public void cleanUp(){
	// List<Event> allEvents = eventDataService.getAll();
	// int countEvents=0;
	// for (Event event : allEvents) {
	// eventDataService.deleteById(event.getId());
	// countEvents++;
	// }
	// System.out.println(countEvents);
	// }
}
