package pageObjects.pages;

import com.epam.jdi.uitests.web.selenium.elements.complex.table.Table;
import com.epam.jdi.uitests.web.selenium.elements.composite.WebPage;
import org.openqa.selenium.support.FindBy;

public class SimpleTablePage extends WebPage
{
    @FindBy(css = "table.uui-table.stripe.tbl-without-header.table-td-click")
    public Table simpleTable;

    public void clickOnTableCell()
    {
        simpleTable.cell(2, 2).click();
    }
}
