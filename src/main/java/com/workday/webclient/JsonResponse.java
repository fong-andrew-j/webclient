package com.workday.webclient;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonResponse {
	private static final Logger log = LoggerFactory.getLogger(Application.class);
	private RestTemplate rest = new RestTemplate();
	private ResponseEntity<String> resp;
	private HttpStatus status;
	private HttpHeaders headers;
	private String jsonString;

	public void get(String url) {
		resp = rest.getForEntity(url, String.class);
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

	public String searchJson(String key) throws JsonProcessingException, IOException {
		ObjectMapper m = new ObjectMapper();
		JsonNode rootNode = m.readTree(getJsonString()).path(key);
		return rootNode.asText();
	}
}
