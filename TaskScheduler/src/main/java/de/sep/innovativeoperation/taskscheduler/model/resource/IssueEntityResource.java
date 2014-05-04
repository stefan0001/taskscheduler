package de.sep.innovativeoperation.taskscheduler.model.resource;

import de.sep.innovativeoperation.taskscheduler.model.data.IssueEntity;
import de.sep.innovativeoperation.taskscheduler.model.resource.embedded.EmbeddedIssueDraft;
import de.sep.innovativeoperation.taskscheduler.model.resource.generic.AbstractGenericResourceModel;


//@XmlRootElement
//@XmlSeeAlso({ IssueEntity.class })

public class IssueEntityResource extends AbstractGenericResourceModel<IssueEntity> {
	

	private EmbeddedIssueDraft embedded;
	
	
	public IssueEntityResource() {
		this(new IssueEntity() );
	}
	
	public IssueEntityResource(IssueEntity content) {
		this(content, new IssueDraftResource() );
	}
	
	public IssueEntityResource(IssueEntity content, IssueDraftResource embedded) {
		super(content);
		this.embedded = new EmbeddedIssueDraft( embedded );
	}

	public EmbeddedIssueDraft getEmbedded() {
		return embedded;
	}

	public void setEmbedded(EmbeddedIssueDraft embedded) {
		this.embedded = embedded;
	}


}
