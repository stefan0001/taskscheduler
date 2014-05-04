package de.sep.innovativeoperation.taskscheduler.model.resource.generic;

import org.springframework.hateoas.Resources;

//TODO
public abstract class AbstractGenericResourcesModel<R extends AbstractGenericResourceModel<?>> extends Resources<R> {

	public AbstractGenericResourcesModel() {
		super();
		// TODO Auto-generated constructor stub
	}


	public AbstractGenericResourcesModel(Iterable<R> content) {
		super(content);
		// TODO Auto-generated constructor stub
	}





}
