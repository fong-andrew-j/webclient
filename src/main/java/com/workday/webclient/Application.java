package com.workday.webclient;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.workday.webclient.JsonResponse;

@SpringBootApplication
public class Application implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String args[]) {
        SpringApplication.run(Application.class);
    }

    @Override
    public void run(String... strings) throws Exception {
    	HttpClient client = new HttpClient();
    	JsonResponse resp = new JsonResponse(client.get("http://jsonplaceholder.typicode.com/users"));
    	System.out.println(resp.getStatus());
    	System.out.println(resp.getHeaders());
    	System.out.println(resp.getJsonString());
    	System.out.println(resp.searchJson("username"));

    	HashMap<String, String> urlVariables = new HashMap<String, String>();
    	urlVariables.put("endpoint", "posts");
    	urlVariables.put("id", "2");
    	resp = new JsonResponse(client.get("http://jsonplaceholder.typicode.com/{endpoint}/{id}", urlVariables));
    	System.out.println(resp.getStatus());
    	System.out.println(resp.getHeaders());
    	System.out.println(resp.getJsonString());

    }
}