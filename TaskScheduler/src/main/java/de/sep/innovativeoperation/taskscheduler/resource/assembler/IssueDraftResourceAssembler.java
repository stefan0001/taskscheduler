package de.sep.innovativeoperation.taskscheduler.resource.assembler;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import org.springframework.stereotype.Component;

import de.sep.innovativeoperation.taskscheduler.controller.IssueDraftController;
import de.sep.innovativeoperation.taskscheduler.model.IssueDraft;
import de.sep.innovativeoperation.taskscheduler.resource.AbstractAssembler;
import de.sep.innovativeoperation.taskscheduler.resource.model.IssueDraftResource;

@Component
public class IssueDraftResourceAssembler extends AbstractAssembler<IssueDraft, IssueDraftResource> {
	


	public IssueDraftResourceAssembler(){
		super(IssueDraftController.class, IssueDraftResource.class);
	}

	public IssueDraftResource toResource(IssueDraft issueDraft) {
		IssueDraftResource resource = new IssueDraftResource(issueDraft);
		//self link
		resource.add(linkTo(methodOn(IssueDraftController.class).getIssueEntitiesforIssueDrafts(issueDraft.getId())).withRel("issueentities"));
		//link to issueentities
		resource.add(linkTo(methodOn(IssueDraftController.class).getIssueDraft(issueDraft.getId())).withSelfRel());
		
		return resource;
	}

}
