package de.sep.innovativeoperation.test.dao;

import static org.junit.Assert.*;

import java.util.List;

import javax.persistence.PersistenceException;
import javax.validation.ConstraintViolationException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import de.sep.innovativeoperation.taskscheduler.dao.IssueDraftDAO;
import de.sep.innovativeoperation.taskscheduler.model.data.IssueDraft;
import de.sep.innovativeoperation.taskscheduler.model.data.IssueType;
import de.sep.innovativeoperation.taskscheduler.test.MyUtil;

@TransactionConfiguration(defaultRollback = true)
@ContextConfiguration({ "classpath:applicationContext.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class TestIssueDraftDAO {

	@Autowired
	IssueDraftDAO issueDraftDAO;

	private IssueDraft issueDraft;
	private int maxNameLength = 100;
	private int maxDescriptionLength = 500;

	@Before
	public void setUp() throws Exception {
		issueDraft = new IssueDraft("newIssue", "WorkToDo", IssueType.BUG);

	}

	@Test
	public void testSaveAndReadIssueEntityFromIssueDraftDAO() throws Exception {
		// SAVE
		IssueDraft issueDraftSaved = issueDraftDAO.save(issueDraft);

		// FIND BACK
		IssueDraft issueDraftDB = issueDraftDAO.findById(issueDraftSaved
				.getId());

		// CHECK

		// After Saving an Entity got a ID
		assertTrue(issueDraftSaved.getId() > 0);

		// Check ID
		assertTrue(issueDraftSaved.getId() == issueDraftDB.getId());

		// Check IssueStatus
		assertTrue(issueDraftSaved.getIssueDescription() == issueDraftDB
				.getIssueDescription());

		// Check IssueResolution
		assertTrue(issueDraftSaved.getIssueName() == issueDraftDB
				.getIssueName());
	}

	@Test
	public void testSaveAndDeleteIssueEntityFromIssueDraftDAO() {
		// SAVE
		IssueDraft issueDraftSaved = issueDraftDAO.save(issueDraft);

		// CHECK
		// After Saving an Entity got a ID
		// And Save the ID for later Check if Entity with that ID is deleted
		int issueDraftSavedID = issueDraftSaved.getId();
		assertTrue(issueDraftSavedID > 0);

		// DELETE
		issueDraftDAO.remove(issueDraftSaved);
		// CHECK
		assertNull(issueDraftDAO.findById(issueDraftSavedID));

	}

	@Test
	public void testUpdateIssueEntityOnIssueDraftDAO() {
		// SAVE
		IssueDraft issueDraftSaved = issueDraftDAO.save(issueDraft);
		issueDraftSaved.setIssueDescription("test");
		issueDraftSaved = issueDraftDAO.save(issueDraftSaved);
		// CHECK
		// After Saving an Entity got a ID
		// And Save the ID for later Check if Entity with that ID is deleted
		assertTrue(issueDraftSaved.getId() > 0);
		assertTrue(issueDraftSaved.getIssueDescription().equals("test"));

		// CHECK
		assertNotNull(issueDraftDAO.findById(issueDraftSaved.getId()));

	}

	@Test
	public void testFetchAllIssueEntitiesFromIssueDraftDAO() {
		IssueDraft issueDraft2 = new IssueDraft("newIssue2", "WorkToDo2",
				IssueType.BUG);
		
		IssueDraft issueDraft3 = new IssueDraft("newIssue3", "WorkToDo3",
				IssueType.BUG);
		
		if (!issueDraftDAO.fetchAll().isEmpty())
			deleteAllIssuesInIssueDraftDAO();

		assertTrue(issueDraftDAO.fetchAll().isEmpty());

		// SAVE
		IssueDraft issueDraftSaved = issueDraftDAO.save(issueDraft);
		IssueDraft issueDraftSaved2 = issueDraftDAO.save(issueDraft2);
		IssueDraft issueDraftSaved3 = issueDraftDAO.save(issueDraft3);
		
		assertFalse(issueDraftDAO.fetchAll().isEmpty());

		// CHECK
		// After Saving all Entities got an ID
		List<IssueDraft> issueDrafts = issueDraftDAO.fetchAll();

		for (IssueDraft actualIssueDraft : issueDrafts) {
			assertTrue(actualIssueDraft.getId() > 0);
		}

		// Save the ID for later Check if Entity with ID is deleted
		int issueDraftSavedID = issueDraftSaved.getId();
		int issueDraftSavedID2 = issueDraftSaved2.getId();
		int issueDraftSavedID3 = issueDraftSaved3.getId();
		
		issueDraftDAO.remove(issueDraftSaved2);
		assertNull(issueDraftDAO.findById(issueDraftSavedID2));

		issueDrafts = issueDraftDAO.fetchAll();
		assertFalse(issueDrafts.contains(issueDraftSaved2));

		assertTrue(issueDrafts.get(0).getId() == (issueDraftSavedID));
		assertTrue(issueDrafts.get(1).getId() == (issueDraftSavedID3));

	}

	private void deleteAllIssuesInIssueDraftDAO() {
		List<IssueDraft> issueDrafts = issueDraftDAO.fetchAll();
		assertFalse(issueDrafts.isEmpty());
		for (IssueDraft actualIssueDraft : issueDrafts) {
						issueDraftDAO.remove(issueDraftDAO.findById(actualIssueDraft
					.getId()));
						assertNull(issueDraftDAO.findById(actualIssueDraft
					.getId()));
		}

	}

	@Test(expected = IllegalArgumentException.class)
	public void testSaveNull() {
		issueDraftDAO.save(null);
	}

	@Test(expected = ConstraintViolationException.class)
	public void testSaveIssueDraftNullName() {
		issueDraft.setIssueName(null);
		issueDraftDAO.save(issueDraft);
	}

	@Test(expected = ConstraintViolationException.class)
	public void testSaveIssueDraftNullDescription() {
		issueDraft.setIssueDescription(null);
		issueDraftDAO.save(issueDraft);
	}

	@Test(expected = ConstraintViolationException.class)
	public void testSaveIssueDraftNullType() {
		issueDraft.setIssueType(null);
		issueDraftDAO.save(issueDraft);
	}

	@Test
	public void testSaveIssueDraftNullIssueEntities() {
		issueDraft.setIssueEntities(null);
		IssueDraft savedIssueDraft = issueDraftDAO.save(issueDraft);
		assertTrue(savedIssueDraft.getId()>0);
	}

	@Test
	public void testSaveIssueDraftNullTimeTasks() {		
		issueDraft.setTimeTasks(null);
		IssueDraft savedIssueDraft = issueDraftDAO.save(issueDraft);
		assertTrue(savedIssueDraft.getId()>0);
	
	}

	@Test(expected = PersistenceException.class)
	public void testSaveIssueDraft101LetterName() {
		String invalidName = MyUtil.generateRandomStringWithLength(maxNameLength+1);
		assertTrue(invalidName.length() == (maxNameLength+1));
		issueDraft.setIssueName(invalidName);
		IssueDraft savedIssueDraft = issueDraftDAO.save(issueDraft);
		assertTrue(savedIssueDraft.getId()>0);
	}
	@Test(expected = PersistenceException.class)
	public void testSaveIssueDraft501LetterDescription() {
		String invalidDescription = MyUtil.generateRandomStringWithLength(maxDescriptionLength+1);
		assertTrue(invalidDescription.length() == (maxDescriptionLength+1));
		issueDraft.setIssueDescription(invalidDescription);
		issueDraft = issueDraftDAO.save(issueDraft);
		assertTrue(issueDraft.getId()>0);
	}

}
