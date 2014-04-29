package componentTests.daoTest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ EventTaskDAOjpaTest.class, GenericDAOjpaTest.class,
		IssueDraftDAOjpaTest.class, IssueEntityDAOjpaTest.class,
		TimeTaskDAOjpaTest.class })
public class AllDAOTests {

}
