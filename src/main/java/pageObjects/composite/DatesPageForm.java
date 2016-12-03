package pageObjects.composite;

import com.epam.jdi.uitests.core.interfaces.common.IButton;
import com.epam.jdi.uitests.core.interfaces.common.ITextField;
import com.epam.jdi.uitests.web.selenium.elements.composite.Form;
import org.openqa.selenium.support.FindBy;
import pageObjects.business.DatesInput;

import static pageObjects.pages.TestedEpamSite.datesPage;

public class DatesPageForm extends Form<DatesInput>
{
    @FindBy(id = "Name")
    public ITextField name;

    @FindBy(id="LastName")
    public ITextField lastName;

    @FindBy(id="Description")
    public ITextField description;

    @FindBy(xpath = "(//input[@type='text'])[7]")
    public ITextField firstRangeFirstValue;

    @FindBy(xpath = "(//input[@type='text'])[8]")
    public ITextField firstRangeSecondValue;

    @FindBy(xpath = "(//button[@type='submit'])[3]")
    public IButton submit;

    public void inputDataOnPage(DatesInput datesInput)
    {
        datesPage.isOpened();
        name.newInput(datesInput.name);
        lastName.newInput(datesInput.lastName);
        description.newInput(datesInput.description);
        firstRangeFirstValue.newInput(datesInput.firstRange);
        firstRangeSecondValue.newInput(datesInput.secondRange);
        submit.click();
    }
}
