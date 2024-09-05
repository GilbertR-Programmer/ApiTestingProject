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

    @Then("I should receive a {int} OK response")
    public void iShouldReceiveAOKResponse(int arg0) {
    }

    @And("the pet details should be correct")
    public void thePetDetailsShouldBeCorrect() {
    }

    @Given("I have an invalid pet ID that does not exist")
    public void iHaveAnInvalidPetIDThatDoesNotExist() {
    }

    @Then("I should receive a {int} Not Found response")
    public void iShouldReceiveANotFoundResponse(int arg0) {
    }

    @And("an error message indicating that the pet was not found")
    public void anErrorMessageIndicatingThatThePetWasNotFound() {
    }

    @Given("I have a pet ID in an invalid format")
    public void iHaveAPetIDInAnInvalidFormat() {
    }

    @Then("I should receive a {int} Bad Request response")
    public void iShouldReceiveABadRequestResponse(int arg0) {
    }

    @And("an error message indicating that the pet ID format is invalid")
    public void anErrorMessageIndicatingThatThePetIDFormatIsInvalid() {
    }
}
