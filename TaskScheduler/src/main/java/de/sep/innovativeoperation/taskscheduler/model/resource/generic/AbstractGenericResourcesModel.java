package de.sep.innovativeoperation.taskscheduler.model.resource.generic;

import org.springframework.hateoas.Resources;

public abstract class AbstractGenericResourcesModel<T extends AbstractGenericResourceModel<?>> extends Resources<T> {



	public AbstractGenericResourcesModel(Iterable<T> content) {
		super(content);
	}
	
	

}
