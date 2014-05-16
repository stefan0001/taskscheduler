package de.sep.innovativeoperation.taskscheduler.model.data;


import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@SuppressWarnings("serial")
@Entity
@JsonIgnoreProperties({"issueDrafts"})
public class TimeTask extends AbstractDataModel{
	/*Auto-generated ID*/
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	
	@NotNull
	@Column(length=100) 
	private String name;
	
	/*Owner of the TimeTask <--> IssueDraft relationship*/
	@ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
	private Set<IssueDraft> issueDrafts = new HashSet<IssueDraft>();
	
	/* Stores Date and Time. */
	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar firstFireTime;
	
	@JsonProperty
	@JsonIgnore
	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar nextFireTime;
	
	
	//TODO
	/*Interval in seconds*/
	@NotNull
	private int intervall;
	
	
	@NotNull
	private boolean activated;
	
	@JsonProperty
	@JsonIgnore
	@NotNull
	private int fireCount;
	
	
	
	public TimeTask() {	
		this(null);
	}
	
	//TODO
	public TimeTask(String name) {
		this(name,Calendar.getInstance(),Calendar.getInstance(),0,0,false );
	}
	
	public TimeTask(String name, Calendar firstFireTime, Calendar nextFireTime,int intervall) {
		this(name,firstFireTime,nextFireTime,0,intervall,false );
	}
	


	/**
	 * 
	 * @param name
	 * @param firstFireTime
	 * @param nextFireTime
	 * @param firecount
	 * @param intervall
	 * @param activated
	 */
	public TimeTask(String name, Calendar firstFireTime, Calendar nextFireTime,int firecount, int intervall, boolean activated) {
		this.id = 0;
		this.name = name;
		this.issueDrafts = new HashSet<IssueDraft>();
		this.firstFireTime = firstFireTime;
		this.nextFireTime = nextFireTime;
		this.intervall = intervall;
		this.setActivated(activated);
		this.setFireCount(firecount);
	}
	
	
	@Override
	public int getId() {
		return id;
	}
	@Override
	public void setId(int id) {
		this.id = id;
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


	public boolean isActivated() {
		return activated;
	}

	public void setActivated(boolean activated) {
		this.activated = activated;
	}

	public Calendar getNextFireTime() {
		return nextFireTime;
	}
	
	//TODO
	//changing nextfiretime from controller is not allowed
	@JsonIgnore
	public void setNextFireTime(Calendar nextFireTime) {
		this.nextFireTime = nextFireTime;
	}
	
	public int getFireCount() {
		return fireCount;
	}
	//TODO
	//changing firecount is not allowed
	@JsonIgnore
	public void setFireCount(int firecount) {
		this.fireCount = firecount;
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
