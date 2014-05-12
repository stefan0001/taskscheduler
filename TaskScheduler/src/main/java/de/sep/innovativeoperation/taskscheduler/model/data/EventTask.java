package de.sep.innovativeoperation.taskscheduler.model.data;

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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@SuppressWarnings("serial")
@Entity
@JsonIgnoreProperties({"issueDrafts","event"})
public class EventTask extends AbstractDataModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotNull
	private String name;
	
	/*Owner of the EventTask <--> IssueDraft relationship*/
	@ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
	private Set<IssueDraft> issueDrafts = new HashSet<IssueDraft>();
	
	/*Owner of the EventTask <--> Event relationship*/
	@NotNull
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinColumn(name = "EVENT_EVENTID")
	private Event event;
	

	
	/**
	 * Creates an Event Task with no name, empty issueDraft list and no event
	 */
	public EventTask(){
		this(null, new HashSet<IssueDraft>(), null );
	}
	
	//TODO
	public EventTask(String name){
		this(name, new HashSet<IssueDraft>(), null );
	}
	


	//TODO
	/**
	 * 
	 * @param name
	 * @param issueDrafts
	 * @param event
	 */
	public EventTask(String name, Set<IssueDraft> issueDrafts,Event event) {
		this.name = name;
		this.issueDrafts = issueDrafts;
		this.event = event;
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
		return id;
	}
	
	@Override
	public void setId(int id) {
		this.id = id;
	}

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EventTask other = (EventTask) obj;
		if (id != other.id)
			return false;
		return true;
	}




	
	

}
