package de.sep.innovativeoperation.taskscheduler.resource.assembler;

import org.springframework.stereotype.Component;

import de.sep.innovativeoperation.taskscheduler.controller.IssueEntityController;
import de.sep.innovativeoperation.taskscheduler.model.IssueEntity;
import de.sep.innovativeoperation.taskscheduler.resource.AbstractAssembler;
import de.sep.innovativeoperation.taskscheduler.resource.model.IssueEntityResource;

@Component
public class IssueEntityResourceAssembler extends AbstractAssembler<IssueEntity, IssueEntityResource> {
	


	public IssueEntityResourceAssembler(){
		super(IssueEntityController.class, IssueEntityResource.class);
	}



	public IssueEntityResource toResource(IssueEntity entity) {
		IssueEntityResource resource = new IssueEntityResource(entity);
		
		return resource;
	}

}
