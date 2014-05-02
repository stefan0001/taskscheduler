package de.sep.innovativeoperation.taskscheduler.service.assembler;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import org.springframework.stereotype.Service;

import de.sep.innovativeoperation.taskscheduler.controller.IssueEntityController;
import de.sep.innovativeoperation.taskscheduler.model.data.IssueEntity;
import de.sep.innovativeoperation.taskscheduler.model.resource.IssueEntitiesResource;
import de.sep.innovativeoperation.taskscheduler.model.resource.IssueEntityResource;
import de.sep.innovativeoperation.taskscheduler.model.resource.generic.AbstractGenericResourceModel;
import de.sep.innovativeoperation.taskscheduler.model.resource.generic.AbstractGenericResourcesModel;
import de.sep.innovativeoperation.taskscheduler.service.assembler.generic.AbstractGenericDataResourcesAssembler;


@Service
public class IssueEntitiesResourceAssembler extends AbstractGenericDataResourcesAssembler<IssueEntity, IssueEntityResource, IssueEntitiesResource>{


//	@Override
//	public IssueEntitiesResource toResource(Iterable<IssueEntityResource> entities) {
//		IssueEntitiesResource resource = new IssueEntitiesResource(entities);
//		
//		resource.add(linkTo(methodOn(IssueEntityController.class).getIssueEntities()).withSelfRel());
//
//		return resource;
//	}



}
