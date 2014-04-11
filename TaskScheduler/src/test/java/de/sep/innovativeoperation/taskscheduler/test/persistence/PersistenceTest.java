package de.sep.innovativeoperation.taskscheduler.test.persistence;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

/**
 * Abstract Overclass for all persistence tests
 * @author Stefan
 *
 */

public abstract class PersistenceTest {
	protected static EntityManagerFactory emf;
	protected static EntityManager em;
	
	/**
	 * Create Persistence Manger for Tests
	 */
	@BeforeClass
	public static void setupPersistenceManager() {
		emf = Persistence.createEntityManagerFactory( "Test" );
		em = emf.createEntityManager();
	}
	
	/**
	 * Clean Changes
	 */
	@Before
	@After
	public abstract void clean();
	
	/**
	 * Close Connection to the Persistence Manager
	 */
	@AfterClass
	public static void destoryPersistenceManager() {
		em.close();
		emf.close();
	}

}
