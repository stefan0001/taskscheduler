package de.sep.innovativeoperation.test.controller.complex;

import static de.sep.innovativeoperation.taskscheduler.config.Config.JSON;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.core.Is.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.mockito.Mockito.*;

import org.springframework.test.web.servlet.result.ContentResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.test.web.servlet.setup.StandaloneMockMvcBuilder;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.util.JSONPObject;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import de.sep.innovativeoperation.taskscheduler.controller.IssueDraftController;
import de.sep.innovativeoperation.taskscheduler.model.data.IssueDraft;
import de.sep.innovativeoperation.taskscheduler.model.data.IssueEntity;
import de.sep.innovativeoperation.taskscheduler.model.data.IssueResolution;
import de.sep.innovativeoperation.taskscheduler.model.data.IssueStatus;
import de.sep.innovativeoperation.taskscheduler.model.data.IssueType;
import de.sep.innovativeoperation.taskscheduler.model.resource.IssueDraftResource;
import de.sep.innovativeoperation.taskscheduler.model.resource.IssueDraftsResource;
import de.sep.innovativeoperation.taskscheduler.model.resource.IssueEntitiesResource;
import de.sep.innovativeoperation.taskscheduler.model.resource.IssueEntityResource;
import de.sep.innovativeoperation.taskscheduler.service.assembler.issuedraft.IssueDraftResourceAssembler;
import de.sep.innovativeoperation.taskscheduler.service.assembler.issuedraft.IssueDraftsResourceAssembler;
//import de.sep.innovativeoperation.taskscheduler.service.IssueDraftService;
//import de.sep.innovativeoperation.taskscheduler.service.IssueEntityService;
import de.sep.innovativeoperation.taskscheduler.service.issuedraft.IssueDraftResourceService;
import de.sep.innovativeoperation.taskscheduler.service.issueentity.IssueEntityResourceService;

/**
 * 
 * @author Joscha Zander
 * 
 */
