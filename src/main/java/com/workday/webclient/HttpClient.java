package com.workday.webclient;

import java.io.IOException;

import com.mashape.unirest.http.*;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.workday.webclient.JsonResponse;

public class HttpClient {
	static JsonResponse resp;
	public static void main(String[] args) throws IOException, UnirestException {
		HttpClient client = new HttpClient();
		resp = client.get("http://jsonplaceholder.typicode.com/posts");
		System.out.println(resp.getStatusCode());
		System.out.println(resp.getStatusText());
		System.out.println(resp.getArraySize());
		System.out.println(resp.getJsonObject(3));
		System.out.println(resp.getKeyString(3, "title"));
		System.out.println(resp.getKeyInt(3, "id"));
		Unirest.shutdown();
	}

	public JsonResponse get(String url) throws UnirestException {
		JsonResponse resp = new JsonResponse(Unirest.get(url).asJson());
		return resp;
	}
}