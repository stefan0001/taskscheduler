package de.sep.innovativeoperation.taskscheduler.model;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;



public class Test {

	public static void main(String[] args) {
		
	EntityManagerFactory emf = Persistence.createEntityManagerFactory( "H2Connection" );
	EntityManager em = emf.createEntityManager();
	em.getTransaction().begin();
	
	
	/*
	Task t1 = new Task();
	t1.setName("Kaffemaschine");
	
	IssueDraft id1 = new IssueDraft();
	id1.setIssueType(IssueType.TASK);
	id1.setIssueDescription("Satzbehälter der Kaffeemaschine reinigen");
	id1.setIssueName("Kaffeemaschine: Satzbehälter");
	
	t1.getIssueDrafts().add(id1);
	
	em.merge(t1);
	
	
	Iterator<IssueDraft> h1 = em.find(Task.class, 5).getIssueDrafts().iterator();
	
	if(h1.hasNext()){
		IssueDraft next = h1.next();
		if(next.getId()==3) em.find(Task.class, 5).getIssueDrafts().remove(next);
	}
	*/
	
	em.remove(em.find(IssueDraft.class, 3));
	em.getTransaction().commit();
	
	em.close();
	emf.close();
		
	}

}
