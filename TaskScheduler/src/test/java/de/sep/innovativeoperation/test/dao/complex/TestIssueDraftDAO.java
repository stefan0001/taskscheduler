package de.sep.innovativeoperation.test.dao.complex;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import de.sep.innovativeoperation.taskscheduler.dao.IssueDraftDAO;
import de.sep.innovativeoperation.taskscheduler.dao.IssueEntityDAO;
import de.sep.innovativeoperation.taskscheduler.exception.validation.ValueIsNotValidException;
import de.sep.innovativeoperation.taskscheduler.exception.validation.ValueIsNullException;
import de.sep.innovativeoperation.taskscheduler.model.data.IssueDraft;
import de.sep.innovativeoperation.taskscheduler.model.data.IssueEntity;
import de.sep.innovativeoperation.taskscheduler.model.data.IssueResolution;
import de.sep.innovativeoperation.taskscheduler.model.data.IssueStatus;
import de.sep.innovativeoperation.taskscheduler.model.data.IssueType;

@TransactionConfiguration(defaultRollback = true)
@ContextConfiguration({ "classpath:applicationContext.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class TestIssueDraftDAO {

	@Autowired
	IssueDraftDAO issueDraftDAO;

	private IssueEntity issueEntity;

	private IssueDraft issueDraft;

	@Before
	public void setUp() throws Exception {
		issueDraft = new IssueDraft("newIssue", "WorkToDo", IssueType.BUG);
		issueEntity = new IssueEntity(IssueStatus.NEW,
				IssueResolution.CANNOT_REPRODUCE, issueDraft);
		// TODO
		// issueEntityDAO.deleteAll();
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
		// IssueEntity issueEntity2 = new IssueEntity(IssueStatus.NEW,
		// IssueResolution.DONE, issueDraft2);
		IssueDraft issueDraft3 = new IssueDraft("newIssue3", "WorkToDo3",
				IssueType.BUG);
		// IssueEntity issueEntity3 = new IssueEntity(IssueStatus.NEW,
		// IssueResolution.DUPLICATE, issueDraft3);

		System.out.println(issueDraftDAO.fetchAll().isEmpty());
		System.out.println(issueDraftDAO.fetchAll().size());

		printIssueDraftDAOElements();

		if (!issueDraftDAO.fetchAll().isEmpty())
			deleteAllIssuesInIssueDraftDAO();

		// System.out.println(issueDraftDAO.fetchAll().isEmpty());
		// System.out.println(issueDraftDAO.fetchAll().size());

		assertTrue(issueDraftDAO.fetchAll().isEmpty());

		// SAVE
		IssueDraft issueDraftSaved = issueDraftDAO.save(issueDraft);
		IssueDraft issueDraftSaved2 = issueDraftDAO.save(issueDraft2);
		IssueDraft issueDraftSaved3 = issueDraftDAO.save(issueDraft3);

		// System.out.println(issueDraftDAO.fetchAll().isEmpty());
		// System.out.println(issueDraftDAO.fetchAll().size());

		// TODO testFetchAllIssueEntitiesFromIssueEntityDAO detchAll is empty?!?
		// printIssueDraftDAOElements();

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

		// CHECK for ID in result of fetchAll()
		// assertTrue(issueDrafts.get(0).getId() == (issueDraftSavedID));
		// assertTrue(issueDrafts.get(0).getIssueEntities()
		// .equals(issueDraftSaved.getIssueEntities()));
		// assertTrue(issueDrafts.get(0).getIssueResolution()
		// .equals(issueDraftSaved.getIssueResolution()));
		// assertTrue(issueDrafts.get(0).getIssueStatus()
		// .equals(issueDraftSaved.getIssueStatus()));
		//
		// assertTrue(issueDrafts.get(1).getId() == (issueDraftSavedID2));
		// assertTrue(issueDrafts.get(1).getIssueEntities()
		// .equals(issueEntitySaved2.getIssueDraft()));
		// assertTrue(issueDrafts.get(1).getIssueResolution()
		// .equals(issueEntitySaved2.getIssueResolution()));
		// assertTrue(issueEnissueDraftstities.get(1).getIssueStatus()
		// .equals(issueEntitySaved2.getIssueStatus()));
		//
		// assertTrue(issueDrafts.get(2).getId() == (issueDraftSavedID3));
		// assertTrue(issueDrafts.get(2).getIssueEntities()
		// .equals(issueEntitySaved3.getIssueDraft()));
		// assertTrue(issueDrafts.get(2).getIssueResolution()
		// .equals(issueEntitySaved3.getIssueResolution()));
		// assertTrue(issueDrafts.get(2).getIssueStatus()
		// .equals(issueEntitySaved3.getIssueStatus()));

		issueDraftDAO.remove(issueDraftSaved2);
		assertNull(issueDraftDAO.findById(issueDraftSavedID2));

		issueDrafts = issueDraftDAO.fetchAll();
		assertFalse(issueDrafts.contains(issueDraftSaved2));
		// TODO equals methode implementieren for contains() etc...
		// assertFalse(issueEntities.contains(issueEntitySavedID2));
		assertTrue(issueDrafts.get(0).getId() == (issueDraftSavedID));
		assertTrue(issueDrafts.get(1).getId() == (issueDraftSavedID3));

	}

	private void printIssueDraftDAOElements() {
		List<IssueDraft> issueDrafts = issueDraftDAO.fetchAll();
		for (IssueDraft actualIssueDraft : issueDrafts) {
			System.out.println(actualIssueDraft.getId() + " "
					+ actualIssueDraft.getIssueName() + " "
					+ actualIssueDraft.getIssueType());
		}

	}

	private void deleteAllIssuesInIssueDraftDAO() {
		List<IssueDraft> issueDrafts = issueDraftDAO.fetchAll();
		for (IssueDraft actualIssueDraft : issueDrafts) {
			System.out.println("DELETE : " + issueEntity.getId() + " "
					+ actualIssueDraft.getIssueName() + " "
					+ actualIssueDraft.getIssueType());

			issueDraftDAO.remove(issueDraftDAO.findById(actualIssueDraft
					.getId()));
		}

	}

	@Test(expected = ValueIsNotValidException.class)
	public void testSaveNull() {
		issueDraftDAO.save(null);
	}

	@Test(expected = ValueIsNullException.class)
	public void testSaveIssueDraftNullName() {
		// SAVE
		// IssueEntity issueEntitySaved = issueEntityDAO.save(null);
		issueDraft.setIssueName(null);
		issueDraftDAO.save(issueDraft);
	}

	@Test(expected = ValueIsNullException.class)
	public void testSaveIssueDraftNullDescription() {
		// SAVE
		// IssueEntity issueEntitySaved = issueEntityDAO.save(null);
		issueDraft.setIssueDescription(null);
		issueDraftDAO.save(issueDraft);
	}

	@Test(expected = ValueIsNullException.class)
	public void testSaveIssueDraftNullType() {
		// SAVE
		// IssueEntity issueEntitySaved = issueEntityDAO.save(null);
		issueDraft.setIssueType(null);
		issueDraftDAO.save(issueDraft);
	}

	@Test(expected = ValueIsNullException.class)
	public void testSaveIssueDraftNullIssueEntities() {
		// SAVE
		// IssueEntity issueEntitySaved = issueEntityDAO.save(null);
		issueDraft.setIssueEntities(null);
		issueDraftDAO.save(issueDraft);
	}

	@Test(expected = ValueIsNullException.class)
	public void testSaveIssueDraftNullTimeTasks() {
		// SAVE
		// IssueEntity issueEntitySaved = issueEntityDAO.save(null);
		issueDraft.setTimeTasks(null);
		issueDraftDAO.save(issueDraft);
	}

	@Test(expected = ValueIsNotValidException.class)
	public void testSaveIssueDraft51LetterName() {
		String invalidName = "bababababababababababababababababababababababababab";
		assertTrue(invalidName.length() == 51);
		issueDraft.setIssueName(invalidName);
		issueDraftDAO.save(issueDraft);
	}
	@Test(expected = ValueIsNotValidException.class)
	public void testSaveIssueDraft101LetterDescription() {
		String invalidDescription = "babababababababababababababababababababababababababababababababababababababababababababababababababab";
		assertTrue(invalidDescription.length() == 101);
		issueDraft.setIssueDescription(invalidDescription);
		issueDraftDAO.save(issueDraft);
	}

}
