package de.sep.innovativeoperation.taskscheduler.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import de.sep.innovativeoperation.taskscheduler.model.data.IssueEntity;
import de.sep.innovativeoperation.taskscheduler.model.resource.IssueEntitiesResource;
import de.sep.innovativeoperation.taskscheduler.model.resource.IssueEntityResource;
import de.sep.innovativeoperation.taskscheduler.service.assembler.IssueEntitiesResourceAssembler;
import de.sep.innovativeoperation.taskscheduler.service.assembler.IssueEntityResourceAssembler;


@Service
@Transactional
public class IssueEntityResourceService {
	//SERVICES
	@Autowired 
	private IssueEntityService issueEntityService;
	
	//ASSEMBLER
	@Autowired 
	private IssueEntityResourceAssembler issueEntityResourceAssembler;
	@Autowired
	private IssueEntitiesResourceAssembler issueEntitiesResourceAssembler;
	
	@Transactional
	public IssueEntityResource getIssueEntity(int issueEntityId){
		IssueEntity issueEntity = issueEntityService.getIssueEntity(issueEntityId);
		return issueEntityResourceAssembler.toResource(issueEntity);
	}
	
	@Transactional
	public IssueEntitiesResource getAllIssueEntities(){
		List<IssueEntity> issueEntities = issueEntityService.getAllIssueEntities();
		return issueEntitiesResourceAssembler.toResource(issueEntityResourceAssembler.toResources(issueEntities));
	}
}
