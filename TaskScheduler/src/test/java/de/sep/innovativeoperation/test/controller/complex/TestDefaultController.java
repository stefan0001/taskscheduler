package de.sep.innovativeoperation.test.controller.complex;

//import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;

//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.when;
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
import org.springframework.web.servlet.View;

import de.sep.innovativeoperation.taskscheduler.controller.DefaultController;

@TransactionConfiguration(defaultRollback = true)
//@WebAppConfiguration
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class TestDefaultController {
	private MockMvc mockMvc;
	private String url = "/";
	private String expectUrl = "/static/Test.html";

//	@Autowired
//	private WebApplicationContext wac;

	@InjectMocks
//	@Autowired
	private DefaultController defaultController;
	
//	@Mock
//    View mockView;
	
//	@Mock
//	private String mockedResponse = "redirect:/static/Test.html";

	@Before
	public void setup() {
		// Process mock annotations
		MockitoAnnotations.initMocks(this);

		// WeppAppContext Setup
//		mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
		mockMvc = MockMvcBuilders.standaloneSetup(defaultController).build();
	}

	@Test
	public void testPutFrontControllerExpect405() throws Exception {
//		String mockedResponse = "redirect:/static/Test.html";
//		String wtf = "wtf";
//        when(defaultController.getDefault()).thenReturn(wtf);

		mockMvc.perform(put(url).accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isMethodNotAllowed());
		// .andExpect(jsonPath("$[0].content.id", is(1)))
		// .accept(MediaType.APPLICATION_JSON))
		// .andExpect(jsonPath("$[0].content.issueStatus", is("NEW")))
		// .andExpect(
		// jsonPath("$[0].content.issueResolution", is("FIXED")));
//		 verify(mockedDefaultController, times(1)).getDefault();//

		System.out.println("TESTENDE testAccessingFrontControllerExpect200");

	}
	@Test
	public void testAccessingFrontControllerExpect200() throws Exception {
//		String mockedResponse = "redirect:/static/Test.html";
//		String wtf = "wtf";
//        when(defaultController.getDefault()).thenReturn(wtf);

		mockMvc.perform(get(url).accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isFound()).andExpect(redirectedUrl(expectUrl))
				.andDo(print());
		// .andExpect(jsonPath("$[0].content.id", is(1)))
		// .accept(MediaType.APPLICATION_JSON))
		// .andExpect(jsonPath("$[0].content.issueStatus", is("NEW")))
		// .andExpect(
		// jsonPath("$[0].content.issueResolution", is("FIXED")));
//		 verify(mockedDefaultController, times(1)).getDefault();//

		System.out.println("TESTENDE testAccessingFrontControllerExpect200");

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
