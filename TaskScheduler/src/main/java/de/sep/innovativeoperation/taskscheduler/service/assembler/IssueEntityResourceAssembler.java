package de.sep.innovativeoperation.taskscheduler.service.assembler;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import org.springframework.stereotype.Service;

import de.sep.innovativeoperation.taskscheduler.controller.IssueEntityController;
import de.sep.innovativeoperation.taskscheduler.model.data.IssueEntity;
import de.sep.innovativeoperation.taskscheduler.model.resource.IssueEntityResource;
import de.sep.innovativeoperation.taskscheduler.model.resource.generic.AbstractGenericResourceModel;
import de.sep.innovativeoperation.taskscheduler.service.assembler.generic.AbstractGenericDataResourceAssembler;

@Service
public class IssueEntityResourceAssembler extends AbstractGenericDataResourceAssembler<IssueEntity, IssueEntityResource>{


//	@Override
//	public IssueEntityResource toResource(IssueEntity entity) {
//		IssueEntityResource resource = new IssueEntityResource(entity);
//		//self link
//		resource.add(linkTo(methodOn(IssueEntityController.class).getIssueEntity(entity.getId())).withSelfRel());
//		
//		return resource;
//	}










}
