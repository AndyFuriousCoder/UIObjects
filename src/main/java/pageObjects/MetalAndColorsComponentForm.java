package pageObjects;


import com.epam.jdi.uitests.web.selenium.elements.common.Button;
import com.epam.jdi.uitests.web.selenium.elements.common.CheckBox;
import com.epam.jdi.uitests.web.selenium.elements.common.TextField;
import com.epam.jdi.uitests.web.selenium.elements.complex.Dropdown;
import com.epam.jdi.uitests.web.selenium.elements.composite.Form;
import com.epam.web.matcher.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import pageObjects.enums.Metals;

public class MetalAndColorsComponentForm extends Form<Plate>
{
    //Odds radiobuttons
    @FindBy (xpath = "//section[@id='odds-selector']/p[1]/label")
    public Button one;

    @FindBy (xpath = "//section[@id='odds-selector']/p[2]/label")
    public Button three;

    @FindBy(xpath = "//section[@id='odds-selector']/p[3]/label")
    public Button five;

    @FindBy(xpath = "//section[@id='odds-selector']/p[4]/label")
    public Button seven;

    //Even radiobuttons
    @FindBy(xpath = "//section[@id='even-selector']/p[1]/label")
    public Button two;

    @FindBy(xpath = "//section[@id='even-selector']/p[2]/label")
    public Button four;

    @FindBy(xpath = "//section[@id='even-selector']/p[3]/label")
    public Button six;

    @FindBy(xpath = "//section[@id='even-selector']/p[4]/label")
    public Button eight;

    //Elements checkboxes
    @FindBy(xpath = "//section[@id='elements-checklist']/p[1]/label")
    public CheckBox water;

    @FindBy(xpath = "//section[@id='elements-checklist']/p[2]/label")
    public CheckBox earth;

    @FindBy(xpath = "//section[@id='elements-checklist']/p[3]/label")
    public CheckBox wind;

    @FindBy(xpath = "//section[@id='elements-checklist']/p[4]/label")
    public CheckBox fire;

    // Dropdown metals
    @FindBy(xpath = "(//button[@type='button'])[2]")
    public Dropdown<Metals> metals;

    @FindBy(css = "div.form-group.metals > button.btn dropdown-toggle selectpicker btn-default firefinder-match")
    public Button metalsButton;

    @FindBy(css = "div.form-group.metals > input[type=\"text\"]")
    public TextField metalsText;

    //Food
    @FindBy(xpath = "(//button[@type='button'])[3]")
    public Button foodOpen;

    //Submit button
    @FindBy (id = "submit-button")
    public Button submit;

    //Methods
    WebDriver driver = this.getDriver();

    public void submit(Plate plate)
    {
        selectOdds(plate.odds);
        selectEven(plate.even);
        selectElement(plate.element);
        selectColor(plate.colorName);
        selectMetal(plate.col);
        selectFood(plate.salad);
        submit.click();
    }

    public void selectOdds(int odds)
    {
        switch (odds)
        {
            case 1: one.click(); break;
            case 3: three.click(); break;
            case 5: five.click(); break;
            case 7: seven.click(); break;
        }
    }

    public void selectEven(int even)
    {
        switch (even)
        {
            case 2: two.click(); break;
            case 4: four.click(); break;
            case 6: six.click(); break;
            case 8: eight.click(); break;
        }
    }

    public void selectElement(String element)
    {
        if (element.equalsIgnoreCase("water")) water.click();
        else{
            if (element.equalsIgnoreCase("earth")) earth.click();
            else{
                if(element.equalsIgnoreCase("wind")) wind.click();
                else{
                    if(element.equalsIgnoreCase("fire")) fire.click();
                }
            }
        }
    }

    public void selectColor(String colorName)
    {
        driver.findElement(By.xpath("//button[@type='button']")).click();
        driver.findElement(By.linkText(colorName)).click();
    }

    public void selectMetal(String metalName)
    {
        metalsText.clear();
        metalsText.input(metalName);
    }

    public void selectFood(String food)
    {
        foodOpen.click();
        if(food.equalsIgnoreCase("cucumber")) driver.findElement(By.xpath("//div[@id='salad-dropdown']/ul/li[1]/a/label")).click();
        if(food.equalsIgnoreCase("tomato")) driver.findElement(By.xpath("//div[@id='salad-dropdown']/ul/li[2]/a/label")).click();
        if(food.equalsIgnoreCase("salad")) driver.findElement(By.xpath("//div[@id='salad-dropdown']/ul/li[3]/a/label")).click();
        if(food.equalsIgnoreCase("onion")) driver.findElement(By.xpath("//div[@id='salad-dropdown']/ul/li[4]/a/label")).click();
    }

    public void checkResult(Plate plate)
    {
        Assert.contains(driver.findElement(By.cssSelector("li.summ-res")).getText(), (plate.odds + plate.even) + "");
        Assert.contains(driver.findElement(By.cssSelector("li.elem-res")).getText(), plate.element);
        Assert.contains(driver.findElement(By.cssSelector("li.col-res")).getText(), plate.colorName);
        Assert.contains(driver.findElement(By.cssSelector("li.met-res")).getText(), plate.col);
        Assert.contains(driver.findElement(By.cssSelector("li.sal-res")).getText(), plate.salad);
    }

}
