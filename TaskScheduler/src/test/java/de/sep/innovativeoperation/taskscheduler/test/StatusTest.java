package de.sep.innovativeoperation.taskscheduler.test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.test.web.servlet.setup.StandaloneMockMvcBuilder;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(defaultRollback = true)

//load normal context + text context
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
@WebAppConfiguration
public class StatusTest {





    private MockMvc mockMvc;



    @Autowired
    private WebApplicationContext webApplicationContext;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.<StandaloneMockMvcBuilder>webAppContextSetup(webApplicationContext).build();
    }
    
    @Test
    public void testDefaultController() throws Exception {
    	//redirect
    	mockMvc.perform(get("/")).andExpect(status().is(302));

    }
    


    @Test
    public void testIssueDraftController() throws Exception {
    	
    	mockMvc.perform(get("/issuedraft")).andExpect(status().is(200));
 

    }


}