package de.sep.innovativeoperation.taskscheduler.test.persistence.issueentity;

import org.junit.Assert;
import org.junit.Test;

import de.sep.innovativeoperation.taskscheduler.model.IssueEntity;
import de.sep.innovativeoperation.taskscheduler.model.IssueTemplate;
import de.sep.innovativeoperation.taskscheduler.model.IssueType;
import de.sep.innovativeoperation.taskscheduler.test.persistence.PersistenceTest;

/**
 * PersistenceTests for IssueEntity
 * @author Stefan
 * 
 */
public class IssueEntityPersistenceTest extends PersistenceTest {

	public void TestWriteAndReading(){


	}
	
	
	@Override
	public void clean() {
	    em.getTransaction().begin();
	    em.createQuery("DELETE FROM IssueEntity e").executeUpdate();
	    em.getTransaction().commit();
	}
	
}
