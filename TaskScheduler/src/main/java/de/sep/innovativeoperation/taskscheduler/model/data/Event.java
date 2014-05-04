package de.sep.innovativeoperation.taskscheduler.model.data;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@SuppressWarnings("serial")
@Entity
@JsonIgnoreProperties("eventTasks")
public class Event extends AbstractDataModel{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotNull
	private String name;

	@OneToMany( mappedBy = "event", cascade = {CascadeType.ALL})
	private Set<EventTask> eventTasks = new HashSet<EventTask>();
	
	/**
	 * Creates an Event with no Name and and no tasks
	 */
	public Event() {
		this(null,null);
	}
	
	/**
	 * Creates an Event with only a name and empty task list
	 * @param name Name of the eventtask
	 */
	public Event(String name) {
		this(name,null);
	}
	
	
	
	
	/**
	 * Create a Event with a name and all Tasks that use this event
	 * @param name
	 * @param eventTasks
	 */
	public Event(String name, Set<EventTask> eventTasks) {
		this.name = name;
		this.eventTasks = eventTasks;
	}
	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Set<EventTask> getEventTasks() {
		return eventTasks;
	}



	public void setEventTasks(Set<EventTask> eventTasks) {
		this.eventTasks = eventTasks;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}

}
