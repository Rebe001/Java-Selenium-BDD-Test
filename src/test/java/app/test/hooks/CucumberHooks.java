package app.test.hooks;

import com.example.app.webdriver.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class CucumberHooks {

    public static WebDriver driver;
    private static boolean initialized = false;

    @Before
    public void setup() {

        String browser = System.getProperty("browser") == null ? "CHROME" : System.getProperty("browser").toUpperCase();
        int driverWait = System.getProperty("implicitWaitSeconds") == null ? 3 : Integer.parseInt(System.getProperty("implicitWaitSeconds"));
        if (!initialized) {
            driver = DriverFactory.setDriver(browser);
            driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
            driver.manage().timeouts().implicitlyWait(driverWait, TimeUnit.SECONDS);
            Runtime.getRuntime().addShutdownHook(new Thread(new BrowserClosing(driver)));
            initialized = true;
        }
    }

    private class BrowserClosing implements Runnable {
        private WebDriver driver;

        public BrowserClosing(WebDriver driver) {
            this.driver = driver;
        }

        @Override
        public void run() {
            if (driver != null) {
                driver.quit();
            }
        }
    }

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            System.out.println("Scenario failed");
            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
            System.out.println("Screenshot taken and attach in cucumber report");
        }
    }
}
