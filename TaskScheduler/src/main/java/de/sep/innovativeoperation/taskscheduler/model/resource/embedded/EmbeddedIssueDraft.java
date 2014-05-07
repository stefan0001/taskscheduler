package de.sep.innovativeoperation.taskscheduler.model.resource.embedded;

import com.fasterxml.jackson.annotation.JsonProperty;

import de.sep.innovativeoperation.taskscheduler.model.data.IssueDraft;
import de.sep.innovativeoperation.taskscheduler.model.resource.generic.AbstractGenericResourceModel;

public class EmbeddedIssueDraft extends GenericEmbeddedResource< AbstractGenericResourceModel<IssueDraft> > {

	public EmbeddedIssueDraft(AbstractGenericResourceModel<IssueDraft> t) {
		super(t);
		// TODO Auto-generated constructor stub
	}
	
	@JsonProperty("issueDraft")
	@Override
	public AbstractGenericResourceModel<IssueDraft> getResource(){
		return resource;
	}

}
