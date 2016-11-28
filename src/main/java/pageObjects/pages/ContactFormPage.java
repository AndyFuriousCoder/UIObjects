package pageObjects.pages;


import com.epam.jdi.uitests.web.selenium.elements.composite.Pagination;
import com.epam.jdi.uitests.web.selenium.elements.composite.WebPage;
import com.epam.web.matcher.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import pageObjects.ContactForm;
import pageObjects.enums.Titles;

public class ContactFormPage extends WebPage
{

    @FindBy(css = "div.main-content-hg")
    public ContactForm contactForm;

    @FindBy(css = "ul.uui-pagination")
    public Pagination navigation = new Pagination(By.linkText("1"),
                                                    By.cssSelector("i.fa.fa-long-arrow-right"),
                                                    By.cssSelector("i.fa.fa-long-arrow-left"),
                                                    By.linkText("First"),
                                                    By.linkText("Last"));

    public void checkFirst()
    {
        Assert.areEquals(getTitle(), Titles.CONTACT_FORM.value);
    }
}
