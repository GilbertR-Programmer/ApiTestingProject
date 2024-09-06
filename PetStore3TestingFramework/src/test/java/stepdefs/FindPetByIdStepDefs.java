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
import pojos.Category;
import pojos.FindPetByIdResponse;
import pojos.TagsItem;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FindPetByIdStepDefs {
    private Integer petId;
    private FindPetByIdModel model;
    private List<String> petIds;
    private final Map<String, FindPetByIdResponse> responses = new HashMap<>();
    private Map<String, Integer> responsesStatusCodes = new HashMap<>();

    @Given("I have a valid pet ID")
    public void iHaveAValidPetID(DataTable dataTable) {
        petIds = dataTable.asMaps(String.class, String.class).stream()
                .map(map -> map.get("petId"))
                .toList();
    }

    @When("I make get a request to find pet by id")
    public void iMakeAGETRequestToPetPetId() {
        for (String petId : petIds) {
            model = new FindPetByIdModel(Integer.parseInt(petId));
            model.sendRequest();
            responses.put(petId, model.getResponse());
            responsesStatusCodes.put(petId, model.getResponseStatusCode());
        }
    }

    @Then("I should receive a 200 OK response")
    public void iShouldReceiveAOKResponse() {
        for (String petId : petIds) {
            MatcherAssert.assertThat("Status code for pet ID " + petId, responsesStatusCodes.get(petId), Matchers.is(200));
        }
    }

    @And("the pet details should have an ID of")
    public void thePetDetailsShouldHaveAnIDOf(DataTable dataTable) {
        List<String> expectedPetIds = dataTable.asMaps(String.class, String.class).stream()
                .map(map -> map.get("petId"))
                .toList();

        for (String expectedPetId : expectedPetIds) {
            FindPetByIdResponse petResponse = responses.get(expectedPetId);
            MatcherAssert.assertThat("Pet ID mismatch for expected ID " + expectedPetId, petResponse.id(), Matchers.is(Integer.parseInt(expectedPetId)));
        }
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
