package testCode.testData;

import org.testng.annotations.DataProvider;
import pageObjects.business.DifferentElement;
import pageObjects.enums.Colors;
import pageObjects.enums.Metals;
import pageObjects.enums.NaturalElements;

public class DifferentElementsData
{
    @DataProvider(name = "DifferentElementsTest")
    public static Object[][] test1() {
        return new Object[][] {{new DifferentElement(NaturalElements.Fire, Metals.Bronze, Colors.Blue)},
                                {new DifferentElement(NaturalElements.Water, Metals.Gold, Colors.Green)},
                                {new DifferentElement(NaturalElements.Earth, Metals.Silver, Colors.Yellow)},
                                {new DifferentElement(NaturalElements.Wind, Metals.Selen, Colors.Green)},
                                {new DifferentElement(NaturalElements.Water, Metals.Bronze, Colors.Yellow)}};
    }
}
