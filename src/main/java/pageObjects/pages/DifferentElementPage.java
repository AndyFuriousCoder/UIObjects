package pageObjects.pages;


import com.epam.jdi.uitests.web.selenium.elements.composite.WebPage;
import org.openqa.selenium.support.FindBy;
import pageObjects.composite.DifferentElementForm;

import static org.junit.Assert.assertTrue;

public class DifferentElementPage extends WebPage
{

    @FindBy(css = ".main-content-hg")
    public DifferentElementForm differentElementForm;

}
