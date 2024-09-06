package stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.datatable.DataTable;
import models.AddPetModel;
import models.FindPetByIdModel;
import org.junit.jupiter.api.Assertions;
import pojos.Pet;
import pojos.Category;
import pojos.TagsItem;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AddPetStepDefs {

    private AddPetModel addPetModel;

    @Given("I have created an add pet request")
    public void iHaveCreatedAPostRequest() {
        addPetModel = new AddPetModel();
    }

    @And("I have entered Valid information")
    public void iHaveEnteredValidInformation() {
        addPetModel.enterPet(new Pet(
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
            addPetModel.enterPet(new Pet(
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

    @And("the store should contain the new pet")
    public void theStoreShouldContainTheNewPet() {
        Pet petAdded = addPetModel.getAddedPet();
        FindPetByIdModel findPetByIdModel = new FindPetByIdModel(petAdded.id());
        findPetByIdModel.sendRequest();
        Pet petInApi = findPetByIdModel.getPetInResponse();
        Assertions.assertEquals(petInApi, petAdded);
    }

    @And("I have not entered Valid information")
    public void iHaveNotEnteredValidInformation() {
        addPetModel.enterInvalidBody("invalid");
    }

}
