package GUI.heroku;

import com.shaft.driver.DriverFactory;
import com.shaft.tools.io.JSONFileManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

public class HerokuTestBase {

    JSONFileManager jsonImporter ;
    @BeforeClass
    public void set(){
        jsonImporter = new JSONFileManager(System.getProperty("testDataFolderPath")+"HerokuTestData.json");

    }
    @AfterMethod
    public void demolish(){
        DriverFactory.closeAllDrivers();
    }



}
