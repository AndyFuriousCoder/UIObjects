package testCode.testData;


import org.testng.annotations.DataProvider;
import pageObjects.business.Plate;
import pageObjects.enums.*;


public class MetalAndColorsData
{
    @DataProvider(name = "MetalAndColorsTest")
    public static Object[][] test1() {
        return new Object[][] {{new Plate(Odds.FIVE, Even.EIGHT, NaturalElements.Fire, Colors.Blue, Metals.Gold, Food.Cucumber)},
                                {new Plate(Odds.ONE, Even.SIX, NaturalElements.Water, Colors.Green, Metals.Silver, Food.Tomato)},
                                {new Plate(Odds.THREE, Even.TWO, NaturalElements.Earth, Colors.Yellow, Metals.Bronze, Food.Onion)},
                                {new Plate(Odds.SEVEN, Even.FOUR, NaturalElements.Wind, Colors.Red, Metals.Selen, Food.Cucumber)},
                                {new Plate(Odds.FIVE, Even.SIX, NaturalElements.Water, Colors.Blue, Metals.Gold, Food.Tomato)},};
    }
}
