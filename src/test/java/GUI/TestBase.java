package GUI;

import com.shaft.driver.DriverFactory;

import org.testng.annotations.AfterMethod;

public class TestBase {

    @AfterMethod
    public void demolish(){
        DriverFactory.closeAllDrivers();
    }



}
