package testCode.testData;


import com.epam.web.matcher.testng.Assert;
import org.openqa.selenium.By;
import pageObjects.business.Contact;
import pageObjects.business.DatesInput;
import pageObjects.business.DifferentElement;
import pageObjects.business.Plate;
import pageObjects.enums.Titles;

import static com.epam.jdi.uitests.web.settings.WebSettings.getDriver;

public class Assertion
{
    public static void checkContactFormResult(Contact contact)
    {
        Assert.contains(getDriver().findElement(By.cssSelector("li.name-res")).getText() , contact.name);
        Assert.contains(getDriver().findElement(By.cssSelector("li.lname-res")).getText(), contact.lastName);
        Assert.contains(getDriver().findElement(By.cssSelector("li.descr-res")).getText(), contact.description);
        Assert.contains(getDriver().findElement(By.cssSelector("li.summ-res")).getText(), (Integer.parseInt(contact.highRadioButton.value) + Integer.parseInt(contact.lowRadioButton.value)) + "");
    }

    public static void checkDifferentElementSelection(DifferentElement differentElement)
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

    public static void checkMetalAndColorsComponentFormResult(Plate plate)
    {
        Assert.contains(getDriver().findElement(By.cssSelector("li.summ-res")).getText(), (Integer.parseInt(plate.odds.value) + Integer.parseInt(plate.even.value)) + "");
        Assert.contains(getDriver().findElement(By.cssSelector("li.elem-res")).getText(), plate.naturalElements.toString());
        Assert.contains(getDriver().findElement(By.cssSelector("li.col-res")).getText(), plate.colors.toString());
        Assert.contains(getDriver().findElement(By.cssSelector("li.met-res")).getText(), plate.metals.toString());
        Assert.contains(getDriver().findElement(By.cssSelector("li.sal-res")).getText(), plate.food.toString());
    }

    public static void checkDatesPageResult(DatesInput datesInput)
    {
        Assert.contains(getDriver().findElement(By.cssSelector("li.name-res")).getText(), datesInput.name);
        Assert.contains(getDriver().findElement(By.cssSelector("li.lname-res")).getText(), datesInput.lastName);
        Assert.contains(getDriver().findElement(By.cssSelector("li.descr-res")).getText(), datesInput.description);
        Assert.contains(getDriver().findElement(By.cssSelector("li.range-res")).getText(), datesInput.firstRange);
        Assert.contains(getDriver().findElement(By.cssSelector("li.range-res")).getText(), datesInput.secondRange);
    }

}
