package de.sep.innovativeoperation.taskscheduler.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
public class TestA {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name;
	
	@OneToMany(mappedBy="mya", cascade = {CascadeType.ALL})
	private Set<TestB> myb = new HashSet<TestB>();

	public Set<TestB> getMyB() {
		return myb;
	}

	public void setMyB(Set<TestB> myb) {
		this.myb = myb;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
