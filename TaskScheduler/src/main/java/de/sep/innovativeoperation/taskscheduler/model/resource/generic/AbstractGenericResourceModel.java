package de.sep.innovativeoperation.taskscheduler.model.resource.generic;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resource;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import de.sep.innovativeoperation.taskscheduler.model.data.AbstractDataModel;

@JsonIgnoreProperties({"id"})
public abstract class AbstractGenericResourceModel<D extends AbstractDataModel> extends Resource<D> {

	
	public AbstractGenericResourceModel(D content) {
		super(content);
	}
	
	@JsonIgnore
	@Override
	public Link getId(){
		return super.getId();
	}
	


}
