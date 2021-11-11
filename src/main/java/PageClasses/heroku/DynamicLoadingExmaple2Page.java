package PageClasses.heroku;

import com.shaft.gui.browser.BrowserActions;
import com.shaft.gui.element.ElementActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DynamicLoadingExmaple2Page {
    WebDriver driver;
    private By startBtnLocator = By.tagName("button");
    private By loadingElementLocator = By.id("finish");
    private String pageUrl = "https://the-internet.herokuapp.com/dynamic_loading/2";

    public DynamicLoadingExmaple2Page(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateToPage(){
        BrowserActions.navigateToURL(driver,pageUrl);
    }

        /*
    clicks on the start button
    Behaviour : the WebElement takes some undefined time to load
    no need to introduce wait as shaft already does so
    */
    public void startLoadingElement(){
        ElementActions.click(driver,startBtnLocator);
    }

    public String getElementText(){

        return  ElementActions.getText(driver,loadingElementLocator);
    }
}
