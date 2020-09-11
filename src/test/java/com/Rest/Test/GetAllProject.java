package com.Rest.Test;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Rest.genericLib.BaseClass;
import com.Rest.genericLib.DataBaseLib;
import com.Rest.genericLib.IEndPoint;

import io.restassured.response.Response;

public class GetAllProject extends BaseClass {
	
	@Test
	public void getAllproject() {
		Response res = given()
			.get(IEndPoint.getAllproject);
		
		res.then().log().all();
		ArrayList<Object> lst=res.jsonPath().get("projectId");
		
		for(int i=0;i<lst.size();i++) {
			System.out.println(lst.get(i));
			Response response = given()
				.pathParam("projectId", lst.get(i))
			.when()
				.get(IEndPoint.getSingleProject);
			response.then()
			.assertThat().statusCode(200);
			
			Object actualPid = DataBaseLib.exceuteQueryAndGetdata("select * from project", 1, lst.get(i));
			Assert.assertEquals(lst.get(i), actualPid);
			
			
			
			
		}
	}

}
