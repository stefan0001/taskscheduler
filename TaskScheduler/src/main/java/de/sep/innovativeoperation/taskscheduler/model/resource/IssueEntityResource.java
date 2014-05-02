package de.sep.innovativeoperation.taskscheduler.model.resource;

import de.sep.innovativeoperation.taskscheduler.model.data.IssueEntity;
import de.sep.innovativeoperation.taskscheduler.model.resource.generic.AbstractGenericResourceModel;

//@XmlRootElement
//@XmlSeeAlso({ IssueEntity.class })
public class IssueEntityResource extends AbstractGenericResourceModel<IssueEntity> {
	
	public IssueEntityResource() {
		super(new IssueEntity() );
	}
	
	public IssueEntityResource(IssueEntity content) {
		super(content);
		// TODO Auto-generated constructor stub
	}


}
