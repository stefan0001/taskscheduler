package componentTests.controllerTests;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import de.sep.innovativeoperation.taskscheduler.controller.DefaultController;

public class DefaultControllerTest {
	String path = "redirect:/static/Test.html";
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		DefaultController a = new DefaultController();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testGetDefault() {
		DefaultController testController = new DefaultController();
		assertEquals(testController.getDefault(),path);
	}

}
