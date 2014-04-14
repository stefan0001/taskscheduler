/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package de.sep.innovativeoperations.test.rest;

import java.util.List;

import com.jayway.restassured.RestAssured;
import static com.jayway.restassured.path.json.JsonPath.from;
import static com.jayway.restassured.RestAssured.*;
import static org.junit.Assert.assertTrue;

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
	}

	@Test
	public void getRessourcesByPathStaticTestHtmlShouldReturn200()
			throws Exception {
		expect().statusCode(200).when().get("/static/Test.html");
	}
	
	@Test
	public void getIssuetemplatesAndCheckIssueNames()
			throws Exception {
//		get("/issuetemplates").then().statusCode(200).assertThat().body("get(0).issueName", is("TEST"));
		String json = get("/issuetemplates").asString();
		List<String> issues = from(json).get("issueName");
		for (String issue: issues){
			assertTrue(issue.equals("TEST"));
		}
	}
	
	@Test
	public void checkIfRequestedJsonMatchesJsonSchema() throws Exception {
		//TODO
	}
}
