package testCode;

import com.epam.jdi.uitests.web.selenium.elements.composite.WebSite;
import com.epam.jdi.uitests.web.testng.testRunner.TestNGBase;
import com.epam.web.matcher.verify.Verify;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import pageObjects.pages.TestedEpamSite;
import static com.epam.jdi.uitests.core.settings.JDISettings.logger;
import static pageObjects.pages.TestedEpamSite.homePage;

public class TestBase extends TestNGBase
{
    @BeforeSuite(alwaysRun = true)
    public static void setUp() throws Exception {
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
