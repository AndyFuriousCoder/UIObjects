package pageObjects.pages;


import com.epam.jdi.uitests.core.interfaces.common.ICheckBox;
import com.epam.jdi.uitests.web.selenium.elements.complex.Dropdown;
import com.epam.jdi.uitests.web.selenium.elements.complex.RadioButtons;
import com.epam.jdi.uitests.web.selenium.elements.composite.WebPage;
import org.openqa.selenium.support.FindBy;
import pageObjects.DifferentElementForm;
import pageObjects.enums.Metals;

import static org.junit.Assert.assertTrue;

public class DifferentElementPage extends WebPage
{

    @FindBy(css = ".main-content-hg")
    public DifferentElementForm differentElementForm;

}
