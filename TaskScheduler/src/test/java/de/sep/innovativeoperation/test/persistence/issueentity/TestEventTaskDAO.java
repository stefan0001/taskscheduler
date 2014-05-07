//package de.sep.innovativeoperation.test.persistence.issueentity;
//
//import java.util.Iterator;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.test.context.transaction.TransactionConfiguration;
//
//import de.sep.innovativeoperation.taskscheduler.dao.EventTaskDAO;
//import de.sep.innovativeoperation.taskscheduler.model.EventTask;
//import de.sep.innovativeoperation.taskscheduler.model.IssueDraft;
//import de.sep.innovativeoperation.taskscheduler.model.IssueEntity;
//
//@TransactionConfiguration(defaultRollback = false)
//@ContextConfiguration({ "classpath:applicationContext.xml" })
//@RunWith(SpringJUnit4ClassRunner.class)
//public class TestEventTaskDAO {
//	@Autowired
//	EventTaskDAO eventTaskDAO;
//
//	@Test
//	public void testOneEvent() {
//
//		System.out.println("-----------------------------------------");
//		EventTask eventTask = eventTaskDAO.findById(1);
//		
//		System.out.println("EVENTTASKID = " + eventTask.getId());
//		
//		
//		Iterator<IssueDraft> draftIterator = eventTask.getIssueDrafts().iterator();
//		IssueDraft issueDraft = draftIterator.next();
//		System.out.println("ISSUEDRAFTID = " + issueDraft.getId());
//		
//		Iterator<IssueEntity> entityIterator = issueDraft.getIssueEntities().iterator();
//		
//
//		
//
//		IssueEntity issueEntity = entityIterator.next();
//		System.out.println("ISSUEENTITYID = " + issueEntity.getId());
//		System.out.println("-----------------------------------------");
//	}
//	
//
//}
