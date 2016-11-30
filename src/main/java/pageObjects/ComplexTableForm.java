package pageObjects;

import com.epam.jdi.uitests.web.selenium.elements.common.Button;
import com.epam.jdi.uitests.web.selenium.elements.complex.Dropdown;
import com.epam.jdi.uitests.web.selenium.elements.complex.table.Table;
import com.epam.jdi.uitests.web.selenium.elements.composite.Form;
import com.epam.web.matcher.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import pageObjects.enums.TableColumns;

public class ComplexTableForm extends Form<TableColumns>
{
    @FindBy(css = "table.uui-table.stripe.tbl-scroll.table-delete")
    public Table complexTable;

    public Dropdown columnDropdown = new Dropdown(By.cssSelector("div.btn-group.bootstrap-select.show-tick.uui-form-element.raspberry-color"),
            By.cssSelector("div.dropdown-menu.open ul.dropdown-menu.inner.selectpicker"));

    @FindBy(css = "button.uui-button.dark-blue")
    public Button reestablish;

    @FindBy(xpath = "//button[2]")
    public Button apply;

    public void selectNothingColumns()
    {
        columnDropdown.click();
        columnDropdown.select(TableColumns.COLUMN1.value);
        columnDropdown.select(TableColumns.COLUMN2.value);
        columnDropdown.click();
        apply.click();
    }

    public void selectColumn(TableColumns tableColumns)
    {
        columnDropdown.click();
        columnDropdown.select(tableColumns.value);
        columnDropdown.click();
        apply.click();
    }

    public void checkColumnVisible(TableColumns tableColumns)
    {
        Assert.assertTrue(complexTable.header(tableColumns.value).isDisplayed());
    }
}
