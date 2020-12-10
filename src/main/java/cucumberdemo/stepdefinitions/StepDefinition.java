package cucumberdemo.stepdefinitions;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.fasterxml.jackson.databind.ObjectMapper;

import cucumberdemo.entities.ResponseObject;
import cucumberdemo.entities.User;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinition {
	
	String jsonUser;
	Response rs;
	WebTarget myResource;
	
	@Given("I set API endpoint")
	public void setEndpoint() {
		try {
			Client client = ClientBuilder.newClient();
			User user = new User("morpheus", "leader");
			ObjectMapper mapper = new ObjectMapper();
	        jsonUser = mapper.writeValueAsString(user);
	        myResource = client.target("https://reqres.in/api/users");
			System.out.println("Endpoint set");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@When("I make a POST request")
	public void makeRequest() {
		rs = myResource.request(MediaType.APPLICATION_JSON).post(Entity.json(jsonUser), Response.class);
		System.out.println("Request made"); 
	}
	
	@Then("I receive a valid response")
	public void receiveResponse() {
		
		try {
			ObjectMapper mapper = new ObjectMapper();
			ResponseObject response = mapper.readValue(rs.readEntity(String.class), ResponseObject.class);
			System.out.println("Response status is: " + rs.getStatus());
			System.out.println("Name is: " + response.getName());
			System.out.println("Job is: " + response.getJob());
			System.out.println("Id is: " + response.getId());
			System.out.println("Created at: " + response.getCreatedAt());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
