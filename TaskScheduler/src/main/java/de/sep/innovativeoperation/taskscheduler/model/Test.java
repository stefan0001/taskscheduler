package de.sep.innovativeoperation.taskscheduler.model;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;



public class Test {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory( "Test" );
		EntityManager em = emf.createEntityManager();


	    em.getTransaction().begin();

	    IssueTemplate issueTemplate = new IssueTemplate("TEST","TEST",IssueType.BUG);
	    IssueEntity issueEntity = new IssueEntity(IssueStatus.NEW, IssueResolution.DONE, issueTemplate);
	    
	    em.persist(issueTemplate);
	    em.persist(issueEntity);


	    em.getTransaction().commit();

		em.close();
		emf.close();
		
	}

}
