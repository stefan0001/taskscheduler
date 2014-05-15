package de.sep.innovativeoperation.test.controller.complex;

import static de.sep.innovativeoperation.taskscheduler.config.Config.JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.test.web.servlet.setup.StandaloneMockMvcBuilder;
import org.springframework.web.context.WebApplicationContext;

import de.sep.innovativeoperation.taskscheduler.controller.DefaultController;

/**
 * Test the Default Controller with Mockito and SpringTest
 * tests the RequestMapping by Spring
 *  
 * @author Joscha Zander
 *
 */
@TransactionConfiguration(defaultRollback = true)
@WebAppConfiguration
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class TestDefaultController {
	private MockMvc mockMvc;
	private String url = "/";
	private String expectUrl = "/static/gui/index.html";
	 private MediaType appJSON = MediaType.parseMediaType(JSON);


	@Autowired
	private WebApplicationContext wac;
	
	@Autowired
	@InjectMocks
	private DefaultController defaultController;

	@Before
	public void setup() {
		// WeppAppContext Setup
		mockMvc = MockMvcBuilders
				.<StandaloneMockMvcBuilder> webAppContextSetup(wac).build();
		// Process mock annotations
		MockitoAnnotations.initMocks(this);
	}

	/**
	 * Test http exception t
	 * @throws Exception
	 */
	@Test
	public void testPutFrontControllerExpect405() throws Exception {

		mockMvc.perform(put(url).accept(appJSON)).andExpect(
				status().isMethodNotAllowed());
	}

	/**
	 * Test if DefaultController is redirecting to the right url
	 * 
	 * @throws Exception
	 */
	@Test
	public void testAccessingFrontControllerExpect200() throws Exception {
	
		mockMvc.perform(get(url).accept(appJSON))
				.andExpect(status().isFound())
				.andExpect(redirectedUrl(expectUrl)).andDo(print());
			
	}

}

