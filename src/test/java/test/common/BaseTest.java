package test.common;

import org.example.driver.DriverManager;
import org.example.driver.TargetFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import java.util.Set;

@Listeners({TestResultLogger.class})
public class BaseTest {

    @BeforeMethod(alwaysRun = true)
    @Parameters("browser")
    public void preCondition(@Optional("chrome") String browser) {
        WebDriver driver = new TargetFactory().createInstance(browser);
        DriverManager.setDriver(driver);

        DriverManager.getDriver().get("https://www.hepsiburada.com");
        DriverManager.setMaximizeWindow();
    }

    public void anotherWindow() {
        Set<String> windowAllWindows = DriverManager.getDriver().getWindowHandles();
        for (String window : windowAllWindows) {
            DriverManager.getDriver().switchTo().window(window);
        }
    }

    @AfterMethod(alwaysRun = true)
    public void postCondition() {
        DriverManager.quit();
    }
}
