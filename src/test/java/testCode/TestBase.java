package testCode;

import com.epam.jdi.uitests.web.selenium.elements.composite.WebSite;
import com.epam.jdi.uitests.web.testng.testRunner.TestNGBase;
import com.epam.web.matcher.verify.Verify;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import pageObjects.pages.TestingEpamSite;

import static com.epam.jdi.uitests.core.settings.JDISettings.logger;
import static com.epam.jdi.uitests.web.selenium.driver.WebDriverUtils.killAllRunWebDrivers;
import static pageObjects.pages.TestingEpamSite.homePage;

public class TestBase extends TestNGBase
{

    public static WebDriver driver = new ChromeDriver();
    @BeforeSuite(alwaysRun = true)
    public static void setUp() throws Exception {
        WebSite.init(TestingEpamSite.class);
        Verify.getFails();
        logger.info("Run Tests");
    }

    @AfterMethod
    public void getFail() {
        Verify.getFails();
    }

    @AfterSuite(alwaysRun = true)
    public void tearDown()
    {
        killAllRunWebDrivers();
        //homePage.getDriver().close();
    }
}
