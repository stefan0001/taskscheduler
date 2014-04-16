package de.sep.innovativeoperation.taskscheduler.model;


import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;



public class Test {

	public static void main(String[] args) {
		
	EntityManagerFactory emf = Persistence.createEntityManagerFactory( "H2Connection" );
	EntityManager em = emf.createEntityManager();
	em.getTransaction().begin();
	
	IssueDraft id = new IssueDraft("Moritz", "Hallo Moritz", IssueType.BUG);
	
	em.merge(id);
	
	em.getTransaction().commit();

	em.close();
	emf.close();
		
	}

}
