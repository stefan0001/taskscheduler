package de.sep.innovativeoperation.taskscheduler.test.persistence.issuetemplate;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.Test;


public class Test1 {
	@PersistenceContext(unitName = "Test")
	EntityManager em;
	
	@Test
	public void test1() {
		em.isOpen();
		
		
		
	}
}
