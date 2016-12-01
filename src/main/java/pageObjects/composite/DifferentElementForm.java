package pageObjects.composite;

import com.epam.jdi.uitests.core.interfaces.common.IButton;
import com.epam.jdi.uitests.core.interfaces.complex.ICheckList;
import com.epam.jdi.uitests.web.selenium.elements.complex.Dropdown;
import com.epam.jdi.uitests.web.selenium.elements.complex.RadioButtons;
import com.epam.jdi.uitests.web.selenium.elements.composite.Form;
import com.epam.web.matcher.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import pageObjects.business.DifferentElement;
import pageObjects.enums.Colors;
import pageObjects.enums.Metals;
import pageObjects.enums.NaturalElements;
import pageObjects.enums.Titles;

public class DifferentElementForm extends Form<DifferentElement>
{

    @FindBy(css = "label.label-checkbox")
    public ICheckList<NaturalElements> checkboxElements;

    @FindBy(css = "label.label-radio")
    public RadioButtons<Metals> metalRadioButtons;

    Dropdown<Colors> colorsDropdown = new Dropdown<>(By.cssSelector(".uui-form-element"), By.cssSelector(".uui-form-element"));

    @FindBy(css = "button[name=\"Default Button\"]")
    public IButton defaultButton;

    @FindBy(css = "input.uui-button")
    public IButton button;

   public void selectDifferentElements(DifferentElement differentElement)
   {
       checkboxElements.select(differentElement.naturalElements);
       metalRadioButtons.select(differentElement.metals);
       colorsDropdown.select(differentElement.colors);
       defaultButton.click();
       button.click();
   }

    public void checkDifferentElementSelection(DifferentElement differentElement)
    {
        try
        {
            Assert.contains(getDriver().findElement(By.xpath("//div[@id='mCSB_2_container']/section/div[2]/div/ul/li[5]")).getText(), differentElement.naturalElements.toString());
        }
        catch(Exception e)
        {
            System.out.println("Verify error on " + Titles.DIFFERENT_ELEMENTS.value + " page: checkbox element " + differentElement.naturalElements);
        }
        try
        {
            Assert.contains(getDriver().findElement(By.xpath("//div[@id='mCSB_2_container']/section/div[2]/div/ul/li[4]")).getText(), differentElement.metals.toString());
        }
        catch(Exception e)
            {
                System.out.println("Verify error on " + Titles.DIFFERENT_ELEMENTS.value + " page: radiobutton element " + differentElement.metals);
            }
        Assert.contains(getDriver().findElement(By.xpath("//div[@id='mCSB_2_container']/section/div[2]/div/ul/li[3]")).getText(), differentElement.colors.toString());
    }

}
