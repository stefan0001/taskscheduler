package de.sep.innovativeoperation.taskscheduler.model;


import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;



public class Test {

	public static void main(String[] args) {
		
	EntityManagerFactory emf = Persistence.createEntityManagerFactory( "H2Connection" );
	EntityManager em = emf.createEntityManager();
	em.getTransaction().begin();
	
	
	
	EventTask eventTask = new EventTask();
	eventTask.setName("TestTask");
	
	Event ev = new Event();
	ev.setName("Hallo ich bin ein event!");
	eventTask.setEvent(ev);
	
	
	
	em.merge(eventTask);
	
	em.getTransaction().commit();
	
	em.close();
	emf.close();
		
	}

}
