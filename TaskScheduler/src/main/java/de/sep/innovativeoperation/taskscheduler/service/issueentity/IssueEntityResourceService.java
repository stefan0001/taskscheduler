package de.sep.innovativeoperation.taskscheduler.service.issueentity;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import de.sep.innovativeoperation.taskscheduler.model.data.IssueEntity;
import de.sep.innovativeoperation.taskscheduler.model.resource.IssueEntitiesResource;
import de.sep.innovativeoperation.taskscheduler.model.resource.IssueEntityResource;
import de.sep.innovativeoperation.taskscheduler.service.assembler.issueentity.IssueEntitiesResourceAssembler;
import de.sep.innovativeoperation.taskscheduler.service.assembler.issueentity.IssueEntityResourceAssembler;


@Service
@Transactional
public class IssueEntityResourceService {
	//SERVICES
	@Autowired 
	private IssueEntityDataService issueEntityDataService;
	
	//ASSEMBLER
	@Autowired 
	private IssueEntityResourceAssembler issueEntityResourceAssembler;
	@Autowired
	private IssueEntitiesResourceAssembler issueEntitiesResourceAssembler;
	
	
	public IssueEntityResource getIssueEntity(int issueEntityId){
		IssueEntity issueEntity = issueEntityDataService.getIssueEntity(issueEntityId);
		return issueEntityResourceAssembler.toResource(issueEntity);
	}
	
	public IssueEntitiesResource getAllIssueEntities(){
		List<IssueEntity> issueEntities = issueEntityDataService.getAllIssueEntities();
		return issueEntitiesResourceAssembler.toResource(issueEntityResourceAssembler.toResources(issueEntities));
	}
	
	
	public IssueEntityResource createIssueEntity(int issueDraftId, IssueEntityResource issueEntityResource) {
		IssueEntity issueEntity = issueEntityDataService.createIssueEntity(issueDraftId, issueEntityResource.getContent() );
		
		return issueEntityResourceAssembler.toResource(issueEntity);
	}
	

	public IssueEntityResource updateIssueEntity(int id, IssueEntityResource issueEntityResource) {
		IssueEntity issueEntity = issueEntityDataService.updateIssueEntity(id, issueEntityResource.getContent() );
		
		return issueEntityResourceAssembler.toResource(issueEntity);
	}
	

	public void deleteIssueEntity(int id){
		issueEntityDataService.deleteIssueEntity(id );
	}
	
}
