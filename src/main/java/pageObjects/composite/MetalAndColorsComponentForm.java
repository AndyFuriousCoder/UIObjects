package pageObjects.composite;


import com.epam.jdi.uitests.web.selenium.elements.common.Button;
import com.epam.jdi.uitests.web.selenium.elements.complex.CheckList;
import com.epam.jdi.uitests.web.selenium.elements.complex.Dropdown;
import com.epam.jdi.uitests.web.selenium.elements.complex.RadioButtons;
import com.epam.jdi.uitests.web.selenium.elements.composite.Form;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import pageObjects.business.Plate;
import pageObjects.enums.*;

import static pageObjects.pages.TestedEpamSite.metalAndColorsPage;

public class MetalAndColorsComponentForm extends Form<Plate>
{

    @FindBy(css = "div.info-panel-section section#odds-selector.horizontal-group p.radio label")
    public RadioButtons<Odds> odds;

    @FindBy(css = "div.info-panel-section section#even-selector.horizontal-group p.radio label")
    public RadioButtons<Even> even;

    @FindBy(css = "div.info-panel-section section#elements-checklist.vertical-group p.checkbox label")
    public CheckList<NaturalElements> naturalElements;

    public Dropdown<Colors> colors = new Dropdown<>
            (By.cssSelector("div.form-group.colors div.btn-group.bootstrap-select.uui-form-element button.btn.dropdown-toggle.selectpicker.btn-default"),
                    By.cssSelector("div.form-group.colors div.btn-group.bootstrap-select.uui-form-element.open div.dropdown-menu.open ul.dropdown-menu.inner.selectpicker li"));

    public Dropdown<Metals> metals = new Dropdown<>
            (By.cssSelector("div.form-group.metals div.btn-group.bootstrap-select.uui-form-element button.btn.dropdown-toggle.selectpicker.btn-default span.caret"),
                    By.cssSelector("div.form-group.metals div.btn-group.bootstrap-select.uui-form-element.open div.dropdown-menu.open ul.dropdown-menu.inner.selectpicker li"));

    public Dropdown<Food> food = new Dropdown<>(By.xpath("(//button[@type='button'])[3]"),
            By.cssSelector("div#salad-dropdown.dropdown.salad ul.dropdown-menu li"));

    @FindBy (id = "submit-button")
    public Button submit;


    public void selectElements(Plate plate)
    {
        metalAndColorsPage.open();
        odds.select(plate.odds);
        even.select(plate.even);
        naturalElements.select(plate.naturalElements);
        colors.click();
        colors.select(plate.colors);
        metals.click();
        metals.select(plate.metals);
        food.click();
        food.select(plate.food);
        submit.click();
    }
}
