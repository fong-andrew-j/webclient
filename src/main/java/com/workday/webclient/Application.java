package com.workday.webclient;

import com.fasterxml.jackson.databind.JsonNode;
import java.util.HashMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.workday.webclient.JsonResponse;

@SpringBootApplication
public class Application implements CommandLineRunner {
    public static void main(String args[]) {
        SpringApplication.run(Application.class);
    }

    @Override
    public void run(String... strings) throws Exception {
    	HttpClient client = new HttpClient();
    	HashMap<String, String> urlParams = new HashMap<String, String>();
    	urlParams.put("endpoint", "users");
    	JsonResponse resp = client.get("http://jsonplaceholder.typicode.com/{endpoint}", urlParams);
    	System.out.println(resp.getStatus());
    	System.out.println(resp.getHeaders());
    	System.out.println(resp.getJsonString());
    	System.out.println(resp.returnAllValuesForKey("username"));

    	HashMap<String, String> bodyParameters = new HashMap<String, String>();
    	bodyParameters.put("title", "foo");
    	bodyParameters.put("body", "bar");
    	bodyParameters.put("userId", "1");
    	client.addBodyFromMap(bodyParameters);
    	resp = client.post("http://jsonplaceholder.typicode.com/posts");
    	System.out.println(resp.getStatus());
    	System.out.println(resp.getJsonString());

    	bodyParameters = new HashMap<String, String>();
    	bodyParameters.put("id", "1");
    	bodyParameters.put("title", "foo");
    	bodyParameters.put("body", "bar");
    	bodyParameters.put("userId", "1");
    	client.addBodyFromMap(bodyParameters);
    	resp = client.put("http://jsonplaceholder.typicode.com/posts/1");
    	System.out.println(resp.getStatus());
    	System.out.println(resp.getJsonString());

    	resp = client.delete("http://jsonplaceholder.typicode.com/posts/1");
    	System.out.println(resp.getStatus());
    	System.out.println(resp.getJsonString());

    	resp = client.get("http://jsonplaceholder.typicode.com/users/1");
        String[] keys = {"address", "street"};
        System.out.println(resp.returnKeyValue(keys));
    }
}