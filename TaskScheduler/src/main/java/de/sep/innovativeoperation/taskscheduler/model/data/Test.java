package de.sep.innovativeoperation.taskscheduler.model.data;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;



public class Test {

	public static void main(String[] args) {
		
	EntityManagerFactory emf = Persistence.createEntityManagerFactory( "H2Connection" );
	EntityManager em = emf.createEntityManager();
	em.getTransaction().begin();
	
	
	IssueDraft id = new IssueDraft();
	id.setIssueDescription("TestEntity");
	id.setIssueName("t");
	id.setIssueType(IssueType.BUG);
	
	IssueEntity it = new IssueEntity();
	it.setIssueStatus(IssueStatus.NEW);
	it.setIssueResolution(IssueResolution.FIXED);
	it.setIssueDraft(id);
	
	em.merge(it);
	/*
	
	EventTask eventTask = new EventTask();
	eventTask.setName("TestTask");
	
	Event ev = new Event();
	ev.setName("Hallo ich bin ein event!");
	eventTask.setEvent(ev);
	
	em.merge(eventTask);
	*/
	em.getTransaction().commit();
	
	em.close();
	emf.close();
		
	}

}
