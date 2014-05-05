package de.sep.innovativeoperation.taskscheduler.service.issuedraft;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import de.sep.innovativeoperation.taskscheduler.model.data.IssueDraft;
import de.sep.innovativeoperation.taskscheduler.model.data.IssueEntity;
import de.sep.innovativeoperation.taskscheduler.model.resource.IssueDraftResource;
import de.sep.innovativeoperation.taskscheduler.model.resource.IssueDraftsResource;
import de.sep.innovativeoperation.taskscheduler.model.resource.IssueEntitiesResource;
import de.sep.innovativeoperation.taskscheduler.model.resource.IssueEntityResource;
import de.sep.innovativeoperation.taskscheduler.service.AbstractGenericResourceService;
import de.sep.innovativeoperation.taskscheduler.service.assembler.issueentity.IssueEntitiesResourceAssembler;
import de.sep.innovativeoperation.taskscheduler.service.assembler.issueentity.IssueEntityResourceAssembler;
import de.sep.innovativeoperation.taskscheduler.service.issueentity.IssueEntityDataService;


@Service
@Transactional
public class IssueDraftResourceService extends AbstractGenericResourceService<IssueDraft,IssueDraftResource, IssueDraftsResource>{

	//SERVICES
	@Autowired
	private IssueDraftDataService issueDraftDataService;
	
	@Autowired 
	private IssueEntityResourceAssembler issueEntityResourceAssembler;
	@Autowired
	private IssueEntitiesResourceAssembler issueEntitiesResourceAssembler;
	
	

	public IssueDraftResource createIssueDraft(IssueDraftResource issueDraftResource) {
		IssueDraft issueDraft = issueDraftDataService.createIssueDraft(issueDraftResource.getContent());
		
		return resourceAssembler.toResource(issueDraft);
	}


	public IssueDraftResource updateIssueDraft(int id, IssueDraftResource issueDraftResource) {
		IssueDraft issueDraft = issueDraftDataService.updateIssueDraft(id, issueDraftResource.getContent());
		
		return resourceAssembler.toResource(issueDraft);
	}
	

	public IssueEntitiesResource getIssueEntitiesForIssueDraft(int issueDraftId) {
		Set<IssueEntity> issueEntities =  issueDraftDataService.getIssueEntitiesForIssueDraft(issueDraftId);
		List<IssueEntityResource> issueEntityResources = issueEntityResourceAssembler.toResources(issueEntities);
		return issueEntitiesResourceAssembler.toResource(issueEntityResources);
	}



}
