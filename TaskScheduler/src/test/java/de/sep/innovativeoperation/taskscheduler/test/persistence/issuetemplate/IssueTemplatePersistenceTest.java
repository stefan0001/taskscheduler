package de.sep.innovativeoperation.taskscheduler.test.persistence.issuetemplate;

import org.junit.Assert;

import de.sep.innovativeoperation.taskscheduler.model.IssueTemplate;
import de.sep.innovativeoperation.taskscheduler.model.IssueType;
import de.sep.innovativeoperation.taskscheduler.test.persistence.PersistenceTest;
/**
 * PersistenceTests for IssueEntity
 * @author Stefan
 * 
 */
public class IssueTemplatePersistenceTest extends PersistenceTest{
	
	public void TestWriteAndReading(){
		IssueTemplate issueTemplate = new IssueTemplate("TEST","TEST",IssueType.BUG);
		
		
		//write Object
	    em.getTransaction().begin();
	    em.persist(issueTemplate);
	    em.getTransaction().commit();
	    
	    //get Object
	    IssueTemplate issueTemplate2 = em.find(IssueTemplate.class, issueTemplate.getId());
	    
	    Assert.assertTrue(issueTemplate.getIssueName().equals(issueTemplate2.getIssueName()));
	    

	}

	@Override
	public void clean() {
		em.createNativeQuery("DELETE FROM ISSUETEMPLATE");
	}
}
