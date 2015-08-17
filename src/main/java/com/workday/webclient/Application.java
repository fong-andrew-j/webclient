package com.workday.webclient;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootApplication
public class Application implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String args[]) {
        SpringApplication.run(Application.class);
    }

    @Override
    public void run(String... strings) throws Exception {
        RestTemplate restTemplate = new RestTemplate();
//        String quote = restTemplate.getForObject("http://gturnquist-quoters.cfapps.io/api/random", String.class);
        String quote = restTemplate.getForObject("http://jsonplaceholder.typicode.com/posts/1", String.class);
        ObjectMapper m = new ObjectMapper();
        JsonNode rootNode = m.readTree(quote);
        JsonNode nameNode = rootNode.path("title");
        log.info(quote);
        log.info("DREW :: " + nameNode.asText());
        log.info("DREW2 :: " + rootNode.path("body").asText());
    }
}