/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package de.sep.innovativeoperations.test.rest;

import com.jayway.restassured.RestAssured;
import static com.jayway.restassured.RestAssured.expect;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

/**
 * 
 * @author yoshi
 */
@TransactionConfiguration(defaultRollback = false)
@ContextConfiguration({ "classpath:applicationContext.xml" })
@Transactional
@RunWith(SpringJUnit4ClassRunner.class)
public class TestRest {
	// RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();

	@BeforeClass
	public static void setupConnection() {
		RestAssured.baseURI = "http://localhost";
		RestAssured.port = 8088;
		RestAssured.basePath = "/TaskScheduler";
	}

	/*
	 * @Before public void setup() throws Exception {
	 * requestSpecBuilder.setContentType(ContentType.JSON).addHeader("Accept",
	 * ContentType.JSON.getAcceptHeader()); }
	 */
	@Test
	public void getRessourcesByPathIssuetemplatesShouldReturn200()
			throws Exception {
		expect().statusCode(200).when().get("/issuetemplates");

		// get("/issueentities").then().assertThat().statusCode(200);
	}

	@Test
	public void getRessourcesByPathStaticTestHtmlShouldReturn200()
			throws Exception {
		expect().statusCode(200).when().get("/static/Test.html");
	}
	
	@Test
	public void getIssuetemplatesAndCompareWithJSON()
			throws Exception {
		expect().statusCode(200).when().get("/static/Test.html");
	}
}
