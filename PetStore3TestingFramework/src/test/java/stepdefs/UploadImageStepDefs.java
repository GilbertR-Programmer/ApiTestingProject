package stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import models.UploadImageModel;
import org.junit.jupiter.api.Assertions;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class UploadImageStepDefs {

    private UploadImageModel uploadImageModel;

    @Given("I have created an upload image request")
    public void iHaveCreatedAnUploadImageRequest() {
        uploadImageModel = new UploadImageModel();
    }

    @And("I have added the id {int} to the parameters")
    public void iHaveAddedTheIdToTheParameters(int id) {
        uploadImageModel.enterId(id);
    }

    @And("I have added an image to the body")
    public void iHaveAddedAnImageToTheBody() throws IOException {
        // Path to the image file
        File imageFile = new File("C:/Users/grr12/ApiTestingProject/PetStore3TestingFramework/src/test/resources/imageOfDog.jpeg");

        // Read the image file into a byte array
        byte[] imageBytes = Files.readAllBytes(imageFile.toPath());

        uploadImageModel.addImageToBody(imageBytes);
    }

    @And("The Image should be in the pet")
    public void theImageShouldBeInThePet() {
        Assertions.fail();
    }

    @And("I have added the id {string} to the parameters")
    public void iHaveAddedTheIdToTheParameters(String id) {
        uploadImageModel.enterId(id);
    }
}
