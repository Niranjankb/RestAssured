package rest;

import org.json.simple.JSONObject;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class postrequest {

	public static void main(String[] args) {
		RestAssured.baseURI = "https://reqres.in";
		
		
		RequestSpecification request1 = RestAssured.given();//.auth().basic("username","password");
        request1.header("Content-Type", "application/json");
        JSONObject req=new JSONObject ();
        req.put("name","morpheus");
        req.put("job","leader");
        request1.body(req.toJSONString());
        Response response=request1.post("/api/users");
        System.out.println(response.getBody().asString());
        System.out.println(response.getStatusCode());
	}

}
