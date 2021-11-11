package GUI.heroku;

import PageClasses.heroku.DynamicLoadingExmaple2Page;
import com.shaft.driver.DriverFactory;
import com.shaft.validation.Validations;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class testDynamicLoading {
    WebDriver driver;
    String expectedText ="Hello World!";
    @Test
    public void verifyDynamicLoadingWorks(){
        driver = DriverFactory.getDriver();
        DynamicLoadingExmaple2Page dynamicLoadingExmaple2Page = new DynamicLoadingExmaple2Page(driver);
        dynamicLoadingExmaple2Page.navigateToPage();
        dynamicLoadingExmaple2Page.startLoadingElement();
        String actualText = dynamicLoadingExmaple2Page.getElementText();
        Validations.verifyThat().object(actualText).equals(expectedText);

    }
}
