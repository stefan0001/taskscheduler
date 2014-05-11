package de.sep.innovativeoperation.taskscheduler.controller;

import static de.sep.innovativeoperation.taskscheduler.config.Config.JSON;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import de.sep.innovativeoperation.taskscheduler.model.resource.EventResource;
import de.sep.innovativeoperation.taskscheduler.model.resource.EventsResource;
import de.sep.innovativeoperation.taskscheduler.service.event.EventResourceService;

@Controller
@RequestMapping(value = "/event")
public class EventController {
	//RESOURCE SERVICE
	@Autowired
	EventResourceService eventResourceService;

	/**
	 * get all events
	 * @return EventsResource
	 */
	@RequestMapping(method = RequestMethod.GET, produces = JSON)
	public @ResponseBody EventsResource getEvents(){
		return eventResourceService.getAll();
	}
	
	
	/**
	 * get one event
	 * @param id  	id of the event
	 * @return EventResource
	 */
	@RequestMapping(value = "/{eventid}", method = RequestMethod.GET, produces = JSON)
	public @ResponseBody EventResource getEvent(@PathVariable("eventid") int id){
		return eventResourceService.getById(id);
	}
	
	/**
	 * create a new event
	 * @param eventResource the event with the raw data
	 * @return EventResource with the saved Event from database
	 */
	@RequestMapping( method = RequestMethod.POST, produces = JSON)
	public @ResponseBody EventResource createEvent(@RequestBody EventResource eventResource){
		return eventResourceService.createEvent(eventResource);
	}
	
	
	/**
	 * delete the event with the given id
	 * @param id	id of the event
	 * @return
	 */
	@RequestMapping(value = "/{eventid}", method = RequestMethod.DELETE, produces = JSON)
	public @ResponseBody void deleteEvent(@PathVariable("eventid") int id){
		eventResourceService.deleteById(id);
	}
	
	
	/**
	 * Update the event with the given id
	 * @param id eventid
	 * @param eventResource	The EventResource the the raw data
	 * @return EventResource with the updated event from database
	 */
	@RequestMapping(value = "/{eventid}", method = RequestMethod.PUT, produces = JSON)
	public @ResponseBody EventResource updateEvent(@PathVariable("eventid") int id, @RequestBody EventResource eventResource){
		return eventResourceService.updateEvent(id, eventResource);
	}
	
	
	/**
	 * Trigger a Event
	 * @param id EventId
	 * @return OK the event got triggered
	 */
	@RequestMapping(value = "/{eventid}/trigger", method = RequestMethod.PUT, produces = JSON)
	public @ResponseBody void updateEvent(@PathVariable("eventid") int id){
		//TODO
	}
	
	
}
