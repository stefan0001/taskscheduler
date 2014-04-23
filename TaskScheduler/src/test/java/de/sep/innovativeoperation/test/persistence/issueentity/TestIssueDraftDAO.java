package de.sep.innovativeoperation.test.persistence.issueentity;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import de.sep.innovativeoperation.taskscheduler.dao.IssueDraftDAO;
import de.sep.innovativeoperation.taskscheduler.model.IssueDraft;

@TransactionConfiguration(defaultRollback = false)
@ContextConfiguration({ "classpath:applicationContext.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class TestIssueDraftDAO {
	@Autowired
	IssueDraftDAO issueDraftDAO;

	@Test
	public void testOneIssueDraft() {

		System.out.println("-----------------------------------------");
		IssueDraft id = issueDraftDAO.findByIdWithRelations(1);
		if(id != null){
			System.out.println(id.getIssueEntites().size());
		}
		System.out.println("-----------------------------------------");
	}
	
	public void testIssueDraftList() {

		System.out.println("-----------------------------------------");
		List<IssueDraft> ids = issueDraftDAO.fetchAllWithRelations();
		
		for(int i = 0; i < ids.size(); i++){
			IssueDraft id = ids.get(i);
			System.out.println(id.getIssueEntites().size() );
		}
		System.out.println("-----------------------------------------");
	}
}
