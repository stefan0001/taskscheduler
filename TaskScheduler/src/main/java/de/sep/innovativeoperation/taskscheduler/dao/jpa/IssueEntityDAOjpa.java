package de.sep.innovativeoperation.taskscheduler.dao.jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import de.sep.innovativeoperation.taskscheduler.dao.IssueEntityDAO;
import de.sep.innovativeoperation.taskscheduler.dao.generic.jpa.GenericDAOjpa;
import de.sep.innovativeoperation.taskscheduler.model.data.IssueDraft;
import de.sep.innovativeoperation.taskscheduler.model.data.IssueEntity;
import de.sep.innovativeoperation.taskscheduler.model.data.IssueResolution;
import de.sep.innovativeoperation.taskscheduler.model.data.IssueStatus;

@Repository
public class IssueEntityDAOjpa extends GenericDAOjpa<IssueEntity> implements IssueEntityDAO{

	public List<IssueEntity> filterIssueEntity(IssueEntity issueEntity, IssueDraft issueDraft) {
		
		//CRITERIA BUILDER
		
		//create builder
		CriteriaBuilder cb = em.getCriteriaBuilder();
		//create query
		CriteriaQuery<IssueEntity> cq = cb.createQuery(IssueEntity.class);
		//select root element (returned object)
		Root<IssueEntity> issueEntityRoot = cq.from(IssueEntity.class);
		
		Join<IssueEntity,IssueDraft> issueDrafts = issueEntityRoot.<IssueEntity,IssueDraft>join("issueDraft"); 

		
		//where
		List<Predicate> predicates = new ArrayList<Predicate>();
		
		
		//where issuestatus is
		if(issueEntity.getIssueStatus() != null){
			Predicate issueStatusPredicate = cb.and(cb.equal(issueEntityRoot.<IssueStatus>get("issueStatus"),issueEntity.getIssueStatus()));
			predicates.add(issueStatusPredicate);
		}
		
		//where issueresolution is
		if(issueEntity.getIssueResolution() != null){
			Predicate issueResolutionPredicate = cb.and(cb.equal(issueEntityRoot.<IssueResolution>get("issueResolution"),issueEntity.getIssueResolution()));
			predicates.add(issueResolutionPredicate);
		}
		
		//issueresolution

		//sum of the predicates
		cq.where(predicates.toArray(new Predicate[predicates.size()]) );
		cq.select(issueEntityRoot);

		
		return em.createQuery(cq).getResultList();
	}
}
