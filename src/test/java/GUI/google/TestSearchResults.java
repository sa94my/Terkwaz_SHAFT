package GUI.google;

import GUI.TestBase;
import PageClasses.google.SearchPage;
import PageClasses.google.SearchResultsPage;
import com.shaft.driver.DriverFactory;
import com.shaft.tools.io.JSONFileManager;
import com.shaft.validation.Validations;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestSearchResults  extends GoogleTestBase{
    WebDriver driver;

    @Test
    public void verifySearchResults(){
        driver =DriverFactory.getDriver();
        SearchPage searchPage = new SearchPage(driver);
        searchPage.navigateToPage();
        searchPage.searchWithString(jsonImporter.getTestData("searchResult.keyword"));
        SearchResultsPage searchResultsPage = new SearchResultsPage(driver);
        String resultContent = searchResultsPage.getNthResultText(Integer.parseInt(jsonImporter.getTestData("searchResult.resultIndex")));
        Validations.verifyThat().object(resultContent).equals(jsonImporter.getTestData("searchResult.expectedResult"));
    }
}
