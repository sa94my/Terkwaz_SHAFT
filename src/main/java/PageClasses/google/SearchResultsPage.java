package PageClasses.google;

import com.shaft.gui.element.ElementActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchResultsPage {
    WebDriver driver;
    // locator to search results excluding "people also search for" results
    //reconsider this locator
    private String searchResultsContainers = "(//div[@class='tF2Cxc'][.//div[contains(@class,'VwiC3b ')]])";

    public SearchResultsPage(WebDriver driver) {
        this.driver = driver;
    }

    // get the textual content of a given search result
    public String getNthResultText(int resultIndex){
        return ElementActions.getText(driver,getXpathForNthSearchResult(resultIndex));
    }
    /*
    for internal use
    to allow for dynamic selection of search results
     */
    private By getXpathForNthSearchResult(int resultIndex){
        /*
            TODO
            error handling if input exceeds number of search results
         */
        return By.xpath(searchResultsContainers+"["+resultIndex+"]");
    }
}
