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
    private Pet updatedPet;

    @Given("I am using the Petstore API PUT pet method")
    public void iAmUsingThePetstoreApiPutPetMethod() {
        updatePetModel = new UpdatePetModel();
    }

    @And("I have a valid pet ID {int}")
    public void iHaveAValidPetId(int petId) {
    }

    @And("I have a pet ID that exists {int}")
    public void iHaveAPetIdThatExists(int petId) {
    }

    @When("I submit the request")
    public void iSubmitTheRequest() {
        updatedPet = new Pet(
                List.of("string"),
                "doggie",
                10,
                new Category("Dogs", 1),
                List.of(new TagsItem("string", 0)),
                "available"
        );

        updatePetModel.enterPet(updatedPet);
        updatePetModel.sendPutRequest();
    }

    @And("the pet should be updated")
    public void thePetShouldBeUpdated() {
        Pet petInApi = updatePetModel.getUpdatedPet();

        Assertions.assertEquals(updatedPet, petInApi);

        FindPetByIdModel findPetByIdModel = new FindPetByIdModel(String.valueOf(updatedPet.id()));
        findPetByIdModel.sendGetRequest();
        Pet petFromApi = findPetByIdModel.getPetInResponse();
        Assertions.assertEquals(updatedPet, petFromApi);
    }
}