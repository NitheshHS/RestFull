package com.Rest.genericLib;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import static io.restassured.RestAssured.*;

public class BaseClass {
	@BeforeSuite
	public void configBS() {
		baseURI="http://localhost:8084";
		port=8084;
		DataBaseLib.connectToMySQL();
	}
	@AfterSuite
	public void configAS() {
		DataBaseLib.closeConnection();
	}


}
