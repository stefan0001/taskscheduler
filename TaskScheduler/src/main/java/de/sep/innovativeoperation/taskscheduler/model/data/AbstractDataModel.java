package de.sep.innovativeoperation.taskscheduler.model.data;

import java.io.Serializable;



@SuppressWarnings("serial")
public abstract class AbstractDataModel implements Serializable{

	public abstract int getId();
	
	public abstract void setId(int id);
}
