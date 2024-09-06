package stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import models.DeletePetModel;
import models.FindPetByIdModel;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DeletePetStepDefs {

    private String petId;
    private String apiKey;
    private DeletePetModel model;

    @Given("I have provided a valid Pet ID of {string}")
    public void iHaveProvidedAValidPetId(String petId) {
        this.petId = petId;
    }

    @Given("I have provided a valid Api_Key of {string}")
    public void iHaveProvidedAValidApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    @When("I send a DELETE request to the Petstore API")
    public void iSendADeleteRequestToThePetstoreApi() {
        model = new DeletePetModel(Integer.valueOf(petId), apiKey);
        model.sendDeleteRequest();
    }

    @Then("I should receive a {int} OK status code")
    public void iShouldReceiveANoContentStatusCode(int expectedStatusCode) {
        int actualStatusCode = model.getResponseStatusCode();
        assertEquals(expectedStatusCode, actualStatusCode, "The status code should be 200 OK.");
    }

    @And("The Pet should be removed from the Store")
    public void thePetShouldBeRemovedFromTheStore() {
        FindPetByIdModel findModel = new FindPetByIdModel(petId);
        findModel.sendGetRequest();

        int actualStatusCode = findModel.getResponseStatusCode();
        assertEquals(404, actualStatusCode, "The pet should have been deleted, so the status should be 404.");
    }

    @And("The Pet should remain in the store")
    public void thePetShouldRemainInTheStore() {
        FindPetByIdModel findModel = new FindPetByIdModel(petId);
        findModel.sendGetRequest();

        int actualStatusCode = findModel.getResponseStatusCode();
        assertEquals(200, actualStatusCode, "The pet should still exist in the store, so the status should be 200.");
    }
}
