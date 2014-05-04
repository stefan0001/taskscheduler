package de.sep.innovativeoperation.taskscheduler.model.resource.generic;





import java.util.HashMap;
import java.util.Map;

import org.springframework.hateoas.Resource;

import de.sep.innovativeoperation.taskscheduler.model.data.AbstractDataModel;

//TODO
public abstract class AbstractGenericResourceModel<D extends AbstractDataModel> extends Resource<D>{
	private Map<String,AbstractGenericResourceModel<?>> embedded = new HashMap<String, AbstractGenericResourceModel<?>>();
	
	public AbstractGenericResourceModel(D content){
		super(content);
	}

	public Map<String,AbstractGenericResourceModel<?>> getEmbedded() {
		return embedded;
	}

}
