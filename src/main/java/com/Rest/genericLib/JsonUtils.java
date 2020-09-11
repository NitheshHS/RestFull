package com.Rest.genericLib;

import io.restassured.response.Response;

public class JsonUtils {
	public String jsonPath(Response res, String path) {
		return res.jsonPath().get(path);
	}

}
