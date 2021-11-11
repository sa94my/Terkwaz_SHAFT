package GUI.google;

import com.shaft.driver.DriverFactory;
import com.shaft.tools.io.JSONFileManager;
import com.shaft.tools.io.ReportManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class GoogleTestBase {
    JSONFileManager jsonImporter ;
    @BeforeClass
    public void set(){
        jsonImporter = new JSONFileManager(System.getProperty("testDataFolderPath")+"googleTestData.json");

    }
    @AfterMethod
    public void demolish(){
        DriverFactory.closeAllDrivers();
    }



}
