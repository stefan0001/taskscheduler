package de.sep.innovativeoperation.taskscheduler.controller;

import java.util.HashMap;
import java.util.Map;

public class Test {
	private Map<String, String> map = new HashMap<String,String>();
	
	Test(){
		map.put("A", "a");
	}

	public Map<String, String> getMap() {
		return map;
	}

	public void setMap(Map<String, String> map) {
		this.map = map;
	}
}
