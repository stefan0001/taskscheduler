package de.sep.innovativeoperation.test.controller;

import java.util.ArrayList;
import java.util.List;

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
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import de.sep.innovativeoperation.taskscheduler.controller.IssueDraftController;
import de.sep.innovativeoperation.taskscheduler.model.data.IssueDraft;
import de.sep.innovativeoperation.taskscheduler.model.data.IssueType;
import de.sep.innovativeoperation.taskscheduler.service.IssueDraftService;
import de.sep.innovativeoperation.taskscheduler.service.IssueEntityService;

/**
 * 
 * @author Joscha Zander
 * 
 */
@TransactionConfiguration(defaultRollback = true)
@WebAppConfiguration
@ContextConfiguration({ "classpath:applicationContext-test.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class TestIssueDraftController {

	@Mock
	private IssueDraftController issueDraftController;

	@Mock
	private IssueDraftService issueDraftService;

//	@Mock
	// private IssueEntityService issueEntityService;
	private MockMvc mockMvc;
	private String url = "/issuedraft";

	@Autowired
	private WebApplicationContext wac;

	@Before
	public void setup() {

		// Process mock annotations
		MockitoAnnotations.initMocks(this);

		// WeppAppContext Setup
		mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();

	}

	@Test
	public void testAccessingIssueDraftExpected200() throws Exception {
		IssueType issueType = IssueType.BUG;
		IssueDraft issueDraft = new IssueDraft("0", "1", issueType);
		List<IssueDraft> issueDraftList = new ArrayList<IssueDraft>();
		issueDraftList.clear();
		issueDraftList.add(issueDraft);
		when(issueDraftService.getAllIssueDrafts()).thenReturn(issueDraftList);
		
		mockMvc.perform(get(url).accept(MediaType.APPLICATION_JSON)).andExpect(
				status().isOk());
	}

	/**
	 * 
	 * @throws Exception
	 */
	@Test
	public void testAccessingIssueDraftWithIdOneAndVerifyResponseJsonExpected200()
			throws Exception {

		mockMvc.perform(get(url + "/1").accept(MediaType.APPLICATION_JSON))
				// .andDo(print())
				.andExpect(status().isOk())
				.andExpect(jsonPath("$[0].content.id", is(1)))
				.andExpect(jsonPath("$[0].content.issueName", is("t")))
				.andExpect(
						jsonPath("$[0].content.issueDescription",
								is("TestEntity")))
				.andExpect(jsonPath("$[0].content.issueType", is("BUG")));

	}

	/**
	 * 
	 * @throws Exception
	 */
	@Test
	public void testUpdateIssueDraftWithIdZeroAndVerifyResponseJsonExpected201()
			throws Exception {

		mockMvc.perform(
				put(url + "/0").accept(MediaType.APPLICATION_JSON)
						.contentType(MediaType.APPLICATION_JSON)
						.content(
								"{\"links\":[{\"rel\":\"self\",\"href\":\"http://localhost:8080/TaskScheduler/issueentity/0\"}],"
										+ "\"id\":0,\"issueStatus\":\"CLOSED\",\"issueResolution\":\"CANNOT_REPRODUCE\"}"
												.getBytes()))
				// "UTF-8"
				// .body("{\"firstName\":\"Tom\", \"lastName\":\"van Zummeren\"}".getBytes()))
				// .accept(MediaType.APPLICATION_JSON))
				// .andDo(print())
				.andExpect(status().isCreated())
				.andExpect(jsonPath("$[0].content.id", is(1)))
				.andExpect(jsonPath("$[0].content.issueStatus", is("CLOSED")))
				.andExpect(
						jsonPath("$[0].content.issueResolution",
								is("CANNOT_REPRODUCE")));
		// verify(issueDraftService, times(1)).updateIssueDraft(0, new
		// IssueDraft(issueName, issueDescription, issueType);//

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
	public void testDeleteIssueDraftWithIdZEROAndVerifyResponseJsonExpect200()
			throws Exception {

		mockMvc.perform(
				delete(url + "/0").accept(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$[0].content.id", is(1)))
				.andExpect(jsonPath("$[0].content.issueStatus", is("CLOSED")))
				.andExpect(
						jsonPath("$[0].content.issueResolution",
								is("CANNOT_REPRODUCE")))
				.andExpect(status().isOk());

		// verify(issueDraftService, times(1)).updateIssueDraft(0, new
		// IssueDraft(issueName, issueDescription, issueType);//

	}
	
	@Test
	public void testGetAllIssueEntitiyForIssueDraftWithIdZEROAndVerifyResponseJsonExpect200()
			throws Exception {

		mockMvc.perform(
				get(url + "/0/issueentity").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$[0].content.id", is(0)))
				.andExpect(jsonPath("$[0].content.issueStatus", is("CLOSED")))
				.andExpect(
						jsonPath("$[0].content.issueResolution",
								is("CANNOT_REPRODUCE")))
				.andExpect(jsonPath("$[0].content.id", is(1)))
				.andExpect(jsonPath("$[0].content.issueStatus", is("CLOSED")))
				.andExpect(
						jsonPath("$[0].content.issueResolution",
								is("CANNOT_REPRODUCE")));
	}
	
	@Test
	public void testCreateNewIssueEntitiyForIssueDraftWithIdZEROAndVerifyResponseJsonExpect201()
			throws Exception {

		mockMvc.perform(
				post(url + "/0/issueentity").accept(MediaType.APPLICATION_JSON).content(
						"{\"links\":[{\"rel\":\"self\",\"href\":\"http://localhost:8080/TaskScheduler/issueentity/0\"}],"
								+ "\"id\":0,\"issueStatus\":\"CLOSED\",\"issueResolution\":\"CANNOT_REPRODUCE\"}"
										.getBytes()))
//				.andExpect(content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$[0].content.id", is(0)))
				.andExpect(jsonPath("$[0].content.issueStatus", is("CLOSED")))
				.andExpect(
						jsonPath("$[0].content.issueResolution",
								is("CANNOT_REPRODUCE")));
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