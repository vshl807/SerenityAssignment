package com.groupkt.junit;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;

import com.groupkt.base.TestBase;
import com.groupkt.cucumber.SerenitySteps;
import static org.hamcrest.Matchers.*;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;

@RunWith(SerenityRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Assignment2 extends TestBase {
	
	@Steps
	
	SerenitySteps steps;
	String countryCode ;
	String stateCode ;
	

	
	@Title("Validate that there are 5 records found.")
	@Test
	public void test1_StateValidationTest()
	{
		
		stateCode = "pradesh";
		countryCode = "IND";
			 
			steps.passGetRequest("/state/search/IND?text="+stateCode)
			.log()
			.all()
			.statusCode(200)
            .body("RestResponse.result",hasSize(5));
		}
	
	@Title("Validate that largest city is Hyderabad Amaravati")
	@Test
	public void test2_LargestCityValidation() {
		
		stateCode = "pradesh";
		countryCode = "IND";
		String largest_city = "Hyderabad Amaravati" ;
			 
		ArrayList<String> list=steps.passGetRequest("/state/search/IND?text="+stateCode)
			.log()
			.all()
			.statusCode(200)
			.assertThat()
			.statusCode(200)
			.extract()
			.path("RestResponse.result.largest_city");
		
		    assertThat(list.contains(largest_city));
		
	}
	
	

}
