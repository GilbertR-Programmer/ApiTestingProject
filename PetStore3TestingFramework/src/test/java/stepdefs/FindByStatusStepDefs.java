package stepdefs;


import config.AppConfig;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class FindByStatusStepDefs {

    private Response response;

    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = AppConfig.getBaseUri();
    }

    @Given("that I select available")
    public void thatISelectAvailable() {

    }

    @When("getting pets by status")
    public void gettingPetsByStatus() {
        response = RestAssured
                .given()
                .queryParam("status", "available")
                .when()
                .get("/pet/findByStatus")
                .then()
                .extract()
                .response();
    }

    @Then("I should see all available pets in the store")
    public void iShouldSeeAllAvailablePetsInTheStore() {
        assertThat(response.getStatusCode(), is(200));
        assertThat(response.jsonPath().getList("status"), everyItem(equalTo("available")));
    }
}