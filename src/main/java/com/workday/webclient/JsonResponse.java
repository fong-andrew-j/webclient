package com.workday.webclient;

import org.json.*;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;

public class JsonResponse {
	int statusCode;
	String statusText;
	static JSONArray jsonArray;

	public JsonResponse(HttpResponse<JsonNode> resp) {
		statusCode = resp.getStatus();
		statusText = resp.getStatusText();
		jsonArray = resp.getBody().getArray();
	}

	public int getStatusCode() {
		return statusCode;
	}

	public String getStatusText() {
		return statusText;
	}

	public JSONArray getJsonArray() {
		return jsonArray;
	}

	public int getArraySize() {
		return jsonArray.length();
	}

	public JSONObject getJson(int index) {
		return jsonArray.getJSONObject(index);
	}

	public String getKey(int index, String key) {
		return jsonArray.getJSONObject(index).getString(key);
	}
}
