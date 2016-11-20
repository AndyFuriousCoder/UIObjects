package pageObjects;


import com.epam.jdi.uitests.web.selenium.elements.composite.Pagination;
import com.epam.jdi.uitests.web.selenium.elements.composite.WebPage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

public class MetalAndColors extends WebPage
{

    @FindBy(css = "div.main-content")
    public MetalAndColorsComponentForm componentForm;

    @FindBy(css = "ul.uui-pagination")
    public Pagination navigation = new Pagination(By.linkText("8"), By.cssSelector("i.fa.fa-long-arrow-right"), By.cssSelector("i.fa.fa-long-arrow-left"), By.linkText("First"), By.linkText("Last"));

}
