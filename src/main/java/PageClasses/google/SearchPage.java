package PageClasses.google;

import com.shaft.gui.browser.BrowserActions;
import com.shaft.gui.element.ElementActions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class SearchPage {
    WebDriver driver;
    private By searchBoxLocator = By.name("q");
    private String pageUrl="https://www.google.com";


    public SearchPage(WebDriver driver) {
        this.driver = driver;
    }
    public void navigateToPage(){
        BrowserActions.navigateToURL(driver,pageUrl);
    }
    /*
    perform a search with given text
    @param
    String searchKeyword : keyword to search for
    */
    public void searchWithString(String searchKeyword){
        ElementActions.type(driver,searchBoxLocator,searchKeyword);
        ElementActions.keyPress(driver,searchBoxLocator,Keys.ENTER);
    }

}
