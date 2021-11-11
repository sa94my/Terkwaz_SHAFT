package PageClasses.heroku;

import com.shaft.cli.FileActions;
import com.shaft.gui.browser.BrowserActions;
import com.shaft.gui.element.ElementActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FileUploadPage {
    private WebDriver driver;
    private String pageUrl ="https://the-internet.herokuapp.com/upload";
    private By uploadBtnLocator = By.id("file-upload");
    private By submitBtnLocator = By.id("file-submit");
    private By fileNameContainer =  By.id("uploaded-files");

    public FileUploadPage(WebDriver driver) {
        this.driver = driver;
    }
    public void navigateToPage(){
        BrowserActions.navigateToURL(driver,pageUrl);
    }
    /*
    Upload file
    @param
    String relativePathToFile : full qualified name of the file from project home (filePath/filename.extension)
     */
    public void FileUpload(String relativePathToFile){
        ElementActions.typeFileLocationForUpload(driver,uploadBtnLocator, FileActions.getAbsolutePath(relativePathToFile) );
       ElementActions.click(driver,submitBtnLocator);

    }

    public String getUploadedFileName(){
        return ElementActions.getText(driver, fileNameContainer );
    }

}
