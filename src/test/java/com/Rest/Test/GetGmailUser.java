package com.Rest.Test;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.authentication.AuthenticationScheme;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

public class GetGmailUser {

	@Test
	public void GmailTest() {
		JSONObject job=new JSONObject();
		job.put("name", "morpheus");
		job.put("job", "leader");
		AuthenticationScheme scheme=digest("nithesh", "passowrd");
		RequestSpecBuilder builder=new RequestSpecBuilder();
		builder.setBaseUri("https://reqres.in/api/users");
		builder.setContentType(ContentType.JSON);
		builder.setBody(job.toJSONString());
		builder.setAuth(scheme);
		RequestSpecification spec = builder.build();
		
		
		ResponseSpecBuilder builder2=new ResponseSpecBuilder();
		builder2.expectContentType(ContentType.JSON);
		builder2.expectStatusCode(201);
		ResponseSpecification spec2=builder2.build();
		
		
		Response res = given()
		.spec(spec)
		.when()
			.post();
		res.then()
			.spec(spec2)
			.and()
				.log().all();
		System.out.println(res.getStatusCode());
		System.out.println(res.getTime());
		System.out.println(res.getTimeIn(TimeUnit.SECONDS));
			
	}

}
