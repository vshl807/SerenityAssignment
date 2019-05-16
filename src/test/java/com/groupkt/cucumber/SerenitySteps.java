package com.groupkt.cucumber;

import com.groupkt.base.TestBase;
import net.serenitybdd.rest.SerenityRest;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class SerenitySteps extends TestBase
	{
		@Step
		public ValidatableResponse passGetRequest(String path)
		{
			return SerenityRest.given()
					.when()
					.get(path)
					.then();
		}

	}

