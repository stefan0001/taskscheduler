package de.sep.innovativeoperation.test.services.issuedraft;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import de.sep.innovativeoperation.taskscheduler.exception.validation.ValueIsNotValidException;
import de.sep.innovativeoperation.taskscheduler.model.data.IssueDraft;
import de.sep.innovativeoperation.taskscheduler.model.data.IssueEntity;
import de.sep.innovativeoperation.taskscheduler.model.data.IssueResolution;
import de.sep.innovativeoperation.taskscheduler.model.data.IssueStatus;
import de.sep.innovativeoperation.taskscheduler.model.data.IssueType;
import de.sep.innovativeoperation.taskscheduler.model.data.TimeTask;
import de.sep.innovativeoperation.taskscheduler.service.issuedraft.IssueDraftDataService;
import de.sep.innovativeoperation.taskscheduler.service.issueentity.IssueEntityDataService;
import de.sep.innovativeoperation.taskscheduler.service.timetask.TimeTaskDataService;
import de.sep.innovativeoperation.taskscheduler.test.MyUtil;

@Transactional
@TransactionConfiguration(defaultRollback = true)
@ContextConfiguration({ "classpath:applicationContext.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class IssueDraftDataServiceTest {

	@Autowired
	IssueDraftDataService issueDraftDataService;

	@Autowired
	IssueEntityDataService issueEntityDataService;

	@Autowired
	TimeTaskDataService timeTaskDataService;

	int maxDescriptionLength = 500;
	int maxNameLength = 100;

	@Before
	public void setUp() throws Exception {

	}

	@Test
	public void testCreateIssueDraft() {
		IssueDraft issueDraft = new IssueDraft("foo", "baa", IssueType.BUG);
		IssueDraft savedIssueDraft = issueDraftDataService
				.createIssueDraft(issueDraft);
		assertTrue(savedIssueDraft.getId() > 0);
		assertNotNull(issueDraftDataService.getById(savedIssueDraft.getId()));
	}

	@Test
	public void testUpdateIssueDraft() {
		IssueDraft issueDraft = new IssueDraft("foo", "baa", IssueType.BUG);
		IssueDraft otherIssueDraft = new IssueDraft("baa", "foo",
				IssueType.IMPROVEMENT);

		IssueDraft savedIssueDraft = issueDraftDataService
				.createIssueDraft(issueDraft);

		IssueDraft updatedIssueDraft = issueDraftDataService.updateIssueDraft(
				savedIssueDraft.getId(), otherIssueDraft);

		assertTrue(savedIssueDraft.getId() > 0);
		assertTrue(updatedIssueDraft.getId() > 0);

		assertTrue(updatedIssueDraft.getIssueDescription().equals(
				otherIssueDraft.getIssueDescription()));
		assertTrue(updatedIssueDraft.getIssueName().equals(
				otherIssueDraft.getIssueName()));
		assertTrue(updatedIssueDraft.getIssueType().equals(
				otherIssueDraft.getIssueType()));

	}

	@Test
	public void testGetIssueEntitiesForIssueDraft() {
		IssueDraft issueDraft = new IssueDraft("foo", "baa", IssueType.BUG);
		IssueDraft savedIssueDraft = issueDraftDataService
				.createIssueDraft(issueDraft);

		assertTrue(savedIssueDraft.getId() > 0);

		IssueEntity newIssueEntity = new IssueEntity(IssueStatus.NEW,
				IssueResolution.UNRESOLVED, issueDraft);
		IssueEntity savedIssueEntity = issueEntityDataService
				.createIssueEntity(savedIssueDraft.getId(), newIssueEntity);

		assertTrue(savedIssueEntity.getId() > 0);

		Set<IssueEntity> issueEntities = issueDraftDataService
				.getIssueEntitiesForIssueDraft(savedIssueDraft.getId());
		assertTrue(savedIssueEntity.getId() > 0);

		assertTrue(issueEntities.contains(savedIssueEntity));

	}

	@Test
	public void testGetTimeTasksForIssueDraft() {
		IssueDraft issueDraft = new IssueDraft("foo", "baa", IssueType.BUG);
		IssueDraft savedIssueDraft = issueDraftDataService
				.createIssueDraft(issueDraft);

		TimeTask newTimeTask = new TimeTask("Müll rausbringen",
				Calendar.getInstance(), Calendar.getInstance(), 0, 3600, false);

		TimeTask savedTimeTask = timeTaskDataService
				.createTimeTask(newTimeTask);

		assertTrue(savedTimeTask.getId() > 0);

		IssueDraft relatedIssueDraft = timeTaskDataService
				.createRelationTimeTaskIssueDraft(savedTimeTask.getId(),
						savedIssueDraft);

		assertNotNull(relatedIssueDraft);

		Set<TimeTask> timeTasks = issueDraftDataService
				.getTimeTasksForIssueDraft(savedIssueDraft.getId());

		assertFalse(timeTasks.isEmpty());
		assertTrue(relatedIssueDraft.getTimeTasks().contains(savedTimeTask));
		assertTrue(timeTasks.contains(savedTimeTask));

	}

	@Test
	public void testFilterIssueDraft() {
		IssueDraft issueDraft = new IssueDraft("foo", "baa", IssueType.BUG);
		IssueDraft savedIssueDraft = issueDraftDataService
				.createIssueDraft(issueDraft);
		assertTrue(savedIssueDraft.getId() > 0);
		IssueDraft secondIssueDraft = new IssueDraft("baa", "foo",
				IssueType.IMPROVEMENT);
		IssueDraft savedSecondIssueDraft = issueDraftDataService
				.createIssueDraft(secondIssueDraft);
		assertTrue(savedSecondIssueDraft.getId() > 0);
		IssueDraft thirdIssueDraft = new IssueDraft("lol", "pöö",
				IssueType.TASK);
		IssueDraft savedThirdIssueDraft = issueDraftDataService
				.createIssueDraft(thirdIssueDraft);
		assertTrue(savedThirdIssueDraft.getId() > 0);
		List<IssueDraft> unfilteredIssueDrafts = new LinkedList<IssueDraft>();

		unfilteredIssueDrafts.add(savedIssueDraft);
		unfilteredIssueDrafts.add(savedSecondIssueDraft);
		unfilteredIssueDrafts.add(savedThirdIssueDraft);

		List<IssueDraft> issueDrafts = issueDraftDataService
				.filterIssueDraft(issueDraft);
		assertTrue(issueDrafts.contains(savedIssueDraft));

		issueDrafts = new LinkedList<IssueDraft>();
		IssueDraft umlauteIssueDraft = new IssueDraft();
		umlauteIssueDraft.setIssueName("ö");
		issueDrafts = issueDraftDataService.filterIssueDraft(umlauteIssueDraft);
		assertTrue(issueDrafts.isEmpty());

		issueDrafts = new LinkedList<IssueDraft>();
		umlauteIssueDraft = new IssueDraft(null, "ö", null);
		issueDrafts = issueDraftDataService.filterIssueDraft(umlauteIssueDraft);
		assertTrue(issueDrafts.isEmpty());

		issueDrafts = new LinkedList<IssueDraft>();
		umlauteIssueDraft = new IssueDraft(null, null, IssueType.BUG);
		issueDrafts = issueDraftDataService.filterIssueDraft(umlauteIssueDraft);
		assertTrue(issueDrafts.contains(savedIssueDraft));

		issueDrafts = new LinkedList<IssueDraft>();
		umlauteIssueDraft = new IssueDraft(null, null, null);
		issueDrafts = issueDraftDataService.filterIssueDraft(umlauteIssueDraft);
		assertTrue(issueDrafts.containsAll(unfilteredIssueDrafts));

		issueDrafts = new LinkedList<IssueDraft>();
		umlauteIssueDraft = new IssueDraft(null, "p", null);
		issueDrafts = issueDraftDataService.filterIssueDraft(umlauteIssueDraft);
		assertTrue(issueDrafts.contains(savedThirdIssueDraft));

		issueDrafts = new LinkedList<IssueDraft>();
		umlauteIssueDraft = new IssueDraft(null, "pö", null);
		issueDrafts = issueDraftDataService.filterIssueDraft(umlauteIssueDraft);
		assertTrue(issueDrafts.contains(savedThirdIssueDraft));

		issueDrafts = new LinkedList<IssueDraft>();
		umlauteIssueDraft = new IssueDraft(null, "pöö", null);
		issueDrafts = issueDraftDataService.filterIssueDraft(umlauteIssueDraft);
		assertTrue(issueDrafts.contains(savedThirdIssueDraft));

	}

	@Test
	public void testFilterRightSizedName() {
		String nameToFilterFor = MyUtil.generateRandomStringWithLength(
				maxNameLength);
		IssueDraft hugeDescriptionIssueDraft = new IssueDraft(nameToFilterFor,
				"hugeDescription", IssueType.BUG);
		IssueDraft savedIssueDraft = issueDraftDataService
				.createIssueDraft(hugeDescriptionIssueDraft);
		List<IssueDraft> issueDrafts = issueDraftDataService
				.filterIssueDraft(new IssueDraft(nameToFilterFor, null, null));
		assertTrue(issueDrafts.contains(savedIssueDraft));

	}

	@Test(expected = ValueIsNotValidException.class)
	public void testFilterOversizedName() {

		IssueDraft umlauteIssueDraft = new IssueDraft(
				MyUtil.generateRandomStringWithLength(maxNameLength + 1), null,
				null);
		issueDraftDataService.filterIssueDraft(umlauteIssueDraft);
	}

	@Test
	public void testFilterRightSizedDescription() {
		IssueDraft hugeDescriptionIssueDraft = new IssueDraft(
				"hugeDescription", MyUtil.generateSingleCharStringOfLength(
						maxDescriptionLength, "B"), IssueType.BUG);
		IssueDraft savedIssueDraft = issueDraftDataService
				.createIssueDraft(hugeDescriptionIssueDraft);
		List<IssueDraft> issueDrafts = issueDraftDataService
				.filterIssueDraft(new IssueDraft(null, MyUtil
						.generateSingleCharStringOfLength(500, "B"), null));
		assertTrue(issueDrafts.contains(savedIssueDraft));
	}

	@Test(expected = ValueIsNotValidException.class)
	public void testFilterOversizedDescription() {

		IssueDraft issueDraft = new IssueDraft(
				null,
				MyUtil.generateRandomStringWithLength(maxDescriptionLength + 1),
				null);
		issueDraftDataService.filterIssueDraft(issueDraft);
	}

}
