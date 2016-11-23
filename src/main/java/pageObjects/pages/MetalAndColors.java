package pageObjects.pages;


import com.epam.jdi.uitests.web.selenium.elements.common.Button;
import com.epam.jdi.uitests.web.selenium.elements.composite.Pagination;
import com.epam.jdi.uitests.web.selenium.elements.composite.WebPage;
import com.epam.web.matcher.junit.Assert;
import javafx.scene.control.RadioButton;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import pageObjects.MetalAndColorsComponentForm;

public class MetalAndColors extends WebPage
{

    @FindBy(css = "div.main-content")
    public MetalAndColorsComponentForm componentForm;

    @FindBy(css = "ul.uui-pagination")
    public Pagination navigation = new Pagination(By.linkText("8"),
                                                     By.cssSelector("i.fa.fa-long-arrow-right"),
                                                     By.cssSelector("i.fa.fa-long-arrow-left"),
                                                     By.linkText("First"),
                                                     By.linkText("Last"));

    public void checkNext()
    {
        Assert.areEquals(this.getDriver().getTitle(), "Metal and Colors");
    }

    public void checkPrevious()
    {
        Assert.areEquals(this.getDriver().getTitle(), "Different Element");
    }

    public void checkFirst()
    {
        Assert.areEquals(this.getDriver().getTitle(), "Contact Form");
    }

    public  void checkLast()
    {
        Assert.areEquals(this.getDriver().getTitle(), "Metal and Colors");
    }

}
