package testCode;

import com.epam.jdi.uitests.core.settings.JDISettings;
import com.epam.jdi.uitests.web.selenium.elements.composite.WebSite;
import com.epam.jdi.uitests.web.testng.testRunner.TestNGBase;
import com.epam.web.matcher.verify.Verify;
import org.testng.annotations.*;
import pageObjects.pages.TestedEpamSite;

import static com.epam.jdi.uitests.core.settings.JDISettings.driverFactory;
import static com.epam.jdi.uitests.core.settings.JDISettings.logger;
import static pageObjects.pages.TestedEpamSite.homePage;

public class TestBase extends TestNGBase
{
    @BeforeSuite(alwaysRun = true)
    public static void setUp() throws Exception {
        JDISettings.driverFactory.setCurrentDriver(JDISettings.driverFactory.registerDriver(System.getProperty("driver", "Firefox")));
        WebSite.init(TestedEpamSite.class);
        Verify.getFails();
        logger.info("Run Tests");
    }

    @BeforeTest
    public void beforeTest() {
        homePage.isOpened();
        homePage.checkOpened();
        homePage.loginForm.loginFormOpenButton.click();
        homePage.loginForm.submitLogin();
    }

    @AfterMethod
    public void getFail() {
        Verify.getFails();
    }

    @AfterSuite(alwaysRun = true)
    public void tearDown()
    {
        homePage.getDriver().close();
    }
}
