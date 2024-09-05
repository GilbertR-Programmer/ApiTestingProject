# Pet Store v3.0 Api Testing Project
### Overview
This project aims to test the functionality of the [Petstore3 API](https://petstore3.swagger.io/), using Cucumber and RestAssured to perform comprehensive coverage of the available endpoints of the API.

## Project Management

    TBD (images of project board/acceptance criteria)

## About This Project

    TBD

## Project Setup

1. <b>Clone this repository onto your local system</b>

2. <b>Set up config.properties</b>
    
    This project comes without a config.properties to avoid sharing sensitive data. This must be set up manually by performing the following steps:

    1. Create a resources folder within the test directory
    2. Create a config.properties file within the resources folder
    3. Populate with the following

        ```properties
        baseUri=<DockerContainerLocation>
        oAuthKey=<YourJWT>
        testString=<testString>
        add other properties here
        ```
        
        \<DockerContainerLocation> will be covered in the next step

        \<YourJWT> replace this with your JSON Web Token for authorized access

    4. Any additional steps


3. <b>Docker setup</b>
    
    This project uses a docker container as the testing environment, in order to access this, please follow the following steps:
    1. Download and install Docker on your machine from [the docker web-page](https://docs.docker.com/desktop/install/windows-install/) (if not already installed)
    2. Open a terminal/shell and run the following command: 

        ```Docker
        docker pull craynersg/petstore-api-test-project:v1.0
        ```
        
        This will pull the image from Docker Hub

    4. Run the following command to run the container: 

        ```Docker
       docker run -p 8080:8080 craynersg/petstore-api-test-project:v1.0
        ```

    6. In your config.properties set `base_uri=http//localhost:8080`

    Following these steps will set up the container to run on your system, allowing for testing of the Petstore3 API in a dedicated test environment. 
    
    If you wish to stop running the docker container run the following commands from your terminal:

    1.  `docker ps` to find all active containers and the ID of the petstore API container
    2.  `docker stop {container-id-or-name}` the container id can be found from the previous step, you do not have to enter the full ID, the first 3-4 numbers should be sufficient.


## Tests Performed

    TBD

## Testing Metrics

    TBD

## Further Assistance

For any further assistance please contact one of the members of the development team. 

<sub align="center">Thank you for choosing to test with SG Pet Store 3 Api Automated Testing© . Your number one solution for testing API's for pet stores (9/10 pet store owners agree)</sub>
