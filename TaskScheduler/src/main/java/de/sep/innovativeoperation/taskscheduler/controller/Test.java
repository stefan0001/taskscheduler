package de.sep.innovativeoperation.taskscheduler.controller;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Test {
	@JsonProperty(value="id")
	private int test;
	
	@JsonProperty(value="id")
	public int getI() {
		return test;
	}
	
	@JsonProperty(value="id")
	public void setI(int id) {
		this.test = id;
	}
	
}
