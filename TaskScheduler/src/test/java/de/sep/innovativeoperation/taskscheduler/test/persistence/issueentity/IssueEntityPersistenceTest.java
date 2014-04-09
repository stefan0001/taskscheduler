package de.sep.innovativeoperation.taskscheduler.test.persistence.issueentity;

import de.sep.innovativeoperation.taskscheduler.test.persistence.PersistenceTest;

/**
 * PersistenceTests for IssueEntity
 * @author Stefan
 * 
 */
public class IssueEntityPersistenceTest extends PersistenceTest {

	@Override
	public void clean() {
		em.createNativeQuery("DELETE FROM ISSUEENTITY");
	}
	
}
