package com.workday.webclient;

import java.io.IOException;
import java.util.HashMap;

import com.mashape.unirest.http.*;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.*;

public class HttpClient {
	int statusCode;
	String statusText;
	static JSONArray json;
	
	public static void main(String[] args) throws IOException, UnirestException {
		HttpClient client = new HttpClient();
		client.get("http://jsonplaceholder.typicode.com/posts");
		System.out.println(client.statusCode);
		System.out.println(client.statusText);
		System.out.println(json.length());
		System.out.println(json.getJSONObject(3));
		
//		for(int i = 0; i < json.length(); i++) {			
//			System.out.println(json.getJSONObject(i));
//		}
//		for(int i=0; i<json.length(); i++) {
//			System.out.println(json.getJSONObject(i).getString("title"));
//		}		
		Unirest.shutdown();
	}
	
	public void get(String url) throws UnirestException {		
		HttpResponse<JsonNode> resp = Unirest.get(url).asJson();
		statusCode = resp.getStatus();
		statusText = resp.getStatusText();
		json = resp.getBody().getArray();		
	}
}
