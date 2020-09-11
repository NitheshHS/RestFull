package com.Rest.Test;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class PostReq {
	@Test
	public void postReqTest() {
		JSONObject job=new JSONObject();
		job.put("email", "eve.holt@reqres.in");
		job.put("password", "pistol");
		
		given()
			.contentType(ContentType.JSON)
			.body(job.toJSONString())
		.when()
			.post("https://reqres.in/api/register")
		.then()
			.log()
			.all();
	}

}
