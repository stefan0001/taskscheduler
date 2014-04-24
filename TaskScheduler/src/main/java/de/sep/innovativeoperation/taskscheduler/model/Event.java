package de.sep.innovativeoperation.taskscheduler.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

@Entity
public class Event {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int eventId;
	
	@NotNull
	private String name;

	@OneToMany( mappedBy = "event", cascade = {CascadeType.ALL})
	private Set<EventTask> eventTasks = new HashSet<EventTask>();
	
	
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


	public int getEventId() {
		return eventId;
	}


	public void setEventId(int eventId) {
		this.eventId = eventId;
	}

}
