package com.groupkt.junit;

import static org.hamcrest.Matchers.*;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.groupkt.base.TestBase;
import com.groupkt.cucumber.SerenitySteps;
import org.junit.runners.MethodSorters;

import io.restassured.RestAssured;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;


@RunWith(SerenityRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Assignment1Test extends TestBase {
	@Steps
	SerenitySteps steps;
	String ISOcode ;
	
	@Title("Validate details with valid country code")
	@Test
	public void test1_CorrectData() {
		System.out.println("Test case no 1 starts here");
		ISOcode="IND";
		steps.passGetRequest("/state/get/" +ISOcode+ "/all")
		.statusCode(200)
		.log()
		.all()
		.body("RestResponse.result",hasSize(36));
		
		System.out.println("Test case no 1 ends here");
	}

	@Title("Validate details with invalid country code")
	@Test
public void test2_InCorrectData() {
		
		System.out.println("Test case no 2 starts here");
		
		ISOcode="Ind";
		steps.passGetRequest("/state/get/" +ISOcode+ "/all")
		.statusCode(200)
		.log()
		.all()
		.body("RestResponse.result",hasSize(0));
		
		System.out.println("Test case no 2 ends here");
	}
}
