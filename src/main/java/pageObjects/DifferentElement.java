package pageObjects;


import com.epam.jdi.uitests.core.interfaces.common.ICheckBox;
import com.epam.jdi.uitests.web.selenium.elements.composite.WebPage;
import org.openqa.selenium.support.FindBy;

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