@TransactionConfiguration(defaultRollback = true)
@WebAppConfiguration
@ContextConfiguration({ "classpath:applicationContext.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class TestIssueDraftController {

	@Autowired
	@InjectMocks
	private IssueDraftController issueDraftController;

	@Mock
	private IssueDraftResourceService issueDraftResourceService;
	@Mock
	private IssueEntityResourceService issueEntityResourceService;

	private MediaType appJSON = MediaType.parseMediaType(JSON);
	private MockMvc mockMvc;
	private String url = "/issuedraft";
	private IssueDraft issueDraft;
	private List<IssueDraft> issueDraftList;
	private List<IssueEntityResource> issueEntityList;
	private IssueDraftResource issueDraftResource;
	private IssueDraftsResource issueDraftsResource;
	private IssueEntitiesResource issueEntitiesResource;
	private IssueEntityResource issueEntityResource;
	private IssueEntity issueEntity;
	private String mockedResponse = "{\"links\":[],\"id\":0,\"issueName\":\"name2\",\"issueDescription\":\"issueDescription2\",\"issueType\":\"BUG\"}";

	@Autowired
	private WebApplicationContext wac;

	@Before
	public void setupTest() {
		if (issueDraftResourceService != null)
			reset(issueDraftResourceService);
		if (issueEntityResourceService != null)
			reset(issueEntityResourceService);
		// TODO TestIssueDraftController JSON setzen!

		// Process mock annotations
		MockitoAnnotations.initMocks(this);

		// Build a MockMvc by registering one or more @Controller's instances
		// and configuring Spring MVC infrastructure programmatically.
		mockMvc = MockMvcBuilders
				.<StandaloneMockMvcBuilder> webAppContextSetup(wac).build();

		issueDraft = new IssueDraft("name", "issueDescription", IssueType.BUG);
		issueDraftList = new LinkedList<IssueDraft>();
		issueDraftList.add(issueDraft);

		issueDraftResource = new IssueDraftResource(issueDraft);
		issueDraftsResource = new IssueDraftsResource();

		issueEntity = new IssueEntity();
		issueEntity.setId(0);
		issueEntity.setIssueDraft(issueDraft);
		issueEntity.setIssueResolution(IssueResolution.DONE);
		issueEntity.setIssueStatus(IssueStatus.CLOSED);
		issueEntityResource = new IssueEntityResource(issueEntity);
		issueEntityList = new LinkedList<IssueEntityResource>();
		issueEntityList.add(issueEntityResource);
		issueEntitiesResource = new IssueEntitiesResource(issueEntityList);
	}

	@Test
	public void testAccessingIssueDraftExpected200() throws Exception {

		when(issueDraftResourceService.getAll())
				.thenReturn(issueDraftsResource);

		this.mockMvc.perform(get(url).accept(appJSON)).andExpect(
				status().isOk());

		verify(issueDraftResourceService, times(1)).getAll();
	}

	@Test
	public void testAccessingIssueDraftWithIdOneExpected200() throws Exception {

		when(issueDraftResourceService.getById(1)).thenReturn(
				issueDraftResource);

		this.mockMvc.perform(get("/issuedraft/1").accept(appJSON))
				.andDo(print()).andExpect(status().isOk());

		verify(issueDraftResourceService, times(1)).getById(1);
	}

	/**
	 * 
	 * @throws Exception
	 */
	@Test
	public void testUpdateIssueDraftWithIdZeroAndVerifyResponseJsonExpected201()
			throws Exception {
		IssueDraft issueDraftTemp = new IssueDraft("name", "issueDescription",
				IssueType.BUG);
		IssueDraftResource issueDraftResourceTemp = new IssueDraftResource(
				issueDraftTemp);
		IssueDraft alteredIssueDraft = new IssueDraft("name2",
				"issueDescription2", IssueType.BUG);
		IssueDraftResource alteredIssueDraftResource = new IssueDraftResource(
				alteredIssueDraft);

		when(
				issueDraftResourceService.updateIssueDraft(0,
						issueDraftResourceTemp)).thenReturn(
				alteredIssueDraftResource);

		System.out.println(mockedResponse);
		this.mockMvc
				.perform(
						put(url + "/0")
								.contentType(appJSON)
								.content(
										"{\"links\":[],\"id\":0,\"issueName\":\"name2\",\"issueDescription\":\"issueDescription2\",\"issueType\":\"BUG\"}"))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.issueName", is("name2")))
				.andExpect(
						jsonPath("$.issueDescription", is("issueDescription2"))) // content.embedded.issueDraft.
				.andExpect(jsonPath("$.issueType", is("BUG")));

		verify(issueDraftResourceService, times(1)).updateIssueDraft(0,
				issueDraftResourceTemp);

	}

	/**
	 * 
	 * @throws Exception
	 * 
	 *             A successful response SHOULD be 200 (OK) if the response
	 *             includes an entity describing the status, 202 (Accepted) if
	 *             the action has not yet been enacted, or 204 (No Content) if
	 *             the action has been enacted but the response does not include
	 *             an entity.
	 */
	@Test
	public void testDeleteIssueDraftWithIdZeroExpect200() throws Exception {

		this.mockMvc.perform(delete(url + "/0").accept(appJSON)).andExpect(
				status().isOk());

		verify(issueDraftResourceService, times(1)).deleteById(0);
	}

	@Test
	public void testGetAllIssueEntitiyForIssueDraftWithIdZEROAndVerifyResponseJsonExpect200()
			throws Exception {

		when(issueDraftResourceService.getIssueEntitiesForIssueDraft(0))
				.thenReturn(issueEntitiesResource);

		this.mockMvc.perform(get(url + "/0/issueentity").accept(appJSON))
				.andExpect(status().isOk()).andDo(print());

		verify(issueDraftResourceService, times(1))
				.getIssueEntitiesForIssueDraft(0);
	}

	@Test
	public void testCreateNewIssueEntitiyForIssueDraftWithIdOneAndVerifyResponseJsonExpect201()
			throws Exception {

		IssueEntity mockedIssueEntity = new IssueEntity();
		mockedIssueEntity.setId(1);
		mockedIssueEntity.setIssueDraft(issueDraft);
		mockedIssueEntity.setIssueResolution(IssueResolution.DONE);
		mockedIssueEntity.setIssueStatus(IssueStatus.CLOSED);

		IssueEntityResource mockedIssueEntityResource = new IssueEntityResource(
				issueEntity);
		IssueEntityResource newIssueEntityResource = issueEntityResource;
		
		when(
				issueEntityResourceService.createIssueEntity(1,
						newIssueEntityResource)).thenReturn(
								newIssueEntityResource);

		this.mockMvc
				.perform(
						post(url + "/1/issueentity")
								.contentType(appJSON)
								.content(
										"{\"links\":[],\"id\":0,\"issueName\":\"name2\",\"issueDescription\":\"issueDescription2\",\"issueType\":\"BUG\"}"

//										"{\"issueStatus\":\"NEW\",\"issueResolution\":\"FIXED\",\"ID\":1,\"embedded\":{\"issueDraft\":"+
//								"{\"issueName\":\"TEST\",\"issueDescription\":\"TEST\",\"issueType\":\"BUG\",\"ID\":1,\"links\":"
//												+"[{\"rel\":\"issueentities\",\"href\":\"\"},"+ //http://localhost:8083/TaskScheduler/issuedraft/1/issueentity
//								"{\"rel\":\"self\",\"href\":\"\"}]}},\"links\":"+	//http://localhost:8083/TaskScheduler/issuedraft/1\
//												"[{\"rel\":\"self\",\"href\":\"\"}]}" //http://localhost:8083/TaskScheduler/issueentity/1\
//								// "{\"links\":[],\"id\":0,\"issueName\":\"name2\",\"issueDescription\":\"issueDescription2\",\"issueType\":\"BUG\"}"
												
								).accept(appJSON)).andDo(print())
				.andExpect(status().isOk());
		// System.out.println("{\"issueStatus\":\"NEW\",\"issueResolution\":\"FIXED\",\"ID\":1,\"embedded\":{\"issueDraft\":{\"issueName\":\"TEST\",\"issueDescription\":\"TEST\",\"issueType\":\"BUG\",\"ID\":1,\"links\":[{\"rel\":\"issueentities\",\"href\":\"http://localhost:8083/TaskScheduler/issuedraft/1/issueentity\"},{\"rel\":\"self\",\"href\":\"http://localhost:8083/TaskScheduler/issuedraft/1\"}]}},\"links\":[{\"rel\":\"self\",\"href\":\"http://localhost:8083/TaskScheduler/issueentity/1\"}]}");
		verify(issueEntityResourceService, times(1)).createIssueEntity(1,
				newIssueEntityResource);
	}

	@Test
	public void testAccessingWrongResourceExpected404() throws Exception {

		this.mockMvc.perform(get("/issuedrafts")).andExpect(
				status().isNotFound());
	}
}
