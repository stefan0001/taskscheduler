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

import de.sep.innovativeoperation.taskscheduler.controller.TimeTaskController;
import de.sep.innovativeoperation.taskscheduler.model.data.IssueDraft;
import de.sep.innovativeoperation.taskscheduler.model.resource.IssueDraftResource;
import de.sep.innovativeoperation.taskscheduler.model.resource.IssueDraftsResource;
import de.sep.innovativeoperation.taskscheduler.model.resource.TimeTaskResource;
import de.sep.innovativeoperation.taskscheduler.model.resource.TimeTasksResource;
import de.sep.innovativeoperation.taskscheduler.service.timetask.TimeTaskResourceService;

//@Transactional
@TransactionConfiguration(defaultRollback = true)
@WebAppConfiguration
@ContextConfiguration({ "classpath:applicationContext.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class TestTimeTaskController {
	@Autowired
	@InjectMocks
	private TimeTaskController timeTaskController;
	private MediaType appJSON = MediaType.parseMediaType(JSON);
	@Mock
	private TimeTaskResourceService timeTaskResourceService;

	// @Mock
	// private IssueEntityResourceAssembler issueEntityResourceAssembler;

	@Autowired
	private WebApplicationContext wac;

	private MockMvc mockMvc;
	private String url = "/timetask";
	private TimeTasksResource timeTasksResource;
	private TimeTaskResource timeTaskResource;

	@Before
	public void setup() {
		if (timeTaskResourceService != null)
			reset(timeTaskResourceService);
		// Process mock annotations
		MockitoAnnotations.initMocks(this);

		mockMvc = MockMvcBuilders
				.<StandaloneMockMvcBuilder> webAppContextSetup(wac).build();

		timeTasksResource = new TimeTasksResource();
		timeTaskResource = new TimeTaskResource();
	}

	@Test
	// TODO MOCK timeResourceService
	public void testAccess200TimeTaskController() throws Exception {

		when(timeTaskResourceService.getAll()).thenReturn(timeTasksResource);

		mockMvc.perform(get(url).accept(appJSON)).andExpect(status().isOk())
				.andDo(print());

		verify(timeTaskResourceService, times(1)).getAll();
	}

	@Test
	// TODO MOCK timeResourceService
	public void testGetTimeTaskByIdOne200() throws Exception {

		when(timeTaskResourceService.getById(1)).thenReturn(timeTaskResource);

		mockMvc.perform(get(url + "/1").accept(appJSON))
				.andExpect(status().isOk()).andDo(print());

		verify(timeTaskResourceService, times(1)).getById(1);
	}
	@Test
	// TODO MOCK TimeResourceService
	public void testDeleteTimeTask200() throws Exception {

		// when(TimeResourceService.deleteById(1))
		// .thenReturn(TimeResource);

		mockMvc.perform(delete(url + "/1").accept(appJSON))
				.andExpect(status().isOk()).andDo(print());

		verify(timeTaskResourceService, times(1)).deleteById(1);
	}
	@Test
	// TODO MOCK TimeResourceService
	public void testCreateTimeTask200() throws Exception {
		TimeTaskResource givenTimeTaskResource = timeTaskResource;
		TimeTaskResource returnedTimeTaskResource = timeTaskResource;

		when(timeTaskResourceService.createTimeTask(givenTimeTaskResource))
				.thenReturn(returnedTimeTaskResource);

		mockMvc.perform(
				post(url)
						.accept(appJSON)
						.contentType(appJSON)
						.content("{}"
						// "{\"links\":[],\"content\":[]}"

//								"{\"name\":\"TEST\",\"firstFireTime\":1399888149205,\"nextFireTime\":1399891749205,"
//										+ "\"intervall\":3600,\"activated\":false,\"fireCount\":0,\"ID\":1,\"links\":[]}"

						)).andExpect(status().isOk()).andDo(print());

		verify(timeTaskResourceService, times(1)).createTimeTask(
				givenTimeTaskResource);
	}


	@Test
	// TODO MOCK TimeResourceService
	public void testUpdateTimeTaskOne200() throws Exception {

		TimeTaskResource givenTimeTaskResource = timeTaskResource;

		TimeTaskResource updatedTimeTaskResource = new TimeTaskResource();

		when(timeTaskResourceService.updateTimeTask(1, givenTimeTaskResource))
				.thenReturn(updatedTimeTaskResource);

		mockMvc.perform(
				put(url + "/1")
						.accept(appJSON)
						.contentType(appJSON)
						.content("{}"
//
//								"{\"name\":\"TEST\",\"firstFireTime\":1399888149205,\"nextFireTime\":1399891749205,"
//										+ "\"intervall\":3600,\"activated\":false,\"fireCount\":0,\"ID\":1,\"links\":[]}"

						// "{\"links\":[],\"content\":[]}"
						)).andExpect(status().isOk()).andDo(print());

		verify(timeTaskResourceService, times(1)).updateTimeTask(1,
				givenTimeTaskResource);
	}
	@Test
	// TODO MOCK timeResourceService
	public void getAllIssueDraftsForTimeTaskWithIdOne() throws Exception {
		IssueDraftsResource newIssueDraftsResources = new IssueDraftsResource();
		when(timeTaskResourceService.getIssueDraftsforTimeTask(1)).thenReturn(newIssueDraftsResources);

		mockMvc.perform(get(url + "/1/issuedraft").accept(appJSON).contentType(appJSON))
				.andExpect(status().isOk()).andDo(print());

		verify(timeTaskResourceService, times(1)).getIssueDraftsforTimeTask(1);
	}
	
	@Test
	// TODO MOCK timeResourceService
	public void testCreateRelationBetweenTimetaskAndIissuedraft200() throws Exception {
		IssueDraft issueDraft = new IssueDraft();
		IssueDraftResource newIssueDraftResource = new IssueDraftResource(issueDraft);
		

		when(timeTaskResourceService.createRelationTimeTaskIssueDraft(1, newIssueDraftResource)).thenReturn(newIssueDraftResource);

		mockMvc.perform(post(url + "/1/issuedraft/").content("{}").accept(appJSON).contentType(appJSON))
				.andExpect(status().isOk()).andDo(print());

		verify(timeTaskResourceService, times(1)).createRelationTimeTaskIssueDraft(1,newIssueDraftResource);
	}
	@Test
	// TODO MOCK TimeResourceService
	public void testDeleteRelationBetweenTimetaskAndIissuedraft200() throws Exception {

//		 when(TimeResourceService.deleteRelationTimeTaskIssueDraft(1))
//		 .thenReturn(TimeResource);

		mockMvc.perform(delete(url + "/1/issuedraft/1").accept(appJSON))
				.andExpect(status().isOk()).andDo(print());

		verify(timeTaskResourceService, times(1)).deleteRelationTimeTaskIssueDraft(1,1);
	}

}
