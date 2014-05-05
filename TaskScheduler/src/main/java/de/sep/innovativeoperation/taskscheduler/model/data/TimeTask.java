package de.sep.innovativeoperation.taskscheduler.model.data;


import java.sql.Date;
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

@SuppressWarnings("serial")
@Entity
@JsonIgnoreProperties({"issueDrafts"})
public class TimeTask extends AbstractDataModel{
	/*Auto-generated ID*/
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	
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
		this(null);
	}
	
	//TODO
	public TimeTask(String name) {
		this(name,new GregorianCalendar(),0,new HashSet<IssueDraft>() );
	}
	

	/**
	 * Creates a new TimeTask
	 * @param name			Name of the Timetask
	 * @param firstFireTime	The first fire Time
	 * @param intervall		The time to the next execution
	 * @param issueDrafts   All IssueDrafts that are used by this TimeTak
	 */
	public TimeTask(String name, Calendar firstFireTime, int intervall, Set<IssueDraft> issueDrafts) {
		this.name = name;
		this.firstFireTime = firstFireTime;
		this.intervall = intervall;
		this.issueDrafts = issueDrafts;
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
	@Override
	public int getId() {
		return id;
	}
	@Override
	public void setId(int id) {
		this.id = id;
	}

	public Calendar getFirstFireTime() {
		return firstFireTime;
	}


	public void setFirstFireTime(Calendar calendar) {
		this.firstFireTime = calendar;
	}

	public int getIntervall() {
		return intervall;
	}

	public void setIntervall(int intervall) {
		this.intervall = intervall;
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
		TimeTask other = (TimeTask) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	
	

	
}
