package GUI;

import com.shaft.driver.DriverFactory;

import com.shaft.tools.io.JSONFileManager;
import com.shaft.tools.io.ReportManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestBase {



    @AfterMethod
    public void demolish(){
        DriverFactory.closeAllDrivers();
    }



}
