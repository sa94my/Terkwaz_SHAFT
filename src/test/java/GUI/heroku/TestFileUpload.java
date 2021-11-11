package GUI.heroku;

import PageClasses.heroku.FileUploadPage;
import com.shaft.cli.FileActions;
import com.shaft.driver.DriverFactory;
import com.shaft.tools.io.ReportManager;
import com.shaft.validation.Validations;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class TestFileUpload {
    WebDriver driver;
    String file ="src\\test\\resources\\Capture3.PNG";
    String fileName = "Capture3.PNG";
    @Test
    public void verifySuccessfulUpload(){
        driver= DriverFactory.getDriver();
        FileUploadPage fileUploadPage = new FileUploadPage(driver);
        fileUploadPage.navigateToPage();
        fileUploadPage.FileUpload(file);
        String actualText = fileUploadPage.getUploadedFileName();
        Validations.verifyThat().object(actualText).equals(fileName);
    }

}
