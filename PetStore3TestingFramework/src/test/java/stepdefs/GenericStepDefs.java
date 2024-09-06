package stepdefs;

import io.cucumber.java.en.Then;
import models.ApiModel;
import org.junit.jupiter.api.Assertions;
import utils.SharedData;
import static utils.SharedData.*;

public class GenericStepDefs {

    @Then("I should receive a {int} status code")
    public void iShouldReceiveASuccessfulOperationStatusCode(int expectedStatusCode) {
        Assertions.assertEquals(expectedStatusCode, response.getStatusCode());

    }
}
