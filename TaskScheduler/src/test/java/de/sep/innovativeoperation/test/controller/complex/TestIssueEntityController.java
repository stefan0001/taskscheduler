package de.sep.innovativeoperation.test.controller.complex;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import de.sep.innovativeoperation.taskscheduler.controller.IssueEntityController;
import de.sep.innovativeoperation.taskscheduler.model.data.IssueDraft;
import de.sep.innovativeoperation.taskscheduler.model.data.IssueEntity;
import de.sep.innovativeoperation.taskscheduler.model.data.IssueResolution;
import de.sep.innovativeoperation.taskscheduler.model.data.IssueStatus;
import de.sep.innovativeoperation.taskscheduler.model.data.IssueType;
import de.sep.innovativeoperation.taskscheduler.model.resource.IssueDraftResource;
import de.sep.innovativeoperation.taskscheduler.model.resource.IssueDraftsResource;
import de.sep.innovativeoperation.taskscheduler.model.resource.IssueEntitiesResource;
import de.sep.innovativeoperation.taskscheduler.model.resource.IssueEntityResource;
//TODO
//import de.sep.innovativeoperation.taskscheduler.service.assembler.IssueEntityResourceAssembler;
import de.sep.innovativeoperation.taskscheduler.service.issueentity.IssueEntityResourceService;
//import de.sep.innovativeoperation.taskscheduler.model.IssueDraft;
//import de.sep.innovativeoperation.taskscheduler.model.IssueEntity;
//import de.sep.innovativeoperation.taskscheduler.model.IssueResolution;
//import de.sep.innovativeoperation.taskscheduler.model.IssueStatus;
//import de.sep.innovativeoperation.taskscheduler.model.IssueType;
//import de.sep.innovativeoperation.taskscheduler.model.resource.assembler.IssueEntityResourceAssembler;
//import de.sep.innovativeoperation.taskscheduler.service.IssueEntityService;
import static org.mockito.Mockito.*;

//import static org.mockito.Mockito.;

@TransactionConfiguration(defaultRollback = true)
// @WebAppConfiguration
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
@RunWith(MockitoJUnitRunner.class)
public class TestIssueEntityController {

	// SpringJUnit4ClassRunner //MockitoJUnitRunner
	private MockMvc mockMvc;
	private String url = "/issueentity";

	private MediaType JSON = MediaType.parseMediaType("application/json");
	// private MockMvc mockMvc;
	// private String url = "/issuedraft";
	
	private IssueDraft issueDraft;
	
	private List<IssueDraft> issueDraftList;
	private List<IssueEntityResource> issueEntityList;
	private IssueDraftResource issueDraftResource;
	private IssueDraftsResource issueDraftsResource;
	private IssueEntitiesResource issueEntitiesResource;
	private IssueEntityResource issueEntityResource;
	private IssueEntity issueEntity;
	private String mockedResponse = "{\"links\":[],\"id\":0,\"issueName\":\"name2\",\"issueDescription\":\"issueDescription2\",\"issueType\":\"BUG\"}";

	@InjectMocks
	private IssueEntityController issueEntityController;

	@Mock
	private IssueEntityResourceService issueEntityResourceService;

	// @Mock
	// private IssueEntityResourceAssembler issueEntityResourceAssembler;

	// @Autowired
	// private WebApplicationContext wac;

