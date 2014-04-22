package de.sep.innovativeoperation.taskscheduler.model;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
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
	
	TimeTask tt = new TimeTask();
	tt.setName("Boden reinigen");
	tt.setFirstFireTime(2014, 3, 23, 9, 30);
	tt.setIntervall(1);
	
	IssueDraft id = new IssueDraft();
	id.setIssueName("Boden reinigen");
	id.setIssueDescription("Bitte den Boden mit Shmierseife reinigen!");
	id.setIssueType(IssueType.TASK);
	
	tt.getIssueDrafts().add(id);
	
	em.merge(tt);
	
	em.getTransaction().commit();
	
	em.close();
	emf.close();
		
	}

}
