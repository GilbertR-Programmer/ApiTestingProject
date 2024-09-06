package stepdefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import models.ApiModel;
import org.junit.jupiter.api.Assertions;
import utils.SharedData;

public class GenericStepDefs {

    ApiModel apiModel = new ApiModel();

    @Then("I should receive a {int} status code")
    public void iShouldReceiveASuccessfulOperationStatusCode(int expectedStatusCode) {
        Assertions.assertEquals(expectedStatusCode, apiModel.getResponseStatusCode());

    }

    @When("I send the POST request")
    public void iSendThePOSTRequest() {
        apiModel.sendPostRequest();
    }

    @When("I send the GET request")
    public void iSendTheGETRequest() {
        apiModel.sendGetRequest();
    }

    @When("I send the PUT request")
    public void iSendThePUTRequest() {
        apiModel.sendPutRequest();
    }

    @When("I send the DELETE request")
    public void iSendTheDELETERequest() {
        apiModel.sendDeleteRequest();
    }

    @When("I send the PATCH request")
    public void iSendThePATCHRequest() {
        apiModel.sendPatchRequest();
    }
}
