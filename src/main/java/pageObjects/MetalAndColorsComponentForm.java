package pageObjects;


import com.epam.jdi.uitests.web.selenium.elements.common.Button;
import com.epam.jdi.uitests.web.selenium.elements.common.CheckBox;
import com.epam.jdi.uitests.web.selenium.elements.complex.Dropdown;
import com.epam.jdi.uitests.web.selenium.elements.composite.Form;
import javafx.scene.control.RadioButton;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class MetalAndColorsComponentForm extends Form<Plate>
{


    @FindBy(id = "p1")
    public RadioButton one;

    @FindBy(id = "p2")
    public RadioButton three;

    @FindBy(id = "p3")
    public RadioButton five;

    @FindBy(id = "p4")
    public RadioButton seven;

    @FindBy(id = "p5")
    public RadioButton two;

    @FindBy(id = "p6")
    public RadioButton four;

    @FindBy(id = "p7")
    public RadioButton six;

    @FindBy(id = "p8")
    public RadioButton eight;

    @FindBy(id = "g1")
    public CheckBox water;

    @FindBy(id = "g2")
    public CheckBox earth;

    @FindBy(id = "g3")
    public CheckBox wind;

    @FindBy(id = "g4")
    public CheckBox fire;

    @FindBy(xpath = "//button[@type='button']")
    public Dropdown<DropdownColorsMenu> colors;

    @FindBy(xpath = "//button[@type='button']")
    public Button dropdownOpen;

    @FindBy(xpath = "(//button[@type='button'])[2]")
    public Dropdown<Metals> metals;

    @FindBy(xpath = "(//button[@type='button'])[2]")
    public Button metalsOpen;

    @FindBy(xpath = "(//button[@type='button'])[3]")
    public Dropdown<Food> food;

    @FindBy(xpath = "(//button[@type='button'])[3]")
    public Button foodOpen;

    @FindBy (id = "submit-button")
    public Button submit;

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
            case 1: one.setSelected(true);
            case 3: three.setSelected(true);
            case 5: five.setSelected(true);
            case 7: seven.setSelected(true);
        }
    }

    public void selectEven(int even)
    {
        switch (even)
        {
            case 2: two.setSelected(true);
            case 4: four.setSelected(true);
            case 6: six.setSelected(true);
            case 8: eight.setSelected(true);
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
        dropdownOpen.click();
        driver.findElement(By.linkText(colorName)).click();
    }

    public void selectMetal(String metalName)
    {
        metalsOpen.click();
        driver.findElement(By.linkText(metalName)).click();
    }

    public void selectFood(String food)
    {
        foodOpen.click();
        if(food.equalsIgnoreCase("cucumber")) driver.findElement(By.id("g5")).click();
        if(food.equalsIgnoreCase("tomato")) driver.findElement(By.id("g6")).click();
        if(food.equalsIgnoreCase("salad")) driver.findElement(By.id("g7")).click();
        if(food.equalsIgnoreCase("onion")) driver.findElement(By.id("g8")).click();
    }

}
