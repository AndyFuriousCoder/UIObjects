package testCode;


import org.testng.annotations.DataProvider;
import pageObjects.Plate;


public class MetalAndColorsData
{
    @DataProvider(name = "MetalAndColorsTest")
    public static Object[][] test1() {
        return new Object[][] {{new Plate(3, 4, "fire", "blue", "gold", "cucumber")},
                                {new Plate(5, 2, "water", "yellow", "selen", "onion")}};
    }
}
