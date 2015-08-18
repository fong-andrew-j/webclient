package com.workday.webclient;

import java.util.HashMap;
import java.util.Map.Entry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class HttpClient {
	private RestTemplate rest = new RestTemplate();
	private HttpEntity<String> headers;
	private static final Logger log = LoggerFactory.getLogger(Application.class);

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
		return rest.exchange(url, HttpMethod.GET, headers, String.class, urlVariables);
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
		return rest.exchange(url, HttpMethod.GET, headers, String.class, urlVariables);
	}

	/*****
	 * HTTP POST
	 */

	/*****
	 * HTTP PUT
	 */

	/*****
	 * HTTP DELETE
	 */

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
		setHeaders(new HttpEntity<String>(headers));
	}

	private void setHeaders(HttpEntity<String> headers) {
		this.headers = headers;
	}
	//http://stackoverflow.com/questions/19238715/how-to-set-an-accept-header-on-spring-resttemplate-request
}
