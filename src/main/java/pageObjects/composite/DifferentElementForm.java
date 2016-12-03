package pageObjects.composite;

import com.epam.jdi.uitests.core.interfaces.common.IButton;
import com.epam.jdi.uitests.core.interfaces.complex.ICheckList;
import com.epam.jdi.uitests.web.selenium.elements.complex.Dropdown;
import com.epam.jdi.uitests.web.selenium.elements.complex.RadioButtons;
import com.epam.jdi.uitests.web.selenium.elements.composite.Form;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import pageObjects.business.DifferentElement;
import pageObjects.enums.Colors;
import pageObjects.enums.Metals;
import pageObjects.enums.NaturalElements;

import static pageObjects.pages.TestedEpamSite.differentElementPage;

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
       differentElementPage.isOpened();
       checkboxElements.select(differentElement.naturalElements);
       metalRadioButtons.select(differentElement.metals);
       colorsDropdown.select(differentElement.colors);
       defaultButton.click();
       button.click();
   }
}
