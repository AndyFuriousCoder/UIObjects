package pageObjects.pages;

import com.epam.jdi.uitests.web.selenium.elements.composite.WebPage;
import org.openqa.selenium.support.FindBy;
import pageObjects.composite.DatesPageForm;

public class DatesPage extends WebPage
{
    @FindBy(css = "div.main-content div.main-content-hg")
    public DatesPageForm datesPageForm;
}
