package de.sep.innovativeoperation.test.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
//import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//import org.springframework.transaction.annotation.Transactional;


//import static org.mockito.Mockito.*;
import de.sep.innovativeoperation.taskscheduler.controller.IssueEntityController;
import de.sep.innovativeoperation.taskscheduler.dao.IssueEntityDAO;

@TransactionConfiguration(defaultRollback = true)
@ContextConfiguration({ "classpath:applicationContext.xml" })
//@Transactional
@RunWith(SpringJUnit4ClassRunner.class)
public class IssueEntityControllerTest {
	
	@Mock
	private IssueEntityDAO issueEntityDAO;
	 
	    @InjectMocks
	    private IssueEntityController issueEntityController;
	 
	    private MockMvc mockMvc;
	 
	    @Before
	    public void setup() {
	 
	        // Process mock annotations
	        MockitoAnnotations.initMocks(this);
	 
	        // Setup Spring test in standalone mode
	        this.mockMvc = MockMvcBuilders.standaloneSetup(issueEntityController).build();
	 
	    }
	    @Test
	    public void testAccessingIssueEntitiesExpected200() throws Exception {
//	        when(sampleService.saveFrom(any(SignupForm.class)))
//	                .thenThrow(new InvalidUserException("For Testing"));
	    	RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/issueentities");
	    	 this.mockMvc.perform(requestBuilder).
             andExpect(MockMvcResultMatchers.status().isOk());
//             andExpect(MockMvcResultMatchers.model().attribute("Products", products)).
//             andExpect(MockMvcResultMatchers.model().size(2)).
//             andExpect(MockMvcResultMatchers.view().name("show_products"));
	    }
	    
	    @Test
	    public void testAccessingIssueEntitiesWrongExpected404() throws Exception {	     
	    	RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/issueentitiess");
	    	 this.mockMvc.perform(requestBuilder).
             andExpect(MockMvcResultMatchers.status().isNotFound());
	    }
	    
	    @Test
	    public void testDeleteAllIssueEntitiesExpect200() throws Exception {	     
	    	RequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/issueentities");
	    	 this.mockMvc.perform(requestBuilder).
             andExpect(MockMvcResultMatchers.status().isOk());
	    }	    
}
