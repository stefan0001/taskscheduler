//package de.sep.innovativeoperation.test.persistence.issuedraft;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.test.context.transaction.TransactionConfiguration;
//import org.springframework.transaction.annotation.Transactional;
//
//import de.sep.innovativeoperation.taskscheduler.dao.IssueDraftDAO;
//import de.sep.innovativeoperation.taskscheduler.model.IssueDraft;
//import de.sep.innovativeoperation.taskscheduler.model.IssueType;
//
//@TransactionConfiguration(defaultRollback = false)
//@ContextConfiguration({ "classpath:applicationContext.xml" })
//@RunWith(SpringJUnit4ClassRunner.class)
//public class TestDraftDAO {
//	@Autowired
//	IssueDraftDAO issueDraftDAO;
//	
//	@Test
//	@Transactional
//	public void test(){
//		IssueDraft issueDraft = new IssueDraft("TEST","TEST",IssueType.BUG);
//		issueDraft = issueDraftDAO.save(issueDraft);
//		
//		System.out.println(issueDraft.getId() );
//	}
//}
