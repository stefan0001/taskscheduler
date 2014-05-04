package de.sep.innovativeoperation.taskscheduler.service.assembler.issueentity;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.sep.innovativeoperation.taskscheduler.controller.IssueEntityController;
import de.sep.innovativeoperation.taskscheduler.model.data.IssueDraft;
import de.sep.innovativeoperation.taskscheduler.model.data.IssueEntity;
import de.sep.innovativeoperation.taskscheduler.model.resource.IssueEntityResource;
import de.sep.innovativeoperation.taskscheduler.model.resource.generic.AbstractGenericResourceModel;
import de.sep.innovativeoperation.taskscheduler.service.assembler.generic.AbstractGenericDataResourceAssembler;
import de.sep.innovativeoperation.taskscheduler.service.assembler.issuedraft.IssueDraftResourceAssembler;

@Service
public class IssueEntityResourceAssembler extends AbstractGenericDataResourceAssembler<IssueEntity, IssueEntityResource>{
	@Autowired
	private AbstractGenericDataResourceAssembler<IssueDraft, ? extends AbstractGenericResourceModel<IssueDraft>> issueDraftResourceAssembler;
	
	public IssueEntityResourceAssembler() {
		this(new IssueDraftResourceAssembler() );
	}
	
	public IssueEntityResourceAssembler(AbstractGenericDataResourceAssembler<IssueDraft, ? extends AbstractGenericResourceModel<IssueDraft>> issueDraftResourceAssembler) {
		super(IssueEntityController.class, IssueEntityResource.class);
		
		this.issueDraftResourceAssembler = issueDraftResourceAssembler;
	}


	public IssueEntityResource toResource(IssueEntity entity) {
		IssueEntityResource resource = new IssueEntityResource(entity);
		//self link
		resource.add(linkTo(methodOn(IssueEntityController.class).getIssueEntity(entity.getId())).withSelfRel());
		
		
		//add embedded resource issuedraft
		
		resource.getEmbedded().put("issueDraft", issueDraftResourceAssembler.toResource(entity.getIssueDraft() ) );
		
		return resource;
	}









}
