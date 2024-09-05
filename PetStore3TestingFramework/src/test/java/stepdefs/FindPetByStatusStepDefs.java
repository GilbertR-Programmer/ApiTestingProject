package stepdefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import models.FindPetsByStatusModel;
import org.junit.jupiter.api.Assertions;
import pojos.StatusItem;

import java.util.List;
import java.util.Map;

public class FindPetByStatusStepDefs {

    private FindPetsByStatusModel findPetsByStatusModel;
    private String status;
    private Response response;

    @Given("that I select {string}")
    public void thatISelect(String status) {
        this.status = status;
        findPetsByStatusModel = new FindPetsByStatusModel();
    }

    @When("getting pets by status")
    public void gettingPetsByStatus() {
        response = findPetsByStatusModel.getPetsByStatus(status);
    }

    @Then("I should see all {string} pets in the store")
    public void iShouldSeeAllPetsInTheStore(String expectedStatus) {
        List<Map<String, Object>> pets = response.jsonPath().getList("");

        boolean allMatch = pets.stream()
                .allMatch(pet -> pet.get("status").equals(expectedStatus));
        Assertions.assertTrue(allMatch, "Not all pets have the expected status.");
    }
}