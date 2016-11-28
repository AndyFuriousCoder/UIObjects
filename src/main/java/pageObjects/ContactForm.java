package pageObjects;

import com.epam.jdi.uitests.core.interfaces.common.IButton;
import com.epam.jdi.uitests.core.interfaces.common.ITextField;
import com.epam.jdi.uitests.core.interfaces.complex.IRadioButtons;
import com.epam.jdi.uitests.web.selenium.elements.composite.Form;
import com.epam.web.matcher.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import pageObjects.enums.Even;
import pageObjects.enums.Odds;

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
        name.input(contact.name);
        lastName.input(contact.lastName);
        description.input(contact.description);
        highRowRadioButtons.select(contact.highRadioButton);
        lowRowRadioButtons.select(contact.lowRadioButton);
        calculateButton.click();
        submitButton.click();
    }

    public void checkResult(Contact contact)
    {
        Assert.contains(getDriver().findElement(By.cssSelector("li.name-res")).getText() , contact.name);
        Assert.contains(getDriver().findElement(By.cssSelector("li.lname-res")).getText(), contact.lastName);
        Assert.contains(getDriver().findElement(By.cssSelector("li.descr-res")).getText(), contact.description);
        Assert.contains(getDriver().findElement(By.cssSelector("li.summ-res")).getText(), (Integer.parseInt(contact.highRadioButton.value) + Integer.parseInt(contact.lowRadioButton.value)) + "");
    }

}
