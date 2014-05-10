package de.sep.innovativeoperation.taskscheduler.model.resource;

import java.util.Collection;

import de.sep.innovativeoperation.taskscheduler.model.resource.generic.AbstractGenericPagedResourcesModel;

public class IssueEntitiesPagedResource extends
		AbstractGenericPagedResourcesModel<IssueEntityResource> {

	public IssueEntitiesPagedResource() {
		super();
	}

	public IssueEntitiesPagedResource(Collection<IssueEntityResource> content, PageMetadata metadata) {
		super(content, metadata);
		// TODO Auto-generated constructor stub
	}

}
