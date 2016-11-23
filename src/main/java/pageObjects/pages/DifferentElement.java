package pageObjects.pages;


import com.epam.jdi.uitests.core.interfaces.common.ICheckBox;
import com.epam.jdi.uitests.web.selenium.elements.complex.Dropdown;
import com.epam.jdi.uitests.web.selenium.elements.complex.RadioButtons;
import com.epam.jdi.uitests.web.selenium.elements.composite.WebPage;
import org.openqa.selenium.support.FindBy;
import pageObjects.Metals;

import static org.junit.Assert.assertTrue;

public class DifferentElement extends WebPage
{

    @FindBy(xpath = "//label[contains(.,'Water')]/input")
    private ICheckBox waterCheckBox;

    @FindBy(xpath = "//label[contains(.,'Earth')]/input")
    private ICheckBox earthCheckBox;

    @FindBy(xpath = "//label[contains(.,'Wind')]/input")
    private ICheckBox windCheckBox;

    @FindBy(xpath = "//label[contains(.,'Fire')]/input")
    private ICheckBox fireCheckBox;

    @FindBy(xpath= "//input[@name='metal']")
    public RadioButtons<Metals> radioButtons;

    public void selectRadioButton()
    {
        radioButtons.select(1);
        radioButtons.select(2);
        radioButtons.select(3);
        radioButtons.select(4);
    }

    @FindBy(css = "select.uui-form-element")
    public Dropdown dropdown;

    public void selectDropdown()
    {
        dropdown.select("Green");
    }

    public void checkingCheckBox(ICheckBox checkBox)
    {
        checkBox.check();
        assertTrue(checkBox.isChecked());
    }

    public void checkingAllCheckboxes()
    {
        checkingCheckBox(waterCheckBox);
        checkingCheckBox(earthCheckBox);
        checkingCheckBox(windCheckBox);
        checkingCheckBox(fireCheckBox);
    }

}
