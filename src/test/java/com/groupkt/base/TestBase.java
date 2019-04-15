package com.groupkt.base;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.restassured.RestAssured;
import net.serenitybdd.junit.runners.SerenityRunner;

@RunWith(SerenityRunner.class)
public class TestBase {
	
	@BeforeClass
	public static void init() {
		RestAssured.baseURI="http://services.groupkt.com";
		
	}
	
	@Test
	public void getCountrylist() {
		RestAssured.given()
		.when()
		.get("/state/get/IND/all")
		.then()
		.log()
		.all()
		.statusCode(200);
	}

}
