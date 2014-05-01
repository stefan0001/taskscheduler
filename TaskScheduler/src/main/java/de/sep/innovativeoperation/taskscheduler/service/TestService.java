package de.sep.innovativeoperation.taskscheduler.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import de.sep.innovativeoperation.taskscheduler.model.data.IssueDraft;

@Transactional
@Service
public class TestService {

	public void test(IssueDraft issueDraft) {
		System.out.println(issueDraft.getIssueEntities().size() );
	}
}
