package com.groupkt.base;
import static org.hamcrest.Matchers.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.restassured.RestAssured;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Title;


public class TestBase {
	
	@BeforeClass
	public static void init() {
		RestAssured.baseURI="http://services.groupkt.com";
		
	}
	

}
