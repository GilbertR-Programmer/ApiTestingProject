package stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import models.AddPetModel;
import models.FindPetByTagsModel;
import org.junit.jupiter.api.Assertions;
import pojos.TagsItem;

import java.util.Arrays;

public class FindByTagsStepDefs {

    private FindPetByTagsModel findPetByTagsModel;


    @Given("I have created a find by tags request")
    public void iHaveCreatedAFindByTagsRequest() {
        findPetByTagsModel = new FindPetByTagsModel();
    }

    @Then("I should receive an array of pets with the tag {string}")
    public void iShouldReceiveAnArrayOfPetsWithTheTag(String expectedTag) {
        boolean tagPresentInEveryPet = Arrays.stream(findPetByTagsModel.getPetsFromResponse())
                .allMatch(
                        p -> p.tags().stream().anyMatch(t -> t.name().equals(expectedTag))
                );
        Assertions.assertTrue(tagPresentInEveryPet);
    }


    @Then("I should receive the message {string}")
    public void iShouldReceiveTheMessage(String expectedMessage) {
        String actualMessage = findPetByTagsModel.getResponseMessage();
        Assertions.assertEquals(expectedMessage,actualMessage);
    }

    @Then("I should receive an empty array")
    public void iShouldReceiveAnEmptyArray() {
        Assertions.assertEquals(0,findPetByTagsModel.getPetsFromResponse().length);
    }

    @And("I have added the tag {string} to the parameters")
    public void iHaveAddedTheTagToTheParameters(String tag) {
        findPetByTagsModel.addTagToRequest(tag);
    }

    @When("I add no tags to the parameters")
    public void iAddNoTagsToTheParameters() {
        //nothing needs to be done here
    }
}
