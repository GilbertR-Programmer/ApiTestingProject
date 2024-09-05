package stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FindPetByIdStepDefs {
    @Given("I have a valid pet ID")
    public void iHaveAValidPetID() {
    }

    @When("I make a GET request to \\/pet\\/\\{petId}")
    public void iMakeAGETRequestToPetPetId() {
    }

    @Then("I should receive a response with the pet's details")
    public void iShouldReceiveAResponseWithThePetSDetails() {
    }

    @Given("I provide an invalid pet ID that does not exist")
    public void iProvideAnInvalidPetIDThatDoesNotExist() {
    }

    @Then("I should receive a {int} Not Found error")
    public void iShouldReceiveANotFoundError(int arg0) {
    }

    @And("the response message should indicate that the pet was not found")
    public void theResponseMessageShouldIndicateThatThePetWasNotFound() {
    }

    @Given("I provide a pet ID that does not conform to the expected format")
    public void iProvideAPetIDThatDoesNotConformToTheExpectedFormat() {
    }

    @Then("I should receive a {int} Bad Request error")
    public void iShouldReceiveABadRequestError(int arg0) {
    }

    @And("the response message should indicate that the pet ID format is invalid")
    public void theResponseMessageShouldIndicateThatThePetIDFormatIsInvalid() {
    }
}
