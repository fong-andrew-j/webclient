# ${1:Project Name}

Designed to make it easy to automate HTTP calls that return JSON and process it.
You can make the following HTTP calls:

* Get
* Post
* Put
* Delete

You can also set headers and body parameters. You can also process the HTTP 
response and do some simple parsing on the JSON coming back.

# Building

# Clone the repo
# Build the project with gradlew
## ./gradlew clean build

The resulting jar will be built in the build/libs directory.

# Installation

Include the built jar into the class path of your project and import it into 
your project.

> import com.workday.webclient.*;

# Usage

## Simple GET Request
The following is a simple GET request which also shows how to process the 
response.

    HttpClient client = new HttpClient();
    JsonResponse resp = client.get("http://jsonplaceholder.typicode.com/users");
    System.out.println(resp.getStatus());
    System.out.println(resp.getHeaders());
    System.out.println(resp.getJsonString());
    System.out.println(resp.searchForKey("username"));

## POST Request

    HttpClient client = new HttpClient();
    HashMap<String, String> bodyParameters = new HashMap<String, String>();
    bodyParameters.put("title", "foo");
    bodyParameters.put("body", "bar");
    bodyParameters.put("userId", "1");
    client.addBodyFromMap(bodyParameters);
    resp = client.post("http://jsonplaceholder.typicode.com/posts");
    System.out.println(resp.getStatus());
    System.out.println(resp.getJsonString());

## PUT Request
    
    HttpClient client = new HttpClient();
    bodyParameters = new HashMap<String, String>();
    bodyParameters.put("id", "1");
    bodyParameters.put("title", "foo");
    bodyParameters.put("body", "bar");
    bodyParameters.put("userId", "1");
    client.addBodyFromMap(bodyParameters);
    resp = client.put("http://jsonplaceholder.typicode.com/posts/1");
    System.out.println(resp.getStatus());
    System.out.println(resp.getJsonString());

## DELETE Request

    HttpClient client = new HttpClient();
    resp = client.delete("http://jsonplaceholder.typicode.com/posts/1");
    System.out.println(resp.getStatus());
    System.out.println(resp.getJsonString());

## Adding Headers

    HttpClient client = new HttpClient();
    HashMap<String, String> headers = new HashMap<String, String>();
    headers.put("Authorization", "ID eyJhbGciOiJSUzUxMiIsImtpZCI6IkFTX25vZGUxXzA4MTcyMDE1MTA0OTA5OTMzIn0.eyJpc3MiOiJPTVMiLCJzdWIiOiJTdXBlclVzZXIiLCJhdWQiOiJ3ZCIsImV4cCI6MTQzOTg1NzA3OSwiaWF0IjoxNDM5ODU2ODk5LCJhdXRoX3RpbWUiOjE0Mzk4NTY4OTk5MjEsImp0aSI6Imd1ZW11ejkxNnA5aTFrY2hmYml4MmRkdDNpdGdvN2Z5cnhpMm93OTFuOXl4ZTZ1eWxxNGJ6cGo4aG55dHA3d3gxazF0bDBkOWZvY3p6OGg5eW16aTdnZnJqcmRtdW1kNWx3bXE3bThjYjZwNGlqb21pY2d3b2dwbjZuNHVvNjhiaXVkM3BqYno3MTc4bnByenF3djg4aWxwemxmaGI1NDI0ZzJ4Zm1zYjF2amltbnAzbmlrdWduNW53em03Zmptam0xb21rYnpyY2M2ZHF6ZGlva2NhaHpwcDc5dmg1ODFuZ2FmYWVwN3Y1NW4zdngyejVudnJ2dmM2ZHVpY2l0eng1djFkZWM1dmF1azFnMGthY2hmczl5dDN0bHV5dWl4cmcwZGExamZkaTI4dWllaXJqajdsMTYwNXEzemJxd2RiNWc0MmYxOXlqeHk4M3E0Y3ViZ3NlanY5eXM4eWhwcTBjNnd5eHE1cHQ4NDZ5aXpoMWtvNWhraTQ1cnY5MDBlNG1jbjJwcnp6Y3FwMyIsImNoYW5uZWwiOiJVSSIsImF1dGhfdHlwZSI6IlVuaXZlcnNhbFBhc3N3b3JkIiwic3lzX2FjY3RfdHlwIjoiTiIsInRlbmFudCI6InN1cGVyIiwic2NvcGUiOnt9LCJ0b2tlblR5cGUiOiJJZGVudGl0eSJ9.aOtcqtLAimxSf6pOdC8m2JkZFfwUt_6eWM4TOqEiyOE9Q9uM53vxvSUVtWOig6peqftXRw1-3yeTSxEPOYvkohJdf8ALu1Am1L_e-aEECRObx9O14iOQGGP3Fv5Y5p3Ga7Mg-2yNl1LNZvWoJtEqZU5Tc8EAbkdheJI42Kd5q_JZascIjMXriA2qKMkJJKs9mbuUrhKpNkwEkVKGt6gsiwQV0mrb0awCh6a4iCfrKN153FEj03sL8-c7V_gm1tt1");
    client.addHeaders(headers);

# Contributing

Fork it!
Create your feature branch: git checkout -b my-new-feature
Commit your changes: git commit -am 'Add some feature'
Push to the branch: git push origin my-new-feature
Submit a pull request :D

# History

TODO: Write history

# Credits

TODO: Write credits

# License

TODO: Write license