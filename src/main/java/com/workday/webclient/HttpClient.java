package com.workday.webclient;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class HttpClient {
	private RestTemplate rest = new RestTemplate();

	public ResponseEntity<String> get(String url) {
		return rest.getForEntity(url, String.class);
	}

	public ResponseEntity<String> get(String url, HashMap<String, String> urlVariables) {
		return rest.getForEntity(url, String.class, urlVariables);
	}

	//http://stackoverflow.com/questions/19238715/how-to-set-an-accept-header-on-spring-resttemplate-request
}
