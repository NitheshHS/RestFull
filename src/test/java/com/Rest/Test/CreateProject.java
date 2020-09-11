package com.Rest.Test;

import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Rest.PojoClass.Project;
import com.Rest.genericLib.BaseClass;
import com.Rest.genericLib.DataBaseLib;
import com.Rest.genericLib.IEndPoint;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class CreateProject extends BaseClass{
	@Test
	public void createProject() {
		String projectName="AWS123";
		String status="OnGoing";
		Project proj=new Project(projectName, "Ty_0101", "Aug", "NitheshHS", status, 12);
		Response res = given()
			.contentType(ContentType.JSON)
			.body(proj)
		.when()
			.post(IEndPoint.addSingleProject);
		
		res.then()
		.assertThat().statusCode(201)
		.and()
			.assertThat().body("msg", Matchers.equalTo("Successfully Added"))
			.log().all();
		
		System.out.println(res.getStatusCode());
		System.out.println(res.getContentType());
		
		Object actualStatus = DataBaseLib.exceuteQueryAndGetdata("select * from project", 5, status);
		Assert.assertEquals(actualStatus, status);
			
	}

}
