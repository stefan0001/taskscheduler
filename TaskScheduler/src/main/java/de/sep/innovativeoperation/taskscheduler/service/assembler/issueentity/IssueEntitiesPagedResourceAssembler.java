package de.sep.innovativeoperation.taskscheduler.service.assembler.issueentity;

import java.util.Collection;

import org.springframework.hateoas.PagedResources.PageMetadata;

import de.sep.innovativeoperation.taskscheduler.controller.IssueEntityController;
import de.sep.innovativeoperation.taskscheduler.model.resource.IssueEntitiesPagedResource;
import de.sep.innovativeoperation.taskscheduler.model.resource.IssueEntityResource;
import de.sep.innovativeoperation.taskscheduler.service.assembler.generic.AbstractGenericPagedResourcesAssembler;

public class IssueEntitiesPagedResourceAssembler extends AbstractGenericPagedResourcesAssembler<IssueEntityResource,IssueEntitiesPagedResource> {

	public IssueEntitiesPagedResourceAssembler() {
		super(IssueEntityController.class, IssueEntitiesPagedResource.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	public IssueEntitiesPagedResource toResource( Collection<IssueEntityResource> entity) {
		IssueEntitiesPagedResource resource = new IssueEntitiesPagedResource();
		
		return resource;
	}

	@Override
	public IssueEntitiesPagedResource toResource(Collection<IssueEntityResource> content, PageMetadata metaData) {
		IssueEntitiesPagedResource resource = new IssueEntitiesPagedResource(content, metaData);
		
		return resource;
	}

}
