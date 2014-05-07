package de.sep.innovativeoperation.taskscheduler.model.resource;

import de.sep.innovativeoperation.taskscheduler.model.data.IssueEntity;
import de.sep.innovativeoperation.taskscheduler.model.resource.embedded.EmbeddedIssueDraft;
import de.sep.innovativeoperation.taskscheduler.model.resource.generic.AbstractGenericResourceModel;


//@XmlRootElement
//@XmlSeeAlso({ IssueEntity.class })

public class IssueEntityResource extends AbstractGenericResourceModel<IssueEntity> {
	

	private EmbeddedIssueDraft embedded;
	
	
	/**
	 * Create a new IssueEntityResource with a default IssueEntity and a Default IssueDraftResource
	 */
	public IssueEntityResource() {
		this(new IssueEntity() );
	}
	
	/**
	 * Create a new IssueEntityResource with a given IssueEntity as Content
	 * @param content  including IssueEntity
	 */
	public IssueEntityResource(IssueEntity content) {
		this(content, new IssueDraftResource() );
	}
	
	/**
	 * Create a new IssueEntityResource with a given IssueEntity as content and a IssueDraftResource as embedded Resource
	 * @param content
	 * @param embedded
	 */
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
