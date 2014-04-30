//package de.sep.innovativeoperation.taskscheduler.model.resource.assembler;
//
//import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
//import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import de.sep.innovativeoperation.taskscheduler.controller.IssueEntityController;
//import de.sep.innovativeoperation.taskscheduler.model.data.IssueEntity;
//import de.sep.innovativeoperation.taskscheduler.model.resource.IssueEntityResource;
//
//@Component
//public class IssueEntityResourceAssembler extends AbstractAssembler<IssueEntity, IssueEntityResource> {
//	
//	@Autowired
//	IssueDraftResourceAssembler issueDraftResourceAssembler;
//
//	public IssueEntityResourceAssembler(){
//		super(IssueEntityController.class, IssueEntityResource.class);
//	}
//
//
//
//	public IssueEntityResource toResource(IssueEntity entity) {
//		IssueEntityResource resource = new IssueEntityResource(entity);
//		resource.getEmbedded().add( issueDraftResourceAssembler.toResource(entity.getIssueDraft()) );
//		//self link
//		resource.add(linkTo(methodOn(IssueEntityController.class).getIssueEntity(entity.getId())).withSelfRel());
//		
//		return resource;
//	}
//
//}
