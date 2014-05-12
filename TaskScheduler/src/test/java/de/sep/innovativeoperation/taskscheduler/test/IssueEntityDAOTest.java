//package de.sep.innovativeoperation.taskscheduler.test;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.test.context.transaction.TransactionConfiguration;
//import org.springframework.transaction.annotation.Transactional;
//
//import de.sep.innovativeoperation.taskscheduler.model.data.IssueDraft;
//import de.sep.innovativeoperation.taskscheduler.model.data.IssueEntity;
//import de.sep.innovativeoperation.taskscheduler.service.issueentity.IssueEntityDataService;
//
//@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
//@RunWith(SpringJUnit4ClassRunner.class)
//@TransactionConfiguration(defaultRollback = true)
//@Transactional
//public class IssueEntityDAOTest {
//	@Autowired
//	IssueEntityDataService issueEntityDataService;
//	
//	@Test
//	public void test(){
//		IssueEntity iefilter = new IssueEntity();
//		IssueDraft idfilter = new IssueDraft();
//		idfilter.setIssueName("blabla");
//		
//		
//		System.out.println("______________________________");
//		System.out.println("issueentitysize: " + issueEntityDataService.filterIssueEntity(iefilter, idfilter).size());
//		System.out.println("______________________________");
//		
//	}
//}
