package pageObjects.pages;

import com.epam.jdi.uitests.web.selenium.elements.composite.WebPage;
import org.openqa.selenium.support.FindBy;
import pageObjects.ComplexTableForm;

public class ComplexTablePage extends WebPage
{
    @FindBy(css = "div.main-content-hg")
    public ComplexTableForm complexPageForm;
}
