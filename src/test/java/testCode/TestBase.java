package testCode;

import com.epam.jdi.uitests.web.selenium.elements.composite.WebSite;
import com.epam.jdi.uitests.web.testng.testRunner.TestNGBase;
import com.epam.web.matcher.verify.Verify;
import org.testng.annotations.*;
import pageObjects.pages.TestedEpamSite;
import static com.epam.jdi.uitests.core.settings.JDISettings.logger;
import static com.epam.jdi.uitests.core.settings.JDISettings.useDriver;
import static com.epam.jdi.uitests.web.settings.WebSettings.getDriver;
import static java.lang.System.getProperty;
import static pageObjects.pages.TestedEpamSite.homePage;
import org.testng.annotations.Listeners;
import testCode.testData.CustomTestListener;

@Listeners({CustomTestListener.class})
public class TestBase extends TestNGBase
{
    @BeforeSuite(alwaysRun = true)
    public static void setUp() throws Exception {
        useDriver(getProperty("browser"));
        WebSite.init(TestedEpamSite.class);
        Verify.getFails();
        logger.info("Run Tests");
        homePage.loginForm.moveToState();
    }

    @AfterMethod
    public void getFail() {
        Verify.getFails();
    }

    @AfterSuite(alwaysRun = true)
    public void tearDown()
    {
        getDriver().close();
        getDriver().quit();
    }
}
