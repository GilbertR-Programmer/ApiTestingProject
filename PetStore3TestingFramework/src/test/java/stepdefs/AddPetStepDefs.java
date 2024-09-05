package stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import models.AddPetModel;
import org.junit.runner.Request;
import pojos.AddPet;

import java.util.List;

public class AddPetStepDefs {

    private AddPetModel addPetModel;

    @Given("I have created a post request")
    public void iHaveCreatedAPostRequest() {
        addPetModel = new AddPetModel();
    }

    @And("I have entered Valid information")
    public void iHaveEnteredValidInformation() {


    }

    @When("I send the POST request")
    public void iSendThePOSTRequest() {
    }

    @Then("I should receive a {int} status Code")
    public void iShouldReceiveASuccessfulOperationStatusCode(int expectedStatusCode) {
    }

    @And("the store should contain the new pet")
    public void theStoreShouldContainTheNewPet() {
    }

    @And("I have not entered Valid information")
    public void iHaveNotEnteredValidInformation() {
    }

    @And("the store should not contain the invalid entry")
    public void theStoreShouldNotContainTheInvalidEntry() {
    }


}
