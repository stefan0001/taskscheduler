package de.sep.innovativeoperation.taskscheduler.controller;

import static de.sep.innovativeoperation.taskscheduler.config.Config.JSON;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import de.sep.innovativeoperation.taskscheduler.model.resource.EventTaskResource;
import de.sep.innovativeoperation.taskscheduler.model.resource.EventTasksResource;
import de.sep.innovativeoperation.taskscheduler.service.eventtask.EventTaskResourceService;

@Controller
@RequestMapping(value = "/eventtask")
public class EventTaskController {

	@Autowired
	private EventTaskResourceService eventTaskResourceService;
	
	
	/**
	 * Load all EventTasks
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, produces = JSON)
	public @ResponseBody EventTasksResource getAllEventTasks() {
		return eventTaskResourceService.getAll();
	}

	/**
	 * Load one EventTask
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/{eventtaskid}", method = RequestMethod.GET, produces = JSON)
	public @ResponseBody EventTaskResource getOneEventTask(@PathVariable("eventtaskid") int id) {
		return eventTaskResourceService.getById(id);
	}
	
	
	/**
	 * Update a EventTask
	 * @param id	id of the EventTask
	 * @param eventTaskResource	EventTaskResource containing the information for the update
	 * @return EventTaskResource containing the event with all updated informations
	 */
	@RequestMapping(value = "/{timetaskid}", method = RequestMethod.PUT, produces = JSON)
	public @ResponseBody EventTaskResource updateEventTask(@PathVariable("timetaskid") int id, @RequestBody EventTaskResource eventTaskResource) {
		return eventTaskResourceService.updateEventTask(id, eventTaskResource);
	}
	
	
	/**
	 * Delete a EventTask
	 * @param id	id of the eventTask
	 */
	@RequestMapping(value = "/{eventtaskid}", method = RequestMethod.DELETE, produces = JSON)
	public @ResponseBody void deleteEventTask(@PathVariable("eventtaskid") int id) {
		eventTaskResourceService.deleteById(id);
	}
	
	
	
	/**
	 * Creating a new EventTask
	 * @param eventTaskResource	EventTaskResource containing the information for the new EventTask
	 * @return EventTaskResource containing the new EventTask
	 */
	@RequestMapping(method = RequestMethod.POST, produces = JSON)
	public @ResponseBody EventTaskResource createEventTask(@RequestBody EventTaskResource eventTaskResource) {
		return eventTaskResourceService.createEventTask(eventTaskResource);
	}
	
	
	
}
