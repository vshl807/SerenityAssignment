package com.groupkt.junit;

import static org.hamcrest.Matchers.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import io.restassured.http.ContentType;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Title;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

import com.groupkt.base.Customer;
import com.groupkt.utility.RandomNumber;

import net.serenitybdd.junit.runners.SerenityRunner;

@RunWith(SerenityRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Assignment3Test {
	
	Customer cust=new Customer();
	
	static int randValue = RandomNumber.generateRandomNumber();
	static String firstName = "FName" + randValue ;
	static String lastName = "LName" + randValue;
	static String userName = "UN0312" + randValue;
	static String password = "UN0312" + randValue;
	static String email = "xyz123" + randValue + "@mindtree.com";
	
	@Title("This will validate new user creation")
	@Test
	public void CreateNewUser()
	{
		System.out.println("This is test case 1 starts");
		
		cust.setFirstName(firstName);
		cust.setLastName(lastName);
		cust.setUserName(userName);
		cust.setPassword(password);
		cust.setEmail(email);
		
		SerenityRest.given().baseUri("http://restapi.demoqa.com/customer/register")
		.contentType(ContentType.JSON)
			.log()
			.all()
			.when()
			.body(cust)
			.post()
			.then()
			.log()
			.all()
			.statusCode(201)
			.and()
			.body("SuccessCode", containsString("OPERATION_SUCCESS"));
		
		System.out.println("Test case 1 Ends here");
	}
	
	@Title("This will validate existing user exists")
	@Test
	public void ValidateExistingUser()
	{
		System.out.println("This is test case 2 Starts here");
		
		cust.setFirstName(firstName);
		cust.setLastName(lastName);
		cust.setUserName(userName);
		cust.setPassword(password);
		cust.setEmail(email);
		
		SerenityRest.given().baseUri("http://restapi.demoqa.com/customer/register")
		.contentType(ContentType.JSON)
		.log()
		.all()
		.when()
		.body(cust)
		.post()
		.then()
		.log()
		.all()
		.statusCode(200)
		.and()
		.body("fault", containsString("FAULT_USER_ALREADY_EXISTS"));
		
		System.out.println("Test case 2 Ends here");
		
	}
	

}
