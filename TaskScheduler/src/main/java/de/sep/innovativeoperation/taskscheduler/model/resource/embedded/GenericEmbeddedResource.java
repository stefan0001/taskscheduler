package de.sep.innovativeoperation.taskscheduler.model.resource.embedded;

import de.sep.innovativeoperation.taskscheduler.model.resource.generic.AbstractGenericResourceModel;


public abstract class GenericEmbeddedResource<T extends AbstractGenericResourceModel<?>>{
	protected T resource;
	
	public GenericEmbeddedResource(T resource){
		this.resource = resource;
	}
	
	public T getResource(){
		return resource;

	}
	
	public void setResource(T resource){
		this.resource = resource;

	}
}
