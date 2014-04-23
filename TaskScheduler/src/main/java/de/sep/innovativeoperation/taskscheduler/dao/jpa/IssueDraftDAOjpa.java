package de.sep.innovativeoperation.taskscheduler.dao.jpa;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import de.sep.innovativeoperation.taskscheduler.dao.IssueDraftDAO;
import de.sep.innovativeoperation.taskscheduler.dao.generic.jpa.GenericDAOjpa;
import de.sep.innovativeoperation.taskscheduler.model.IssueDraft;

@Repository
@Transactional
public class IssueDraftDAOjpa extends GenericDAOjpa<IssueDraft> implements IssueDraftDAO {
	

	@Transactional
	public IssueDraft findByIdWithRelations(int id) {
		// CREATE QUERY AND EXECUTE THE QUERY
		CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
		CriteriaQuery<IssueDraft> query = criteriaBuilder.createQuery(IssueDraft.class);
		Root<IssueDraft> root = query.from(IssueDraft.class);
		
		//Fetch Entities and join them
		root.fetch("issueEntites", JoinType.LEFT);
		//Fetch EventTasks and join them
		root.fetch("eventTasks", JoinType.LEFT);
		//Fetch EventTasks and join them
		root.fetch("timeTasks", JoinType.LEFT);
		
		//Search for id
		query.where(criteriaBuilder.equal(root.get("id"), id));
		
		
		TypedQuery<IssueDraft> result = em.createQuery(query);
		
		
		if(result.getResultList().size() > 0 ){
			return result.getResultList().get(0);
		}
		//no result was found return null
		return null;
	}
	
	@Transactional
	public List<IssueDraft> fetchAllWithRelations(){

		CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
		CriteriaQuery<IssueDraft> query = criteriaBuilder.createQuery(IssueDraft.class);
		Root<IssueDraft> root = query.from(IssueDraft.class);
		//Fetch Entities and join them
		root.fetch("issueEntites", JoinType.LEFT);
		//Fetch EventTasks and join them
		root.fetch("eventTasks", JoinType.LEFT);
		//Fetch EventTasks and join them
		root.fetch("timeTasks", JoinType.LEFT);
		
				
		TypedQuery<IssueDraft> result = em.createQuery(query);
		
		return result.getResultList();
		
	}

	
	
	
	

}
