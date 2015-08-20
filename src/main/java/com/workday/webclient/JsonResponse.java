package com.workday.webclient;

import java.io.IOException;
import java.util.ArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonResponse {
	private static final Logger log = LoggerFactory.getLogger(Application.class);
	private ResponseEntity<String> resp;
	private HttpStatus status;
	private HttpHeaders headers;
	private String jsonString;

	public JsonResponse(ResponseEntity<String> resp) {
		this.resp = resp;
		processResponse(resp);
	}

	private void processResponse(ResponseEntity<String> resp) {
		setStatus(resp);
		setHeaders(resp);
		setJsonString(resp);
	}

	public HttpStatus getStatus() {
		return status;
	}

	private void setStatus(ResponseEntity<String> resp) {
		this.status = resp.getStatusCode();
	}

	public HttpHeaders getHeaders() {
		return headers;
	}

	private void setHeaders(ResponseEntity<String> resp) {
		this.headers = resp.getHeaders();
	}

	public String getJsonString() {
		return jsonString;
	}

	private void setJsonString(ResponseEntity<String> resp) {
		this.jsonString = resp.getBody();
	}

	public ArrayList<String> searchForKey(String key) throws JsonProcessingException, IOException {
		ObjectMapper m = new ObjectMapper();
		JsonNode rootNode = m.readTree(getJsonString());
		ArrayList<String> matches = new ArrayList<String>();

		if (rootNode.isArray()) {
			for (JsonNode obj : rootNode) {
				if (obj.get(key) != null) {
					matches.add(obj.get(key).asText());
				}
			}
		} else {
			if (rootNode.get(key) != null) {
				matches.add(rootNode.get(key).asText());
			}
		}
		return matches;
	}
}
