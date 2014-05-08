//package de.sep.innovativeoperation.test.controller;
//
//import static org.junit.Assert.*;
//
//import org.junit.Before;
//import org.junit.BeforeClass;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.test.context.transaction.TransactionConfiguration;
//import org.springframework.transaction.annotation.Transactional;
//
//import de.sep.innovativeoperation.taskscheduler.controller.DefaultController;
//
////@TransactionConfiguration(defaultRollback = true)
//@ContextConfiguration({ "classpath:applicationContext.xml" })
//@RunWith(SpringJUnit4ClassRunner.class)
////@Transactional
//public class DefaultControllerTest {
//
//	@Autowired
//	DefaultController defaultController;
//	
//	private final String redirectUrl = "redirect:/static/Test.html";
////	@BeforeClass
////	public static void setUpBeforeClass() throws Exception {
////	}
////
////	@Before
////	public void setUp() throws Exception {
////	}
//
//	@Test
//	public void testGetDefault() {
//		
//		assertTrue(defaultController.getDefault().equals(redirectUrl));
//	}
//
//}
