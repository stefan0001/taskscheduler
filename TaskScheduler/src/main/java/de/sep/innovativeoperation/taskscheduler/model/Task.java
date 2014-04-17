package de.sep.innovativeoperation.taskscheduler.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;

@Entity
public class Task {
	

	public Task() {	
		
	}
	
	/**
	 * 
	 * @param name Name of this Task
	 * @param issueDrafts Set of issueDrafts
	 */
	public Task(String name) {
		this.name = name;
		this.issueDrafts = issueDrafts;
	}
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotNull
	private String name;
	
	/*Child of the Task <--> IssueDraft relationship*/
	@ManyToMany(mappedBy="tasks")
	private Set<IssueDraft> issueDrafts;
	

	

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

	public void setId(int id) {
		this.id = id;
	}
	
}
