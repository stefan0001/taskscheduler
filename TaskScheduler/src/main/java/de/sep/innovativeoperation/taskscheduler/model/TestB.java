package de.sep.innovativeoperation.taskscheduler.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
public class TestB {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name = "A_ID")
	private TestA mya = new TestA();
	
	private String name;

	public TestA getMyA() {
		return mya;
	}

	public void setMyA(TestA mya) {
		this.mya = mya;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
