package com.workday.webclient;

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
    	JsonResponse resp = client.get("http://jsonplaceholder.typicode.com/users");
    	System.out.println(resp.getStatus());
    	System.out.println(resp.getHeaders());
    	System.out.println(resp.getJsonString());
    	System.out.println(resp.searchForKey("username"));

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

    	//Experiment
//    	HashMap<String, String> headers = new HashMap<String, String>();
//    	headers.put("Authorization", "ID eyJhbGciOiJSUzUxMiIsImtpZCI6IkFTX25vZGUxXzA4MTcyMDE1MTA0OTA5OTMzIn0.eyJpc3MiOiJPTVMiLCJzdWIiOiJTdXBlclVzZXIiLCJhdWQiOiJ3ZCIsImV4cCI6MTQzOTg1NzA3OSwiaWF0IjoxNDM5ODU2ODk5LCJhdXRoX3RpbWUiOjE0Mzk4NTY4OTk5MjEsImp0aSI6Imd1ZW11ejkxNnA5aTFrY2hmYml4MmRkdDNpdGdvN2Z5cnhpMm93OTFuOXl4ZTZ1eWxxNGJ6cGo4aG55dHA3d3gxazF0bDBkOWZvY3p6OGg5eW16aTdnZnJqcmRtdW1kNWx3bXE3bThjYjZwNGlqb21pY2d3b2dwbjZuNHVvNjhiaXVkM3BqYno3MTc4bnByenF3djg4aWxwemxmaGI1NDI0ZzJ4Zm1zYjF2amltbnAzbmlrdWduNW53em03Zmptam0xb21rYnpyY2M2ZHF6ZGlva2NhaHpwcDc5dmg1ODFuZ2FmYWVwN3Y1NW4zdngyejVudnJ2dmM2ZHVpY2l0eng1djFkZWM1dmF1azFnMGthY2hmczl5dDN0bHV5dWl4cmcwZGExamZkaTI4dWllaXJqajdsMTYwNXEzemJxd2RiNWc0MmYxOXlqeHk4M3E0Y3ViZ3NlanY5eXM4eWhwcTBjNnd5eHE1cHQ4NDZ5aXpoMWtvNWhraTQ1cnY5MDBlNG1jbjJwcnp6Y3FwMyIsImNoYW5uZWwiOiJVSSIsImF1dGhfdHlwZSI6IlVuaXZlcnNhbFBhc3N3b3JkIiwic3lzX2FjY3RfdHlwIjoiTiIsInRlbmFudCI6InN1cGVyIiwic2NvcGUiOnt9LCJ0b2tlblR5cGUiOiJJZGVudGl0eSJ9.aOtcqtLAimxSf6pOdC8m2JkZFfwUt_6eWM4TOqEiyOE9Q9uM53vxvSUVtWOig6peqftXRw1-3yeTSxEPOYvkohJdf8ALu1Am1L_e-aEECRObx9O14iOQGGP3Fv5Y5p3Ga7Mg-2yNl1LNZvWoJtEqZU5Tc8EAbkdheJI42Kd5q_JZascIjMXriA2qKMkJJKs9mbuUrhKpNkwEkVKGt6gsiwQV0mrb0awCh6a4iCfrKN153FEj03sL8-c7V_gm1tt1");
//    	client.addHeaders(headers);

//    	bodyParameters.put("request-originator", "UI");
//    	bodyParameters.put("username", "superuser");
//    	bodyParameters.put("password", "Da7@+%mfbMErS7at");
//    	bodyParameters.put("remote-ip-address", "127.0.0.1");
//
//    	client.addBodyFromMap(bodyParameters);
//
//    	resp = client.post("http://localhost:12766/auth-server/services/super/api/v1/token");
//    	System.out.println(resp.getStatus());
//    	System.out.println(resp.getHeaders());
//    	System.out.println(resp.getJsonString());
    }
}