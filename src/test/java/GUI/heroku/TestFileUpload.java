package GUI.heroku;

import PageClasses.heroku.FileUploadPage;
import com.shaft.driver.DriverFactory;
import com.shaft.validation.Validations;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class TestFileUpload extends HerokuTestBase {
    WebDriver driver;


    @Test
    public void verifySuccessfulUpload(){
        driver= DriverFactory.getDriver();
        FileUploadPage fileUploadPage = new FileUploadPage(driver);
        fileUploadPage.navigateToPage();
        fileUploadPage.FileUpload(jsonImporter.getTestData("FileUpload.fullName"));
        String actualText = fileUploadPage.getUploadedFileName();
        Validations.verifyThat().object(actualText).equals(jsonImporter.getTestData("FileUpload.fileName"));

    }

}
