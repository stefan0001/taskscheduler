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
	
	
	
	/*
	IssueDraft id1 = new IssueDraft("Kaffemaschine", "Satzbehälter leeren", IssueType.TASK);
	
	Task task1 = new Task("Jeden Montag");
	Task task2 = new Task("Jeden Dienstag");
	Task task3 = new Task("Jedem Mittwoch");
	
	
	id1.getTasks().add(task1);
	id1.getTasks().add(task2);
	id1.getTasks().add(task3);
	
	IssueEntity ent1 = new IssueEntity(IssueStatus.NEW, IssueResolution.UNRESOLVED, id1);
	IssueEntity ent2 = new IssueEntity(IssueStatus.CLOSED, IssueResolution.FIXED, id1);
	
	id1.getIssueEntites().add(ent1);
	id1.getIssueEntites().add(ent2);
	
	em.merge(ent1);
	em.merge(ent2);
	


	TestA a1 = new TestA();
	a1.setName("Lampe");
	TestB b1 = new TestB();
	TestB b2 = new TestB();
	TestB b3 = new TestB();
	
	a1.getMyB().add(b1);
	a1.getMyB().add(b2);
	a1.getMyB().add(b3);
	b1.setMyA(a1);
	b2.setMyA(a1);
	b3.setMyA(a1);
	
	em.merge(a1);
	
	
	TestA a1 = em.find(TestA.class, 12);
	em.remove(a1);
	a1 = em.find(TestA.class, 13);
	em.remove(a1);
	a1 = em.find(TestA.class, 14);
	em.remove(a1);
	*/
	
	TestC c1 = new TestC();
	c1.setName("Task1");
	
	TestC c2 = new TestC();
	c2.setName("Task1");
	
	TestA a1 = new TestA();
	a1.setName("Lampe");
	TestA a2 = new TestA();
	a2.setName("Flasche");
	
	c1.getSetA().add(a1);
	c1.getSetA().add(a2);
	
	c2.getSetA().add(a1);
	c2.getSetA().add(a2);
	
	a1.getSetC().add(c1);
	a1.getSetC().add(c2);
	a2.getSetC().add(c1);
	a2.getSetC().add(c2);
	
	em.merge(c1);
	
	em.getTransaction().commit();
	
	em.close();
	emf.close();
		
	}

}
