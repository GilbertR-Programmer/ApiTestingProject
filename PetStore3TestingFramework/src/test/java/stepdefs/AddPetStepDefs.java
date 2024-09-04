package stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.runner.Request;

public class AddPetStepDefs {

    private RequestSpecification request;
    private Response response;

    @Given("I have created a post request")
    public void iHaveCreatedAPostRequest() {
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
