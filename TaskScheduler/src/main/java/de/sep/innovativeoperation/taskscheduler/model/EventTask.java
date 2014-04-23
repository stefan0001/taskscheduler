package de.sep.innovativeoperation.taskscheduler.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

/**
 * 
 * @author Innovative Operation
 * A Task which creates issues when a specific event was triggered.
 */
@Entity
public class EventTask {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int eventTaskId;
	
	@NotNull
	private String name;
	
	/*Owner of the EventTask <--> IssueDraft relationship*/
	@ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
	private Set<IssueDraft> issueDrafts = new HashSet<IssueDraft>();
	
	/*Owner of the EventTask <--> Event relationship*/
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinColumn(name = "EVENT_EVENTID")
	private Event event;
	
	public EventTask() {	
		
	}
	
	/**
	 * 
	 * @param name Name of this Task
	 */
	public EventTask(String name) {
		this.name = name;
	}
	

	public Set<IssueDraft> getIssueDrafts() {
		return issueDrafts;
	}

	public void setIssueDrafts(Set<IssueDraft> issueDrafts) {
		this.issueDrafts = issueDrafts;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return eventTaskId;
	}

	public void setId(int eventTaskId) {
		this.eventTaskId = eventTaskId;
	}

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

}
