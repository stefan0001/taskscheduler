package de.sep.innovativeoperation.taskscheduler.model.resource.generic;


import org.springframework.hateoas.Resource;

import de.sep.innovativeoperation.taskscheduler.model.data.AbstractDataModel;

//TODO
public abstract class AbstractGenericResourceModel<T extends AbstractDataModel> extends Resource<T>{

	public AbstractGenericResourceModel(T content){
		super(content);
	}


	


	


}
