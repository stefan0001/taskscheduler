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
import de.sep.innovativeoperation.taskscheduler.service.assembler.issuedraft.IssueDraftResourceAssembler;
import de.sep.innovativeoperation.taskscheduler.service.assembler.issuedraft.IssueDraftsResourceAssembler;
import de.sep.innovativeoperation.taskscheduler.service.assembler.issueentity.IssueEntitiesResourceAssembler;
import de.sep.innovativeoperation.taskscheduler.service.assembler.issueentity.IssueEntityResourceAssembler;


@Service
@Transactional
public class IssueDraftResourceService {

	//SERVICES
	@Autowired
	private IssueDraftDataService issueDraftDataService;

	//ASSEMBLER
	
	@Autowired
	private IssueDraftResourceAssembler issueDraftResourceAssembler;
	
	@Autowired
	private IssueDraftsResourceAssembler issueDraftsResourceAssembler;
	
	
	@Autowired
	private IssueEntityResourceAssembler issueEntityResourceAssembler;
	
	@Autowired
	private IssueEntitiesResourceAssembler issueEntitiesResourceAssembler;
	

	public IssueDraftResource createIssueDraft(IssueDraftResource issueDraftResource) {
		IssueDraft issueDraft = issueDraftDataService.createIssueDraft(issueDraftResource.getContent());
		
		return issueDraftResourceAssembler.toResource(issueDraft);
	}


	public IssueDraftResource updateIssueDraft(int id, IssueDraftResource issueDraftResource) {
		IssueDraft issueDraft = issueDraftDataService.updateIssueDraft(id, issueDraftResource.getContent());
		
		return issueDraftResourceAssembler.toResource(issueDraft);
	}
	

	public void deleteIssueDraft(int id) {
		 issueDraftDataService.deleteById(id);

	}


	public IssueDraftsResource getAllIssueDrafts() {
		List<IssueDraft> issueDrafts = issueDraftDataService.getAll();
		List<IssueDraftResource> issueDraftResources = issueDraftResourceAssembler.toResources(issueDrafts);
		return issueDraftsResourceAssembler.toResource(issueDraftResources);
	}


	public IssueDraftResource getIssueDraft(int issueDraftId) {
		IssueDraft issueDraft = issueDraftDataService.getById(issueDraftId);

		return issueDraftResourceAssembler.toResource(issueDraft);
	}

	public IssueEntitiesResource getIssueEntitiesForIssueDraft(int issueDraftId) {
		Set<IssueEntity> issueEntities = issueDraftDataService.getIssueEntitiesForIssueDraft(issueDraftId);
		List<IssueEntityResource> issueEntityResources = issueEntityResourceAssembler.toResources(issueEntities);
		return issueEntitiesResourceAssembler.toResource(issueEntityResources);
	}


}
