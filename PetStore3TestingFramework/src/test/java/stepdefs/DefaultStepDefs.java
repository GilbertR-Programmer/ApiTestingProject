package stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import models.AddPetModel;

public class DefaultStepDefs {



    @Given("I have Valid credentials")
    public void iHaveValidCredentials() {
    }

    @And("I have entered a valid body")
    public void iHaveEnteredAValidBody() {
    }

    @When("I submit the request to the api")
    public void iSubmitTheRequestToTheApi() {
    }

    @Then("i get a response with a {int}")
    public void iGetAResponseWithA(int arg0) {
    }
}
