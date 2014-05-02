package de.sep.innovativeoperation.taskscheduler.service.issueentity;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import de.sep.innovativeoperation.taskscheduler.model.data.IssueEntity;
import de.sep.innovativeoperation.taskscheduler.model.resource.IssueEntityResource;
import de.sep.innovativeoperation.taskscheduler.model.resource.generic.AbstractGenericResourceModel;
import de.sep.innovativeoperation.taskscheduler.model.resource.generic.AbstractGenericResourcesModel;
import de.sep.innovativeoperation.taskscheduler.service.assembler.IssueEntitiesResourceAssembler;
import de.sep.innovativeoperation.taskscheduler.service.assembler.IssueEntityResourceAssembler;


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
	
	
	public AbstractGenericResourceModel<IssueEntity> getIssueEntity(int issueEntityId){
		IssueEntity issueEntity = issueEntityDataService.getIssueEntity(issueEntityId);
		return issueEntityResourceAssembler.toResource(issueEntity);
	}
	
	public AbstractGenericResourcesModel< ? extends AbstractGenericResourceModel<IssueEntity> > getAllIssueEntities(){
		List<IssueEntity> issueEntities = issueEntityDataService.getAllIssueEntities();
		return issueEntitiesResourceAssembler.toResource(issueEntityResourceAssembler.toResources(issueEntities));
	}
	
	
	public AbstractGenericResourceModel<IssueEntity> createIssueEntity(int issueDraftId, IssueEntityResource issueEntityResource) {
		IssueEntity issueEntity = issueEntityDataService.createIssueEntity(issueDraftId, issueEntityResource.getContent() );
		
		return issueEntityResourceAssembler.toResource(issueEntity);
	}
	

	public AbstractGenericResourceModel<IssueEntity> updateIssueEntity(int id, IssueEntityResource issueEntityResource) {
		IssueEntity issueEntity = issueEntityDataService.updateIssueEntity(id, issueEntityResource.getContent() );
		
		return issueEntityResourceAssembler.toResource(issueEntity);
	}
	

	public void deleteIssueEntity(int id){
		issueEntityDataService.deleteIssueEntity(id );
	}
	
}
