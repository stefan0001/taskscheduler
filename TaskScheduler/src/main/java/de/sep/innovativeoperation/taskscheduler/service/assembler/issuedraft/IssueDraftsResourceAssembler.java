package de.sep.innovativeoperation.taskscheduler.service.assembler.issuedraft;

import org.springframework.stereotype.Service;

import de.sep.innovativeoperation.taskscheduler.controller.IssueDraftController;
import de.sep.innovativeoperation.taskscheduler.model.resource.IssueDraftResource;
import de.sep.innovativeoperation.taskscheduler.model.resource.IssueDraftsResource;
import de.sep.innovativeoperation.taskscheduler.service.assembler.generic.AbstractGenericDataResourcesAssembler;

@Service
public class IssueDraftsResourceAssembler extends AbstractGenericDataResourcesAssembler<IssueDraftResource,IssueDraftsResource> {

	public IssueDraftsResourceAssembler() {
		super(IssueDraftController.class, IssueDraftsResource.class);
	}

	public IssueDraftsResource toResource(Iterable<IssueDraftResource> entities) {
		IssueDraftsResource resource = new IssueDraftsResource(entities);
		
		return resource;
	}
	
}