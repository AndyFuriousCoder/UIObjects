package pageObjects.pages;


import com.epam.jdi.uitests.web.selenium.elements.composite.Pagination;
import com.epam.jdi.uitests.web.selenium.elements.composite.WebPage;
import com.epam.web.matcher.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import pageObjects.MetalAndColorsComponentForm;
import pageObjects.enums.Titles;

public class MetalAndColorsPage extends WebPage
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
        Assert.areEquals(MetalAndColorsPage.getTitle(), Titles.METALS_COLORS.value);
    }

    public void checkPrevious()
    {
        Assert.areEquals(DifferentElementPage.getTitle(), Titles.DIFFERENT_ELEMENTS.value);
    }

    public void checkFirst()
    {
        Assert.areEquals(ContactFormPage.getTitle(), Titles.CONTACT_FORM.value);
    }

    public  void checkLast()
    {
        Assert.areEquals(MetalAndColorsPage.getTitle(), Titles.METALS_COLORS.value);
    }

}
