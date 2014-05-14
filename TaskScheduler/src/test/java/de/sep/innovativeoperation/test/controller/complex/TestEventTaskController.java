package de.sep.innovativeoperation.test.controller.complex;

import static de.sep.innovativeoperation.taskscheduler.config.Config.JSON;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

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
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.test.web.servlet.setup.StandaloneMockMvcBuilder;
import org.springframework.web.context.WebApplicationContext;

import de.sep.innovativeoperation.taskscheduler.controller.EventController;
import de.sep.innovativeoperation.taskscheduler.controller.EventTaskController;
import de.sep.innovativeoperation.taskscheduler.controller.IssueEntityController;
import de.sep.innovativeoperation.taskscheduler.model.resource.EventResource;
import de.sep.innovativeoperation.taskscheduler.model.resource.EventTaskResource;
import de.sep.innovativeoperation.taskscheduler.model.resource.EventTasksResource;
import de.sep.innovativeoperation.taskscheduler.model.resource.EventsResource;
import de.sep.innovativeoperation.taskscheduler.service.event.EventResourceService;
import de.sep.innovativeoperation.taskscheduler.service.eventtask.EventTaskResourceService;
import de.sep.innovativeoperation.taskscheduler.service.issueentity.IssueEntityResourceService;

//@Transactional
@TransactionConfiguration(defaultRollback = true)
@WebAppConfiguration
@ContextConfiguration({ "classpath:applicationContext.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class TestEventTaskController {
	@Autowired
	private WebApplicationContext wac;
	@Autowired
	@InjectMocks
	private EventTaskController eventTaskController;

	@Mock
	private EventTaskResourceService eventTaskResourceService;

	// @Mock
	// private IssueEntityResourceAssembler issueEntityResourceAssembler;
	private MediaType appJSON = MediaType.parseMediaType(JSON);


	private MockMvc mockMvc;
	private String url = "/eventtask";
	private EventTasksResource eventTasksResource;
	private EventTaskResource eventTaskResource;

	@Before
	public void setup() {
		if (eventTaskResourceService != null)
			reset(eventTaskResourceService);
		// Process mock annotations
		MockitoAnnotations.initMocks(this);

		mockMvc = MockMvcBuilders
				.<StandaloneMockMvcBuilder> webAppContextSetup(wac).build();

		eventTasksResource = new EventTasksResource();
		eventTaskResource = new EventTaskResource();
	}

	@Test
	// TODO MOCK eventResourceService
	public void testAccessEventController200() throws Exception {

		when(eventTaskResourceService.getAll()).thenReturn(eventTasksResource);

//		try {
			mockMvc.perform(get(url).accept(appJSON)).andExpect(status().isOk())
					.andDo(print());
//		} catch (Exception e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

		verify(eventTaskResourceService, times(1)).getAll();
	}

	@Test
	// TODO MOCK eventResourceService
	public void testGetEventTaskByIdOne200() throws Exception {

		when(eventTaskResourceService.getById(1)).thenReturn(eventTaskResource);

		mockMvc.perform(get(url + "/1").accept(appJSON))
				.andExpect(status().isOk()).andDo(print());

		verify(eventTaskResourceService, times(1)).getById(1);
	}
	
	
	@Test
	// TODO MOCK eventResourceService
	public void testUpdateEventTaskOne200() throws Exception {
		EventTaskResource updatedEventTaskResource = new EventTaskResource();
		EventTaskResource calledEventTaskResource = eventTaskResource;
		when(eventTaskResourceService.updateEventTask(1, calledEventTaskResource)).thenReturn(
				updatedEventTaskResource);

		mockMvc.perform(
				put(url + "/1").accept(appJSON).contentType(appJSON).content("{}"))
				.andExpect(status().isOk()).andDo(print());
/*content(
						"{\"name\":\"TEST\",\"firstFireTime\":1399888149205,\"nextFireTime\":1399891749205,"+
								   "\"intervall\":3600,\"activated\":false,\"fireCount\":0,\"ID\":1,\"links\":[]}" //{\"rel\":\"self\",\"href\":} //\"http://localhost:8083/TaskScheduler/timetask/1\
)
 * */
		verify(eventTaskResourceService, times(1)).updateEventTask(1, calledEventTaskResource);
	}
	@Test
	// TODO MOCK eventResourceService
	public void testDeleteEventTask204() throws Exception {

		// when(eventResourceService.deleteById(1))
		// .thenReturn(eventResource);

		mockMvc.perform(delete(url + "/1").accept(appJSON))
				.andExpect(status().isOk()).andDo(print());

		verify(eventTaskResourceService, times(1)).deleteById(1);
	}
	

	@Test
	// TODO MOCK eventResourceService
	public void testPOST405() throws Exception {

		mockMvc.perform(post(url).accept(appJSON).content(
				"{\"links\":[],\"content\":[]}"))
				.andExpect(status().isMethodNotAllowed()).andDo(print());

	}
	
}