	@Before
	public void setup() {
		// Process mock annotations
		MockitoAnnotations.initMocks(this);
		
		mockMvc = MockMvcBuilders.standaloneSetup(issueEntityController)
				.build();
		// WeppAppContext Setup
		// mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
		// mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();

		issueDraft = new IssueDraft("name", "issueDescription", IssueType.BUG);
		issueDraftList = new LinkedList<IssueDraft>();
		issueDraftList.add(issueDraft);

		// issueDraftResource = ia.toResource(issueDraft);//new
		// IssueDraftResource(issueDraft);
		// issueDraftsResource =
		// ias.toResource(ia.toResources(issueDraftList));//new
		// IssueDraftsResource();
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
	public void shouldStartSpringContext() throws Exception {
		Assert.assertNotNull(issueEntityController);

	}

	@Test
	public void testGetAllIssueEntitiesExpected200() throws Exception {

		when(issueEntityResourceService.getAll()).thenReturn(
				issueEntitiesResource);
		// System.out.println(issueEntityResourceService.getAllIssueEntities().toString());

		mockMvc.perform(get(url).accept(JSON)).andExpect(status().isOk()).andDo(print());
		// // .andDo(print())
		// .andExpect(jsonPath("$[0].content.id", is(1)))
		// .andExpect(jsonPath("$[0].content.issueStatus", is("NEW")))
		// .andExpect(
		// jsonPath("$[0].content.issueResolution", is("FIXED")));

		verify(issueEntityResourceService, times(1)).getAll();//
		// verifyNoMoreInteractions(issueEntityController);
		// verify(issueEntityResourceAssembler,
		// times(1)).toResources(issueEntityService.getAllIssueEntities());//
		// issueEntityService.getAllIssueEntities()
		// verifyNoMoreInteractions(issueEntityResourceAssembler);
		// verify(issueEntityService, times(1)).getAllIssueEntities();//
		// issueEntityService.getAllIssueEntities()
		// verifyNoMoreInteractions(issueEntityService);

	}

	@Test
	public void testGetIssueEntityWithIdZero() throws Exception {
		// return issueEntityResourceService.getIssueEntity(id);

		when(issueEntityResourceService.getById(0)).thenReturn(
				issueEntityResource);
		mockMvc.perform(get(url + "/0").accept(JSON))
				.andExpect(status().isOk()).andDo(print());

		verify(issueEntityResourceService, times(1)).getById(0);
		// verify(issueEntityController, times(1)).getIssueEntity(1);
		// //issueEntityService.getAllIssueEntities()
		// verifyNoMoreInteractions(issueEntityController);
	}

	@Test
	public void testUpdateIssueEntityWithIdZero() throws Exception {
		// return issueEntityResourceService.updateIssueEntity(id,
		// issueEntityResource);
		IssueEntity alteredIssueEntity = new IssueEntity();
		alteredIssueEntity.setId(42);
		alteredIssueEntity.setIssueDraft(issueDraft);
		alteredIssueEntity.setIssueResolution(IssueResolution.CANNOT_REPRODUCE);
		alteredIssueEntity.setIssueStatus(IssueStatus.NEW);
		IssueEntityResource alteredIssueEntityResource = new IssueEntityResource(
				alteredIssueEntity);
		List<IssueEntityResource> alteredIssueEntityList = new LinkedList<IssueEntityResource>();
		alteredIssueEntityList.add(alteredIssueEntityResource);
//		IssueEntitiesResource alteredIssueEntitiesResource = new IssueEntitiesResource(
//				alteredIssueEntityList);

		when(issueEntityResourceService.updateIssueEntity(0,
				alteredIssueEntityResource)).thenReturn(
				alteredIssueEntityResource);
		
		/*setId(0);
		issueEntity.setIssueDraft(issueDraft);
		issueEntity.setIssueResolution(IssueResolution.DONE);
		issueEntity.setIssueStatus(IssueStatus.CLOSED);*/
		mockMvc.perform(
				put(url + "/0")
//				.accept(JSON)
						.contentType(JSON)
						.content("{\"links\":[],\"id\":0,\"issueName\":\"name\",\"issueDescription\":\"issueDescription\",\"issueType\":\"BUG\"}"))
//								"{\"links\":[{\"rel\": \"self\",\"href\": \"http://localhost:8080/TaskScheduler/issueentity/1\"}],\"id\": 42,\"issueStatus\": \"NEW\", \"issueResolution\": \"CANNOT_REPRODUCE\",\"embedded\":{\"issueDraft\":{\"links\":[{\"rel\": \"issueentities\",\"href\": \"http://localhost:8080/TaskScheduler/issuedraft/0/issueentity\"},{\"rel\": \"self\",\"href\": \"http://localhost:8080/TaskScheduler/issuedraft/0\"}],\"id\": 0,\"issueName\": \"issueName\",\"issueDescription\": \"issueDescription\",\"issueType\": \"BUG\",\"embedded\":{}}}}"))
				.andExpect(status().isOk()).andDo(print());
		
		verify(issueEntityResourceService, times(1)).updateIssueEntity(0,alteredIssueEntityResource);
		
		// verify(issueEntityController, times(1)).getIssueEntity(1);
		// //issueEntityService.getAllIssueEntities()
		// verifyNoMoreInteractions(issueEntityController);
	}
	
	@Test
	public void testDeleteIssueEntityExpect200() throws Exception {
		mockMvc.perform(delete(url + "/0").accept(JSON)).andExpect(status().isOk()).andDo(print());

		verify(issueEntityResourceService).deleteById(0);
	}

	@Test
	public void testAccessingWrongResourceExpected404() throws Exception {

		mockMvc.perform(get("/issueentitiess"))
				.andExpect(status().isNotFound());
	}

	@Test
	public void testDeleteAllIssueEntitiesExpect405() throws Exception {
		mockMvc.perform(delete(url)).andExpect(status().isMethodNotAllowed());

	}
}