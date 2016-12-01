package pageObjects.composite;

import com.epam.jdi.uitests.core.interfaces.common.IButton;
import com.epam.jdi.uitests.core.interfaces.common.ITextField;
import com.epam.jdi.uitests.web.selenium.elements.composite.Form;
import com.epam.web.matcher.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import pageObjects.business.DatesInput;

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

    //@FindBy(css = ".ui-state-default.ui-corner-all")
    //public List<WebElement> secondRange;

    @FindBy(xpath = "(//button[@type='submit'])[3]")
    public IButton submit;

    public void inputDataOnPage(DatesInput datesInput)
    {
        name.input(datesInput.name);
        lastName.input(datesInput.lastName);
        description.input(datesInput.description);
        firstRangeFirstValue.input(datesInput.firstRange);
        firstRangeSecondValue.input(datesInput.secondRange);
        submit.click();
    }

    public void checkResult(DatesInput datesInput)
    {
        Assert.contains(getDriver().findElement(By.cssSelector("li.name-res")).getText(), datesInput.name);
        Assert.contains(getDriver().findElement(By.cssSelector("li.lname-res")).getText(), datesInput.lastName);
        Assert.contains(getDriver().findElement(By.cssSelector("li.descr-res")).getText(), datesInput.description);
        Assert.contains(getDriver().findElement(By.cssSelector("li.range-res")).getText(), datesInput.firstRange);
        Assert.contains(getDriver().findElement(By.cssSelector("li.range-res")).getText(), datesInput.secondRange);
    }

}
