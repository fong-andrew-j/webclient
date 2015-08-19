package com.workday.webclient;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

public class HttpClient {
	private RestTemplate rest = new RestTemplate();
	private HttpEntity<?> entity;
	private HttpHeaders headers;
	private MultiValueMap<String, String> body;
	private static final Logger log = LoggerFactory.getLogger(Application.class);

	public HttpClient() {
		headers = new HttpHeaders();
		body = new LinkedMultiValueMap<String, String>();
	}
	/*****
	 * HTTP GET
	 */

	/**
	 * Performs HTTP GET on a URL with no parameters or headers
	 * @param url
	 * @return
	 */
	public ResponseEntity<String> get(String url) {
		HashMap<String, String> urlVariables = new HashMap<String, String>();
		return rest.exchange(url, HttpMethod.GET, entity, String.class, urlVariables);
	}

	/**
	 * Performs HTTP GET on a URL allows setting headers and URL parameters
	 * What if user only wants header or parameters but not both?
	 * @param url
	 * @param headerMap
	 * @param urlVariables
	 * @return
	 */
	public ResponseEntity<String> get(String url, HashMap<String, String> urlVariables) {
		return rest.exchange(url, HttpMethod.GET, entity, String.class, urlVariables);
	}

	/*****
	 * HTTP POST
	 */

	public ResponseEntity<String> post(String url) {
		HashMap<String, String> urlVariables = new HashMap<String, String>();
		return rest.exchange(url, HttpMethod.POST, entity, String.class, urlVariables);
	}

	/**
	 * Performs HTTP POST on a URL allows setting headers and URL parameters
	 * @param url
	 * @param urlVariables
	 * @return
	 */
	public ResponseEntity<String> post(String url, HashMap<String, String> urlVariables) {
		return rest.exchange(url, HttpMethod.POST, entity, String.class, urlVariables);
	}

	/*****
	 * HTTP PUT
	 */

	/**
	 * Performs HTTP PUT on a URL allows setting headers and URL parameters
	 * @param url
	 * @param urlVariables
	 * @return
	 */
	public ResponseEntity<String> put(String url, HashMap<String, String> urlVariables) {
		return rest.exchange(url, HttpMethod.PUT, entity, String.class, urlVariables);
	}

	/*****
	 * HTTP DELETE
	 */

	/**
	 * Performs HTTP DELETE on a URL allows settings headers and URL parameters
	 * @param url
	 * @param urlVariables
	 * @return
	 */
	public ResponseEntity<String> delete(String url, HashMap<String, String> urlVariables) {
		return rest.exchange(url, HttpMethod.DELETE, entity, String.class, urlVariables);
	}

	/*****
	 * Helpers
	 */

	public void addHeaders(HashMap<String, String> headerMap) {
		HttpHeaders headers = new HttpHeaders();
		try {
			for (Entry<String, String> header : headerMap.entrySet()) {
				headers.set(header.getKey(), header.getValue());
			}
		} catch (NullPointerException npe) {
			log.error("Attempting to set headers but headerMap is null");
			headers = null;
		}
	}

	public void addBody() {
		body.add("request-originator", "UI");
		body.add("username", "superuser");
		body.add("password", "Da7@+%mfbMErS7at");
		body.add("remote-ip-address", "127.0.0.1");
		System.out.println(body);
	}

	public void createEntity() {
		entity = new HttpEntity<Map>(body, headers);
	}
}
