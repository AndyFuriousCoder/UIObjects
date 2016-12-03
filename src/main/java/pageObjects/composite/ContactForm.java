package pageObjects.composite;

import com.epam.jdi.uitests.core.interfaces.common.IButton;
import com.epam.jdi.uitests.core.interfaces.common.ITextField;
import com.epam.jdi.uitests.core.interfaces.complex.IRadioButtons;
import com.epam.jdi.uitests.web.selenium.elements.composite.Form;
import org.openqa.selenium.support.FindBy;
import pageObjects.business.Contact;
import pageObjects.enums.Even;
import pageObjects.enums.Odds;

import static pageObjects.pages.TestedEpamSite.contactFormPage;

public class ContactForm extends Form<Contact>
{
    @FindBy(id = "Name")
    public ITextField name;

    @FindBy(id = "LastName")
    public ITextField lastName;

    @FindBy(id = "Description")
    public ITextField description;

    @FindBy(xpath = "//section[1]/p/label")
    public IRadioButtons<Odds> highRowRadioButtons;

    @FindBy(xpath = "//section[2]/p/label")
    public IRadioButtons<Even> lowRowRadioButtons;

    @FindBy(css = "div.text-right.m-t20 > button.uui-button.dark-blue")
    public IButton calculateButton;

    @FindBy(css = "div.col-sm-6.text-right > button.uui-button.dark-blue")
    public IButton submitButton;

    public void inputContactData(Contact contact)
    {
        contactFormPage.isOpened();
        name.newInput(contact.name);
        lastName.newInput(contact.lastName);
        description.newInput(contact.description);
        highRowRadioButtons.select(contact.highRadioButton);
        lowRowRadioButtons.select(contact.lowRadioButton);
        calculateButton.click();
        submitButton.click();
    }
}
