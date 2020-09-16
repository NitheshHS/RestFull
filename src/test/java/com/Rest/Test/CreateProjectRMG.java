package com.Rest.Test;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class CreateProjectRMG {
	@Test
	public void createProjeect() {
		given()	
			.contentType(ContentType.JSON)
		.when()
			.get("http://localhost:8084/projects")
		.then()
			.log()
				.all();
	}

}
