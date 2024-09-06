package stepdefs;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import models.FindPetByIdModel;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import pojos.Category;
import pojos.FindPetByIdResponse;
import pojos.TagsItem;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FindPetByIdStepDefs {
    private String petId;
    private FindPetByIdModel model;


    @And("an error message indicating that the pet was not found")
    public void anErrorMessageIndicatingThatThePetWasNotFound() {
        Assertions.fail();
    }

    @And("an error message indicating that the pet ID format is invalid")
    public void anErrorMessageIndicatingThatThePetIDFormatIsInvalid() {
        Assertions.fail();
    }

    @Given("I have a valid pet ID of {string}")
    public void iHaveAValidPetIDOfPetId(String petId) {
        this.petId = petId;
    }

    @And("the pet details should have an ID of {string}")
    public void thePetDetailsShouldHaveAnIDOfPetId(String expectedPetId) {
        String actualPetId = model.getPetIdInResponse();
        Assertions.assertEquals(expectedPetId,actualPetId);
    }

    @When("I make get a request to find pet by id")
    public void iMakeGetARequestToFindPetById() {
        model = new FindPetByIdModel(Integer.valueOf(petId));
        model.sendRequest();
    }

    @Given("I have an invalid pet ID that does not exist")
    public void iHaveAnInvalidPetIDThatDoesNotExist() {
        petId = "9999";
    }

    @Given("I have a pet ID in an invalid format")
    public void iHaveAPetIDInAnInvalidFormat() {
        petId = "fghuigndjkgn";
    }
}
