package com.workday.webclient;

import java.io.IOException;

import com.mashape.unirest.http.*;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.*;

public class HttpClient {
	public static void main(String[] args) throws UnirestException, IOException {
		HttpResponse<JsonNode> jsonResponse = Unirest.get("http://jsonplaceholder.typicode.com/posts").asJson();
		System.out.println(jsonResponse.getStatus());
		System.out.println(jsonResponse.getStatusText());

		JSONArray json = jsonResponse.getBody().getArray();
		Unirest.shutdown();
	}
}
