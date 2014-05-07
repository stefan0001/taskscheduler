package de.sep.innovativeoperation.taskscheduler.model.resource.generic;

import org.springframework.hateoas.Resource;

import de.sep.innovativeoperation.taskscheduler.model.data.AbstractDataModel;

public abstract class AbstractGenericResourceModel<D extends AbstractDataModel> extends Resource<D> {

	public AbstractGenericResourceModel(D content) {
		super(content);
	}

}
