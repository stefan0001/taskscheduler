package componentTests.controllerTests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ DefaultControllerTest.class, IssueDraftControllerTest.class,
		IssueEntityControllerTest.class })
public class AllControllerTests {

}
