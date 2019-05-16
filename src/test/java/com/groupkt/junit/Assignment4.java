package com.groupkt.junit;

import static org.hamcrest.Matchers.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Title;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

@RunWith(SerenityRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Assignment4
{
	String username;
	String password;
	
	@Title("Validate that user is successfully able to login")
	@Test
	public void test1_LoginWithValidCredentials()
	{
		
		System.out.println("Test case no 1 starts here");
		
		username = "ToolsQA";
		password = "TestPassword";
		
		SerenityRest.given().baseUri("http://restapi.demoqa.com/customer/register")
		 .auth()
	     .basic(username,password)
         .contentType("application/json")
         .when()
	     .get("/authentication/CheckForAuthentication")
		 .then()
		 .statusCode(200)
		 .log()
		 .all()
		 .body("FaultId", containsString("OPERATION_SUCCESS"));
		
		System.out.println("Test case 1 ends here");
		
	}
	
	@Title("Validate the response in case of invalid credentials")
	@Test
	public void test2_LoginWithInvalidCredentials()
	{
		System.out.println("Test case no 2 starts here");
		
		username = "ToolsQA"+"123";
		password = "TestPassword" +"123";
		
		SerenityRest.given().baseUri("http://restapi.demoqa.com/customer/register")
		 .auth()
	     .basic(username,password)
         .contentType("application/json")
         .when()
	     .get("/authentication/CheckForAuthentication")
		 .then()
		 .statusCode(401)
		 .log()
		 .all()
		 .body("FaultId", containsString("FAULT_USER_INVALID_USER_PASSWORD"));
		
		System.out.println("Test case 2 ends here");
		
	}
	
	
}
