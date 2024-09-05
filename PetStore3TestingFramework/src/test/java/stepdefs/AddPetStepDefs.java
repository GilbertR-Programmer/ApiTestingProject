package stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.datatable.DataTable;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import models.AddPetModel;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.Request;
import pojos.AddPet;
import pojos.Category;
import pojos.TagsItem;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @And("I have entered the following information")
    public void iHaveEnteredTheFollowingInformation(DataTable table) {
        List<List<String>> rows = table.asLists(String.class);

        Map<String, String> dataMap = new HashMap<>();

        try {
            for (List<String> row : rows) {
                if (row.size() == 2) {
                    String field = row.get(0).trim();
                    String value = row.get(1).trim();
                    dataMap.put(field, value);
                }
            }
            addPetModel.enterPet(new AddPet(
                    List.of(dataMap.get("photoUrls")),
                    dataMap.get("name"),
                    Integer.parseInt(dataMap.get("id")),
                    new Category(dataMap.get("categoryName"),Integer.parseInt(dataMap.get("categoryId"))),
                    List.of(new TagsItem(dataMap.get("tags"),0)),
                    dataMap.get("status")
            ));
        }
        catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    @When("I send the POST request")
    public void iSendThePOSTRequest() {
        addPetModel.sendRequest();
    }

    @Then("I should receive a {int} status code")
    public void iShouldReceiveASuccessfulOperationStatusCode(int expectedStatusCode) {
        Assertions.assertEquals(expectedStatusCode, addPetModel.getResponseStatusCode());

    }

    @And("the store should contain the new pet")
    public void theStoreShouldContainTheNewPet() {
        //TODO : THIS WILL USE THE SAME CODE AS THE GET ALL PETS ENDPOINT SO ADD IT THEN
    }

    @And("I have not entered Valid information")
    public void iHaveNotEnteredValidInformation() {
        addPetModel.enterInvalidBody("invalid");
    }

    @And("the store should not contain the invalid entry")
    public void theStoreShouldNotContainTheInvalidEntry() {
        //TODO : THIS WILL USE THE SAME CODE AS THE GET ALL PETS ENDPOINT SO ADD IT THEN
    }


}
