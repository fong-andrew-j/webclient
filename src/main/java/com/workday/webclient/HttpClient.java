package com.workday.webclient;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
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

	/**
	 * Performs HTTP GET on a URL with no parameters or headers
	 * @param url
	 * @return
	 */
	public JsonResponse get(String url) {
		HashMap<String, String> urlVariables = new HashMap<String, String>();
		createEntity();
		return new JsonResponse(rest.exchange(url, HttpMethod.GET, entity, String.class, urlVariables));
	}

	/**
	 * Performs HTTP GET on a URL allows setting headers and URL parameters
	 * What if user only wants header or parameters but not both?
	 * @param url
	 * @param headerMap
	 * @param urlVariables
	 * @return
	 */
	public JsonResponse get(String url, HashMap<String, String> urlVariables) {
		createEntity();
		return new JsonResponse(rest.exchange(url, HttpMethod.GET, entity, String.class, urlVariables));
	}

	/**
	 * Performs a HTTP POST on a URL
	 * @param url
	 * @return
	 */
	public JsonResponse post(String url) {
		HashMap<String, String> urlVariables = new HashMap<String, String>();
		createEntity();
		return new JsonResponse(rest.exchange(url, HttpMethod.POST, entity, String.class, urlVariables));
	}

	/**
	 * Performs HTTP POST on a URL allows setting headers and URL parameters
	 * @param url
	 * @param urlVariables
	 * @return
	 */
	public JsonResponse post(String url, HashMap<String, String> urlVariables) {
		createEntity();
		return new JsonResponse(rest.exchange(url, HttpMethod.POST, entity, String.class, urlVariables));
	}

	public JsonResponse put(String url) {
		HashMap<String, String> urlVariables = new HashMap<String, String>();
		createEntity();
		return new JsonResponse(rest.exchange(url, HttpMethod.PUT, entity, String.class, urlVariables));
	}

	/**
	 * Performs HTTP PUT on a URL allows setting headers and URL parameters
	 * @param url
	 * @param urlVariables
	 * @return
	 */
	public JsonResponse put(String url, HashMap<String, String> urlVariables) {
		createEntity();
		return new JsonResponse(rest.exchange(url, HttpMethod.PUT, entity, String.class, urlVariables));
	}

	public JsonResponse delete(String url) {
		HashMap<String, String> urlVariables = new HashMap<String, String>();
		createEntity();
		return new JsonResponse(rest.exchange(url, HttpMethod.DELETE, entity, String.class, urlVariables));
	}

	/**
	 * Performs HTTP DELETE on a URL allows settings headers and URL parameters
	 * @param url
	 * @param urlVariables
	 * @return
	 */
	public JsonResponse delete(String url, HashMap<String, String> urlVariables) {
		createEntity();
		return new JsonResponse(rest.exchange(url, HttpMethod.DELETE, entity, String.class, urlVariables));
	}

	/*****
	 * Helpers
	 *****/

	/**
	 * Mass add headers from a HashMap
	 * @param headerMap
	 */
	public void addHeadersFromMap(HashMap<String, String> headerMap) {
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

	/**
	 * Add a single header key-value pair
	 * @param key
	 * @param value
	 */
	public void addHeader(String key, String value) {
		headers.set(key, value);
	}

	/**
	 * Mass add body parameters from a HashMap
	 * @param bodyMap
	 */
	public void addBodyFromMap(HashMap<String, String> bodyMap) {
		for (Entry<String, String> bodyParam : bodyMap.entrySet()) {
			body.add(bodyParam.getKey(), bodyParam.getValue());
		}
	}

	/**
	 * Add a single body key-value pair
	 * @param key
	 * @param value
	 */
	public void addBodyParameter(String key, String value) {
		body.add(key, value);
	}

	/**
	 * Creates a HttpEntity to be used in the REST calls
	 */
	public void createEntity() {
		entity = new HttpEntity<Map>(body, headers);
	}
}
