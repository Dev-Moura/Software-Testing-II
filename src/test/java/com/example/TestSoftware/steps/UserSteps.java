package com.example.TestSoftware.steps;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.resttestclient.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.TestSoftware.model.User;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UserSteps {

    private String name;
    private ResponseEntity<User> response;

    @Autowired
    private TestRestTemplate restTemplate;

    @Given("the user name is {string}")
    public void theUserNameIs(String name) {
        this.name = name;
    }

    @When("i send a request to create the user")
    public void iSendRequestToCreateUser() {
        User user = new User();
        user.setName(name);

        response = restTemplate.postForEntity(
                "/api/users",
                user,
                User.class
        );
    }

    @Then("the user should be saved with name {string}")
    public void userShouldBeSavedWithName(String expectedName) {
        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode()); // ajuste para HttpStatus.CREATED se o endpoint retornar 201
        assertNotNull(response.getBody());
        assertEquals(expectedName, response.getBody().getName());
    }
}
