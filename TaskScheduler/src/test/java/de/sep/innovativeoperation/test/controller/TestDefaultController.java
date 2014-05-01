package de.sep.innovativeoperation.test.controller;

import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.Before;
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
import org.springframework.test.web.servlet.result.HeaderResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import de.sep.innovativeoperation.taskscheduler.controller.DefaultController;

//@TransactionConfiguration(defaultRollback = true)
@WebAppConfiguration
@ContextConfiguration(locations = { "classpath:/applicationContext-test.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class TestDefaultController {
	private MockMvc mockMvc;
	private String url = "/";
	private String redirectUrl = "/static/Test.html";

	@Autowired
	private WebApplicationContext wac;

	@Mock
	private DefaultController defaultController;

	@Before
	public void setup() {
		// Process mock annotations
		MockitoAnnotations.initMocks(this);

		// WeppAppContext Setup
		mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
	}

	@Test
	public void testAccessingFrontControllerExpect302() throws Exception {

		mockMvc.perform(get(url)).andExpect(content().contentType("text/xml; charset=UTF-8")).andExpect(status().isFound()).andDo(print())
				.andExpect(redirectedUrl(redirectUrl))
				;
		// .andExpect(jsonPath("$[0].content.id", is(1)))
		// .accept(MediaType.APPLICATION_JSON))
		// .andExpect(jsonPath("$[0].content.issueStatus", is("NEW")))
		// .andExpect(
		// jsonPath("$[0].content.issueResolution", is("FIXED")));
		// verify(defaultController, times(1)).getDefault();//

		System.out.println("TESTENDE");

	}

	// public String getDefault() {
	// return "redirect:/static/Test.html";
}
// verify(issueEntityController, times(1)).getIssueEntities();//
// verifyNoMoreInteractions(issueEntityController);
// verify(issueEntityResourceAssembler,
// times(1)).toResources(issueEntityService.getAllIssueEntities());//
// issueEntityService.getAllIssueEntities()
// verifyNoMoreInteractions(issueEntityResourceAssembler);
// verify(issueEntityService, times(1)).getAllIssueEntities();//
// issueEntityService.getAllIssueEntities()
// verifyNoMoreInteractions(issueEntityService);
