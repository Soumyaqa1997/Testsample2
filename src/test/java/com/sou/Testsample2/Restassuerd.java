package com.sou.Testsample2;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import static io.restassured.module.jsv.JsonSchemaValidator.*;



import java.util.HashMap;

import org.openqa.selenium.json.Json;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;



public class Restassuerd {

	
	@Test(enabled = false)
	public void test() {
		given()
		.when().get("https://reqres.in/api/users/2")
		.then().statusCode(200)
		.assertThat()
		.body("$.data.email",equalTo("janet.weaver@reqres.in"))
		
		.log().all();
		
		
		
	}
	@Test(enabled = true)
	public void test1() {
		
		 given()
         
     .when()
         .get("https://reqres.in/api/users?page=2")
     .then()
         .assertThat()
         .statusCode(200)
         .body(matchesJsonSchemaInClasspath("schema.json"))
         .log().all();
	}
	
	@Test(enabled = false)
	public void test3() {
		String json = "{\n" +
		        "    \"page\": 2,\n" +
		        "    \"per_page\": 6,\n" +
		        "    \"total\": 12,\n" +
		        "    \"total_pages\": 2,\n" +
		        "    \"data\": [\n" +
		        "        {\n" +
		        "            \"id\": 7,\n" +
		        "            \"email\": \"michael.lawson@reqres.in\",\n" +
		        "            \"first_name\": \"Michael\",\n" +
		        "            \"last_name\": \"Lawson\",\n" +
		        "            \"avatar\": \"https://reqres.in/img/faces/7-image.jpg\"\n" +
		        "        },\n" +
		        "        {\n" +
		        "            \"id\": 8,\n" +
		        "            \"email\": \"lindsay.ferguson@reqres.in\",\n" +
		        "            \"first_name\": \"Lindsay\",\n" +
		        "            \"last_name\": \"Ferguson\",\n" +
		        "            \"avatar\": \"https://reqres.in/img/faces/8-image.jpg\"\n" +
		        "        },\n" +
		        "        {\n" +
		        "            \"id\": 9,\n" +
		        "            \"email\": \"tobias.funke@reqres.in\",\n" +
		        "            \"first_name\": \"Tobias\",\n" +
		        "            \"last_name\": \"Funke\",\n" +
		        "            \"avatar\": \"https://reqres.in/img/faces/9-image.jpg\"\n" +
		        "        },\n" +
		        "        {\n" +
		        "            \"id\": 10,\n" +
		        "            \"email\": \"byron.fields@reqres.in\",\n" +
		        "            \"first_name\": \"Byron\",\n" +
		        "            \"last_name\": \"Fields\",\n" +
		        "            \"avatar\": \"https://reqres.in/img/faces/10-image.jpg\"\n" +
		        "        },\n" +
		        "        {\n" +
		        "            \"id\": 11,\n" +
		        "            \"email\": \"george.edwards@reqres.in\",\n" +
		        "            \"first_name\": \"George\",\n" +
		        "            \"last_name\": \"Edwards\",\n" +
		        "            \"avatar\": \"https://reqres.in/img/faces/11-image.jpg\"\n" +
		        "        },\n" +
		        "        {\n" +
		        "            \"id\": 12,\n" +
		        "            \"email\": \"rachel.howell@reqres.in\",\n" +
		        "            \"first_name\": \"Rachel\",\n" +
		        "            \"last_name\": \"Howell\",\n" +
		        "            \"avatar\": \"https://reqres.in/img/faces/12-image.jpg\"\n" +
		        "        }\n" +
		        "    ],\n" +
		        "    \"support\": {\n" +
		        "        \"url\": \"https://reqres.in/#support-heading\",\n" +
		        "        \"text\": \"To keep ReqRes free, contributions towards server costs are appreciated!\"\n" +
		        "    }\n" +
		        "}";

		given().contentType(ContentType.JSON)
		.body(json)
        
	     .when()
	         .post("https://reqres.in/api/users?page=2")
	     .then()
	         .assertThat()
	         .statusCode(200)
	         .body(matchesJsonSchemaInClasspath("schema.json"))
	         .log().all();
	}
	




}
