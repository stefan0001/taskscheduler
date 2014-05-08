package de.sep.innovativeoperation.test.controller.complex;

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
// @WebAppConfiguration
@ContextConfiguration({ "classpath:applicationContext.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class TestIssueDraftController {

	@InjectMocks
	private IssueDraftController issueDraftController;

	@Mock
	private IssueDraftResourceService issueDraftResourceService;
	@Mock
	private IssueEntityResourceService issueEntityResourceService;
	private MediaType JSON = MediaType.parseMediaType("application/json");
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

	// Set<IssueEntity> issueEntities = new S<IssueEntity>(); ;

	// @Autowired
	// private WebApplicationContext wac;

	// @Autowired
	// IssueDraftResourceAssembler ia;
	// @Autowired
	// IssueDraftsResourceAssembler ias;

	@Before
	public void setupTest() {

		// Process mock annotations
		MockitoAnnotations.initMocks(this);
		
		//Build a MockMvc by registering one or more @Controller's instances 
		//and configuring Spring MVC infrastructure programmatically.
		mockMvc = MockMvcBuilders.standaloneSetup(issueDraftController).build();
	
		
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

		// when(issueDraftService.createIssueDraft(issueDraft)).thenReturn(issueDraft);

		// when(issueDraftService.deleteIssueDraft(issueDraft.getId()));

		// TODO(getIssueEntitiesForIssueDraft)
		// when(issueEntityService.getIssueEntitiesForIssueDraft(issueDraft.getId())).thenReturn(value)

		
		
		
	}

	@Test
	public void testAccessingIssueDraftExpected200() throws Exception {
		
		
		when(issueDraftResourceService.getAll()).thenReturn(
				issueDraftsResource);

		mockMvc.perform(get(url).accept(JSON)).andExpect(status().isOk())
				.andExpect(content().contentType(JSON));

		verify(issueDraftResourceService, times(1)).getAll();
	}

	@Test
	public void testAccessingIssueDraftWithIdOneExpected200() throws Exception {

		when(issueDraftResourceService.getById(1)).thenReturn(
				issueDraftResource);

		mockMvc.perform(get("/issuedraft/1").accept(JSON))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.issueName", is("name")))
				.andExpect(
						jsonPath("$.issueDescription", is("issueDescription"))) // content.embedded.issueDraft.
				.andExpect(jsonPath("$.issueType", is("BUG")));// .content.embedded.issueDraft

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
		// issueDraftResource = new IssueDraftResource(issueDraft);
		// issueDraftsResource = new IssueDraftsResource();
		// issueDraftResourceService.updateIssueDraft(id, issueDraftResource);
		// mockedResponse =
		// "{\"links\":[],\"id\":0,\"issueName\":\"name2\",\"issueDescription\":\"issueDescription2\",\"issueType\":\"BUG\"}";

		when(
				issueDraftResourceService.updateIssueDraft(0,
						issueDraftResourceTemp)).thenReturn(
				alteredIssueDraftResource);

		// TODO .accept(JSON).contentType(JSON)
		// .accept(JSON).contentType(JSON)

		System.out.println(mockedResponse);
		mockMvc.perform(
				put(url + "/0")
						.contentType(JSON)
						.content(
								"{\"links\":[],\"id\":0,\"issueName\":\"name2\",\"issueDescription\":\"issueDescription2\",\"issueType\":\"BUG\"}"))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.issueName", is("name2")))
				.andExpect(
						jsonPath("$.issueDescription", is("issueDescription2"))) // content.embedded.issueDraft.
				.andExpect(jsonPath("$.issueType", is("BUG")));

		// TODO
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
		// issueDraftResourceService.deleteIssueDraft(id);
		// when(issueDraftResourceService.deleteIssueDraft(0)).thenReturn();

		mockMvc.perform(delete(url + "/0").accept(JSON)).andExpect(
				status().isOk());

		verify(issueDraftResourceService, times(1)).deleteById(0);
		// IssueDraft(issueName, issueDescription, issueType);//

	}

	@Test
	public void testGetAllIssueEntitiyForIssueDraftWithIdZEROAndVerifyResponseJsonExpect200()
			throws Exception {
		// return issueDraftResourceService.getIssueEntitiesForIssueDraft(id);

		when(issueDraftResourceService.getIssueEntitiesForIssueDraft(0))
				.thenReturn(issueEntitiesResource);

		mockMvc.perform(get(url + "/0/issueentity").accept(JSON))
				.andExpect(status().isOk()).andDo(print());

		verify(issueDraftResourceService, times(1))
				.getIssueEntitiesForIssueDraft(0);
	}

	@Test
	public void testCreateNewIssueEntitiyForIssueDraftWithIdZEROAndVerifyResponseJsonExpect201()
			throws Exception {

		IssueEntity mockedIssueEntity = new IssueEntity();
		mockedIssueEntity.setId(1);
		mockedIssueEntity.setIssueDraft(issueDraft);
		mockedIssueEntity.setIssueResolution(IssueResolution.DONE);
		mockedIssueEntity.setIssueStatus(IssueStatus.CLOSED);

		IssueEntityResource mockedIssueEntityResource = new IssueEntityResource(
				issueEntity);

		when(
				issueEntityResourceService.createIssueEntity(0,
						issueEntityResource)).thenReturn(
				mockedIssueEntityResource);

		/*
		 * issueEntity.setId(0); issueEntity.setIssueDraft(issueDraft);
		 * issueEntity.setIssueResolution(IssueResolution.DONE);
		 * issueEntity.setIssueStatus(IssueStatus.CLOSED);
		 */
		mockMvc.perform(
				post(url + "/0/issueentity").contentType(JSON)
				// .accept(JSON)
						.content(								"{\"links\":[],\"id\":0,\"issueName\":\"name2\",\"issueDescription\":\"issueDescription2\",\"issueType\":\"BUG\"}"))
//							"{\"links\":[{\"rel\":\"self\",\"href\":\"http://localhost:8080/TaskScheduler/issueentity/1\"}],\"id\":0,\"issueStatus\":\"CLOSED\",\"issueResolution\":\"DONE\",\"embedded\":{\"issueDraft\":{\"links\":[{\"rel\":\"issueentities\",\"href\":\"http://localhost:8080/TaskScheduler/issuedraft/0/issueentity\"},{\"rel\":\"self\",\"href\":\"http://localhost:8080/TaskScheduler/issuedraft/0\"}],\"id\":0,\"issueName\":\"issueName\",\"issueDescription\":\"issueDescription\",\"issueType\":\"BUG\",\"embedded\":{}}}}"))
//								"{\"links\":[],\"id\":0,\"issueName\":\"name2\",\"issueDescription\":\"issueDescription2\",\"issueType\":\"BUG\"}"))

				.andDo(print())
				.andExpect(status().isOk());
		// .andExpect(jsonPath("$.id", is(0)))
		// .andExpect(jsonPath("$.issueStatus", is("CLOSED")))
		// .andExpect(
		// jsonPath("$[0].content.issueResolution",
		// is("CANNOT_REPRODUCE")));
		verify(issueEntityResourceService, times(1)).createIssueEntity(0,
				issueEntityResource);

		/*mockMvc.perform(
				put(url + "/0")
						.contentType(JSON)
						.content(
								"{\"links\":[],\"id\":0,\"issueName\":\"name2\",\"issueDescription\":\"issueDescription2\",\"issueType\":\"BUG\"}"))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.issueName", is("name2")))
				.andExpect(
						jsonPath("$.issueDescription", is("issueDescription2"))) // content.embedded.issueDraft.
				.andExpect(jsonPath("$.issueType", is("BUG")));*/
		
		// "{\"links\":[{\"rel\":\"self\",\"href\":\"http://localhost:8088/TaskScheduler/issueentity\"}],\"content\":[\"id\":\"0\", \"issueStatus\":\"CLOSED\",\"issueResolution\":\"DONE\"]}".getBytes()))
				// .andExpect(content().contentType(MediaType.APPLICATION_JSON))
			
	}

	@Test
	public void testAccessingWrongResourceExpected404() throws Exception {

		this.mockMvc.perform(get("/issuedrafts")).andExpect(
				status().isNotFound());
	}
}

//
// @Test
// public void testJSONIssueDraftExpected200() throws Exception {
// // when(sampleService.saveFrom(any(SignupForm.class)))
// // .thenThrow(new InvalidUserException("For Testing"));
// RequestBuilder requestBuilder = MockMvcRequestBuilders.get(url);
// // this.mockMvc.perform(requestBuilder).
// // andExpect(status().isOk());
//
// this.mockMvc.perform(requestBuilder)
// .andExpect(status().isOk()).andDo(print());
//
// }
//

// .andExpect(content().contentTypeCompatibleWith("application/json;charset=UTF-8")).andDo(MockMvcResultHandlers.print());
// ;
// accept.andExpect(content().type(MediaType.APPLICATION_JSON)).accept(MediaType.APPLICATION_JSON)
// .contentType(MediaType.APPLICATION_JSON)
// }
// mockMvc.perform(requestBuilder).andDo(MockMvcResultHandlers.print());
// //perform(MockMvcRequestBuilders.get(url));
// System.out.println(result.getResponse().getContentAsString());

// String content = result.getResponse().getContentAsString();
// resultActions.andDo(MockMvcResultHandlers.print());
// this.mockMvc.perform(requestBuilder).andExpect(status().isOk());
// @Test
// public void getAccount() throws Exception {
// RequestBuilder requestBuilder = MockMvcRequestBuilders.get(url);
// this.mockMvc.perform(requestBuilder)//.accept(MediaType.parseMediaType("application/json;charset=UTF-8")))
// .andExpect(content().contentType(MediaType.parseMediaType("application/json;charset=UTF-8")))
// .andExpect(status().isOk())
// .andExpect(content().contentType("application/json"))
// .andExpect(jsonPath("$.name").value("Lee"));
// }
//
// .andExpect(jsonPath("$", hasSize(1)));
// .andExpect(content().contentType(MediaType.parseMediaType("application/json;charset=UTF-8")))
// .andExpect(jsonPath("$", hasSize(0)))
// .andExpect(jsonPath("$[0]", containsString("issueStatus")));

// .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE));
// .andExpect(jsonPath("$[0].id", is(1)));
// .andExpect(jsonPath("$[0].description", is("Lorem ipsum")))
// .andExpect(jsonPath("$[0].title", is("Foo")))
// .andExpect(jsonPath("$[1].id", is(2)))
// .andExpect(jsonPath("$[1].description", is("Lorem ipsum")))
// .andExpect(jsonPath("$[1].title", is("Bar")));
//

// andExpect(MockMvcResultMatchers.jsonPath("/", null);
// ().string("issueStatus"));
// andExpect(MockMvcResultMatchers.model().size(11)).
// andExpect(MockMvcResultMatchers.view().name("show_products"));

// MvcResult res =
// MockMvcBuilders.xmlConfigSetup("classpath:test-context.xml").build()
// .perform(MockMvcRequestBuilders.post("/user")
//
// .body(mapper.writeValueAsBytes(userJson)))
// .andExpect(status().isOk())
// .andExpect(content().type(MediaType.APPLICATION_JSON)).accept(MediaType.APPLICATION_JSON)
// .contentType(MediaType.APPLICATION_JSON)
// .andReturn();
// System.out.println(res.getResponse().getContentAsString());