package de.sep.innovativeoperation.test.controller;



import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.*;
//import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
//import org.springframework.test.web.servlet.ResultHandler;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;  
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;  
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;  
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;  
//import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;
//import static org.springframework.test.web.servlet.ResultActions.*;
//import static org.springframework.test.web.servlet.MvcResult.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
//import static org.hamcrest.Matchers.*;
import de.sep.innovativeoperation.taskscheduler.controller.IssueDraftController;
//import de.sep.innovativeoperation.taskscheduler.dao.IssueDraftDAO;


@TransactionConfiguration(defaultRollback = true)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })//, classpath:applicationContext-test.xml" })
@RunWith(MockitoJUnitRunner.class)
public class TestIssueDraftController {

	@Mock
	private IssueDraftController issueDraftController;
//	private MockMvcRequestBuilders request;
	private MockMvc mockMvc;
	private String url = "/issuedraft";

	@Before
	public void setup() throws Exception {

		//
		// Mockito.reset(????);
		// Process mock annotations
		MockitoAnnotations.initMocks(this);

		// Setup Spring test in standalone mode
		mockMvc = MockMvcBuilders.standaloneSetup(issueDraftController).build();
		
	}

	@Test
	public void testAccessingIssueDraftExpected200() throws Exception {
		mockMvc.perform(get("/v1/users").accept(MediaType.APPLICATION_JSON))
        .andDo(print());
		
		mockMvc.perform(MockMvcRequestBuilders.get(url))
				// RequestBuilder requestBuilder =
				// MockMvcRequestBuilders.get(url);
				.andExpect(status().isOk())
				.andExpect(
						content().contentType("application/json")) // .contentType(MediaType.APPLICATION_JSON)
				.andDo(MockMvcResultHandlers.print());
	}



	@Test
	public void testJSONIssueDraftExpected200() throws Exception {
		// when(sampleService.saveFrom(any(SignupForm.class)))
		// .thenThrow(new InvalidUserException("For Testing"));
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(url);
		// this.mockMvc.perform(requestBuilder).
		// andExpect(status().isOk());
		
			System.out.println(this.mockMvc.perform(requestBuilder)
					.andExpect(status().isOk()).toString());
		
	}

	@Test
	public void testAccessingIssueDraftWrongExpected404() throws Exception {
		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.get("/issuedrafts");
		this.mockMvc.perform(requestBuilder).andExpect(status().isNotFound());
	}

//	@Test
//	public void testDeleteAllIssueDraftExpect200() throws Exception {
//		RequestBuilder requestBuilder = MockMvcRequestBuilders.delete(url);
//		this.mockMvc.perform(requestBuilder).andExpect(status().isOk());
//	}
}
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