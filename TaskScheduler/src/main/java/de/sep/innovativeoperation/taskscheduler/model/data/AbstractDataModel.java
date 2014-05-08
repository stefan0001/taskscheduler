package de.sep.innovativeoperation.taskscheduler.model.data;

import java.io.Serializable;

import org.springframework.hateoas.Identifiable;




@SuppressWarnings("serial")
public abstract class AbstractDataModel implements Serializable, Identifiable<Integer>{
	

	public abstract Integer getId();
	

	public abstract void setId(int id);
}
