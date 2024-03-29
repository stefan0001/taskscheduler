package de.sep.innovativeoperation.taskscheduler.model;


import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({"issueDrafts"})
public class TimeTask {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int timeTaskId;
	
	@NotNull
	private String name;
	
	/*Owner of the TimeTask <--> IssueDraft relationship*/
	@ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
	private Set<IssueDraft> issueDrafts = new HashSet<IssueDraft>();
	
	/* Stores Date and Time. */
	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar firstFireTime = new GregorianCalendar();
	
	/*Interval in days*/
	@NotNull
	private int intervall;
	
	
	public TimeTask() {	
		
	}
	
	/**
	 * 
	 * @param name Name of this Task
	 */
	public TimeTask(String name) {
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
		return timeTaskId;
	}

	public void setId(int timeTaskId) {
		this.timeTaskId = timeTaskId;
	}

	public Calendar getFirstFireTime() {
		return firstFireTime;
	}

	/**
	 * 
	 * @param year
	 * @param month
	 * @param dayOfMonth Starts at zero, January = 0
	 * @param hourOfDay
	 * @param minute
	 */
	public void setFirstFireTime(int year, int month, int dayOfMonth, int hourOfDay, int minute) {
		this.firstFireTime = new GregorianCalendar(year, month, dayOfMonth, hourOfDay, minute);
	}

	public int getIntervall() {
		return intervall;
	}

	public void setIntervall(int intervall) {
		this.intervall = intervall;
	}

	
}
