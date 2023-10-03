package stepdefinition;

import java.io.File;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class week4day1jiraassignment {
	
	public RequestSpecification Input;
	public static Response output;
	public static String Issue_Id;
	
	
	@Given("Set the Endpoint")
	public void set_the_endpoint() {
		
		RestAssured.baseURI="https://pavithrashanmugamjira.atlassian.net/rest/api/2/issue/";
	    
	}

	@And("set the auth")
	public void set_the_auth() {
		
		RestAssured.authentication=RestAssured.preemptive().basic("pavi2thara@gmail.com", 
				"ATATT3xFfGF0pmJVeoRahu8cscO_PMLY2DaeHxisdnr8--ztJTukBYMtHZmfU0IiY19d51dBVpyZwx3kWtMm2j3BdeuT5bJEXELIR4SqTtheCrhBS_vkOeIhA64_cjdbDTqWWYMAx5Fhs02fhGhdNmTNlYTAe2KdJ5wulo756LZDx6iFpzSGT4Q=2E99D095");
			    
	}

	
	@When("Create new incident with file {string}")
	public void createjiraincwihfile(String filename) {
	   
		File createfile = new File("./src/test/resources/"+filename);
		 Input = RestAssured.given().contentType("application/json").when().body(createfile);
		 
		  output = Input.post();
		  output.prettyPrint();
		  Issue_Id = output.jsonPath().get("id");
		  
		  System.out.println("Created new Issue ID is ===" +Issue_Id);
		
	}
	
	@When("update the incident body {string}")
	public void updatejiraincbody(String updateBody) {
	    
		Input =RestAssured.given().contentType("application/json").when().body(updateBody);
		 output = Input.put("/"+Issue_Id);
		
		 output.prettyPrint();
		 System.out.println("update the body in ticket");
	}
	
	@When("get the incident")
	public void getincjira() {
	   
	Input  = RestAssured.given();
	output = Input.get("/"+Issue_Id);
	
	output.prettyPrint();
	
	}
	
	@When("delete the incident")
	public void deleteincjira() {
	
		Input = RestAssured.given();
		output = Input.delete("/"+Issue_Id);
		
		System.out.println("This Ticket got deleted === :" +Issue_Id );
	}
	
	@Then("Vaildate the status code as {int}")
	public void validatestatuscode(Integer statusCode) {
		
		output.then().assertThat().statusCode(statusCode);
	    
	}

}
