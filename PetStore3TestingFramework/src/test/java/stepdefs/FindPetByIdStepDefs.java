package stepdefs;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import models.FindPetByIdModel;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import xmltojava.Category;
import xmltojava.FindPetByIdResponse;
import xmltojava.TagsItem;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FindPetByIdStepDefs {
    private Response response;
    private Integer petId;
    private FindPetByIdResponse pet;

    @Given("I have a valid pet ID")
    public void iHaveAValidPetID() {
        petId = 3;
    }

    @When("I make get a request to find pet by id")
    public void iMakeAGETRequestToPetPetId() {
        FindPetByIdModel findPetByIdModel = new FindPetByIdModel(petId);
        findPetByIdModel.sendRequest();
    }

    @Then("I should receive a 200 OK response")
    public void iShouldReceiveAOKResponse() {
        MatcherAssert.assertThat(response.getStatusCode(), Matchers.is(200));
    }

    @And("the pet details should be:")
    public void thePetDetailsShouldBe(DataTable dataTable) {
        XmlMapper xmlMapper = new XmlMapper();
        try {
            pet = xmlMapper.readValue(response.getBody().asString(), FindPetByIdResponse.class);
        } catch (Exception e) {
            throw new AssertionError("Failed to deserialize XML response");
        }

        Map<String, String> data = dataTable.asMaps().getFirst();

        assertEquals(Integer.parseInt(data.get("id")), pet.getId());
        assertEquals(data.get("name"), pet.getName());
        assertEquals(data.get("status"), pet.getStatus());

        Category category = pet.getCategory();
        assertEquals(Integer.parseInt(data.get("categoryId")), category.getId());
        assertEquals(data.get("categoryName"), category.getName());

        TagsItem tag = pet.getTags().getFirst();
        assertEquals(Integer.parseInt(data.get("tagId")), tag.getId());
        assertEquals(data.get("tagName"), tag.getName());

        assertEquals(1, pet.getPhotoUrls().size());
        assertEquals(data.get("photoUrl"), pet.getPhotoUrls().getFirst());
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
