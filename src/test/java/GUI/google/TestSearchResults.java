package GUI.google;

import GUI.TestBase;
import PageClasses.google.SearchPage;
import PageClasses.google.SearchResultsPage;
import com.shaft.driver.DriverFactory;
import com.shaft.validation.Validations;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class TestSearchResults extends TestBase {
    WebDriver driver;
    String searchKeyword="selenium webdriver";
    String expectedText="What is Selenium WebDriver?";
    int searchResultIndex=3;

    @Test
    public void verifySearchResults(){
        driver =DriverFactory.getDriver();
        SearchPage searchPage = new SearchPage(driver);
        searchPage.navigateToPage();
        searchPage.searchWithString(searchKeyword);
        SearchResultsPage searchResultsPage = new SearchResultsPage(driver);
        String resultContent = searchResultsPage.getNthResultText(searchResultIndex);
        Validations.assertThat().object(resultContent).equals(expectedText);
        driver.quit();
    }
}
