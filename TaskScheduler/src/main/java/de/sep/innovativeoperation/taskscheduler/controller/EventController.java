package de.sep.innovativeoperation.taskscheduler.controller;

import static de.sep.innovativeoperation.taskscheduler.config.Config.JSON;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
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
}
