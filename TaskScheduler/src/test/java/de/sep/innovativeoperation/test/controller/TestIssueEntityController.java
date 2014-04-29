package de.sep.innovativeoperation.test.controller;

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
import de.sep.innovativeoperation.taskscheduler.model.resource.assembler.IssueEntityResourceAssembler;
import de.sep.innovativeoperation.taskscheduler.service.IssueEntityService;
import static org.mockito.Mockito.*;

@TransactionConfiguration(defaultRollback = true)
@WebAppConfiguration
@ContextConfiguration(locations = { "classpath:applicationContext-test.xml" })
@RunWith(MockitoJUnitRunner.class)// SpringJUnit4ClassRunner //MockitoJUnitRunner
public class TestIssueEntityController {

	@Mock
	private IssueEntityController issueEntityController;

	// SERVICES
	@InjectMocks
	private IssueEntityService issueEntityService;

	// ASSEMBLER
	@InjectMocks
	private IssueEntityResourceAssembler issueEntityResourceAssembler;

	private MockMvc mockMvc;
	private String url = "/issueentity";

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
	public void shouldStartSpringContext() {
		System.out.println(MockMvcBuilders.webAppContextSetup(wac).build().toString());
		Assert.assertNotNull(issueEntityController);

	}

	@Test
	public void testAccessingIssueEntitiesExpected200() throws Exception {

		mockMvc.perform(get(url))
				.andExpect(status().isOk())
				// .andDo(print())
				.andExpect(jsonPath("$[0].content.id", is(1)))
				.andExpect(jsonPath("$[0].content.issueStatus", is("NEW")))
				.andExpect(
						jsonPath("$[0].content.issueResolution", is("FIXED")));

		verify(issueEntityController, times(1)).getIssueEntities();// issueEntityService.getAllIssueEntities()
		verifyNoMoreInteractions(issueEntityController);

	}

	@Test
	public void testGetFirstIssueEntityAndCheckID() throws Exception {

		mockMvc.perform(
				get("/issueentity/1").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				// .andDo(print())
				.andExpect(jsonPath("$.content.id", is(1)))
				.andExpect(jsonPath("$.content.issueStatus", is("NEW")))
				.andExpect(jsonPath("$.content.issueResolution", is("FIXED")));

		// verify(issueEntityController, times(1)).getIssueEntity(1);
		// //issueEntityService.getAllIssueEntities()
		// verifyNoMoreInteractions(issueEntityController);
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
