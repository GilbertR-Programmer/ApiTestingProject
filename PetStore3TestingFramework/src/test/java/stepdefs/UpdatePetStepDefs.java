package stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import models.UpdatePetModel;
import models.FindPetByIdModel;
import org.junit.jupiter.api.Assertions;
import pojos.Pet;
import pojos.Category;
import pojos.TagsItem;

import java.util.List;

public class UpdatePetStepDefs {

    private UpdatePetModel updatePetModel;
    private Pet petToUpdate;
    private int petId;

    @Given("I am using the Petstore API PUT pet method")
    public void iAmUsingThePetstoreApiPutPetMethod() {
        updatePetModel = new UpdatePetModel();
    }

    @And("I have a valid pet ID {int}")
    public void iHaveAValidPetID(int petId) {
        this.petId = petId;
    }

    @And("I have a pet ID that exists {int}")
    public void iHaveAPetIDThatExists(int petId) {
        FindPetByIdModel findPetByIdModel = new FindPetByIdModel(String.valueOf(petId));
        findPetByIdModel.sendGetRequest();
        Pet petInApi = findPetByIdModel.getPetInResponse();

        Assertions.assertNotNull(petInApi, "Pet with ID " + petId + " does not exist in the store.");
        this.petToUpdate = petInApi;
    }

    @When("I submit the request")
    public void iSubmitTheRequest() {
        Pet updatedPet = new Pet(
                petToUpdate.photoUrls(),
                "Josh",
                petToUpdate.id(),
                petToUpdate.category(),
                petToUpdate.tags(),
                petToUpdate.status()
        );

        updatePetModel.enterUpdatedPet(updatedPet);
        updatePetModel.sendPutRequest();
        System.out.println(updatePetModel.getResponseMessage());
        System.out.println(updatePetModel.getResponseStatusCode());
    }

    @Then("I should receive a {int} status codes")
    public void iShouldReceiveAStatusCode(int expectedStatusCode) {
        Assertions.assertEquals(expectedStatusCode, updatePetModel.getResponseStatusCode(), "Status code mismatch");
    }

    @And("the pet should be updated")
    public void thePetShouldBeUpdated() {
        FindPetByIdModel findPetByIdModel = new FindPetByIdModel(String.valueOf(petId));
        findPetByIdModel.sendGetRequest();
        Pet updatedPetInApi = findPetByIdModel.getPetInResponse();

        Assertions.assertEquals("Josh", updatedPetInApi.name());  // Check that the name is "Josh"
        Assertions.assertEquals(petToUpdate.category().name(), updatedPetInApi.category().name());  // Category remains the same
        Assertions.assertEquals(petToUpdate.status(), updatedPetInApi.status());  // Status remains the same
    }
}
