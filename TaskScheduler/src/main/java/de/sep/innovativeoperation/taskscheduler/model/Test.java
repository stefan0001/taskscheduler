package de.sep.innovativeoperation.taskscheduler.model;


import java.util.ArrayList;
import java.util.HashSet;
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
	
	
	
	
	IssueDraft id1 = new IssueDraft("Berg", "Mittwoch", IssueType.BUG);
	IssueDraft id2 = new IssueDraft("Putze", "Lol", IssueType.BUG);
	IssueDraft id3 = new IssueDraft("Flach", "Dienstag", IssueType.BUG);
	
	Set<IssueDraft> h1 = new HashSet<IssueDraft>();
	
	h1.add(id1);
	h1.add(id2);
	h1.add(id3);
	
	Task task1 = new Task("alterSchwedeHut", h1);
	
	
	id1.getTasks().add(task1);
	id2.getTasks().add(task1);
	id3.getTasks().add(task1);
	
	em.merge(task1);
	
	em.getTransaction().commit();
	em.close();
	emf.close();
		
	}

}
