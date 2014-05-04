package de.sep.innovativeoperation.taskscheduler.model.resource;

import org.springframework.hateoas.core.Relation;

import de.sep.innovativeoperation.taskscheduler.model.data.IssueEntity;
import de.sep.innovativeoperation.taskscheduler.model.resource.generic.AbstractGenericResourceModel;

//@XmlRootElement
//@XmlSeeAlso({ IssueEntity.class })
@Relation(value="draft", collectionRelation="drafts")
public class IssueEntityResource extends AbstractGenericResourceModel<IssueEntity> {
	private IssueDraftResource draft;
	
	public IssueEntityResource() {
		super(new IssueEntity() );
	}
	
	public IssueEntityResource(IssueEntity content) {
		super(content);
		// TODO Auto-generated constructor stub
	}


}
