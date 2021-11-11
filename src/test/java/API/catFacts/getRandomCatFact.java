package API.catFacts;

import com.shaft.api.RestActions;
import com.shaft.driver.DriverFactory;
import com.shaft.tools.io.JSONFileManager;
import com.shaft.validation.Validations;
import io.restassured.response.Response;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class getRandomCatFact {
    JSONFileManager jsonReader;
    @BeforeClass
    public void setup(){
        jsonReader= new JSONFileManager(System.getProperty("testDataFolderPath")+"catFacts.json");
    }
    @Test
    public void verifyRandomCatFact(){
        Response response = DriverFactory.getAPIDriver(jsonReader.getTestData("baseUrl"))
                .buildNewRequest(jsonReader.getTestData("randomFact.endPoint"), RestActions.RequestType.GET)
                .performRequest();
        Validations.verifyThat().response(response).extractedJsonValue("text").isNotNull();
        Validations.verifyThat().response(response).extractedJsonValue("text").doesNotEqual("");
    }

    @AfterMethod
    public void tearDown(){
        DriverFactory.closeAllDrivers();
    }
}
