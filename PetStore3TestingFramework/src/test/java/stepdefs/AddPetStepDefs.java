package stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import models.AddPetModel;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.Request;
import pojos.AddPet;
import pojos.Category;
import pojos.TagsItem;

import java.util.List;

public class AddPetStepDefs {

    private AddPetModel addPetModel;

    @Given("I have created a post request")
    public void iHaveCreatedAPostRequest() {
        addPetModel = new AddPetModel();
    }

    @And("I have entered Valid information")
    public void iHaveEnteredValidInformation() {
        addPetModel.enterPet(new AddPet(
                List.of("string"),
                "Roxy",
                0,
                new Category("Dogs",1),
                List.of(new TagsItem("string",0)),
                "available"
        ));

    }

    @When("I send the POST request")
    public void iSendThePOSTRequest() {
        addPetModel.sendRequest();
    }

    @Then("I should receive a {int} status Code")
    public void iShouldReceiveASuccessfulOperationStatusCode(int expectedStatusCode) {
        Assertions.assertEquals(expectedStatusCode, addPetModel.getResponseStatusCode());

    }

    @And("the store should contain the new pet")
    public void theStoreShouldContainTheNewPet() {
        //TODO : THIS WILL USE THE SAME CODE AS THE GET ALL PETS ENDPOINT SO ADD IT THEN
    }

    @And("I have not entered Valid information")
    public void iHaveNotEnteredValidInformation() {
        addPetModel.enterPet("null");
    }

    @And("the store should not contain the invalid entry")
    public void theStoreShouldNotContainTheInvalidEntry() {
        //TODO : THIS WILL USE THE SAME CODE AS THE GET ALL PETS ENDPOINT SO ADD IT THEN
    }


}
