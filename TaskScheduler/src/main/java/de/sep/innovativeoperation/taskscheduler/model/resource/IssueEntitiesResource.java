package de.sep.innovativeoperation.taskscheduler.model.resource;


import org.springframework.hateoas.core.Relation;

import de.sep.innovativeoperation.taskscheduler.model.resource.generic.AbstractGenericResourcesModel;

//TODO
@Relation(value="entity", collectionRelation="entities")
public class IssueEntitiesResource extends AbstractGenericResourcesModel<IssueEntityResource>{

	public IssueEntitiesResource() {
		super();
	}

	public IssueEntitiesResource(Iterable<IssueEntityResource> content) {
		super(content);
	}








	
}
