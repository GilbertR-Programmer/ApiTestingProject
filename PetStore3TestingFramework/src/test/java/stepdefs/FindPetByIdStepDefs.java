package stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import models.FindPetByIdModel;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;

public class FindPetByIdStepDefs {
    private Response response;
    private Integer petId;

    @Given("I have a valid pet ID")
    public void iHaveAValidPetID() {
        petId = 3;
    }

    @When("I make a GET request to \\/pet\\/\\{petId}")
    public void iMakeAGETRequestToPetPetId() {
        FindPetByIdModel findPetByIdModel = new FindPetByIdModel(petId);
        findPetByIdModel.sendRequest();
    }

    @Then("I should receive a 200 OK response")
    public void iShouldReceiveAOKResponse() {
        MatcherAssert.assertThat(response.getStatusCode(), Matchers.is(200));
    }

    @And("the pet details should be correct")
    public void thePetDetailsShouldBeCorrect() {
        MatcherAssert.assertThat(response.jsonPath().getString("id"), Matchers.is(petId));
    }

    @Given("I have an invalid pet ID that does not exist")
    public void iHaveAnInvalidPetIDThatDoesNotExist() {
        petId = 999999;
    }

    @Then("I should receive a {int} Not Found response")
    public void iShouldReceiveANotFoundResponse(int arg0) {
    }

    @And("an error message indicating that the pet was not found")
    public void anErrorMessageIndicatingThatThePetWasNotFound() {
    }

    @Given("I have a pet ID in an invalid format")
    public void iHaveAPetIDInAnInvalidFormat() {
//        petId="adbc";
    }

    @Then("I should receive a {int} Bad Request response")
    public void iShouldReceiveABadRequestResponse(int arg0) {
    }

    @And("an error message indicating that the pet ID format is invalid")
    public void anErrorMessageIndicatingThatThePetIDFormatIsInvalid() {
    }
}
