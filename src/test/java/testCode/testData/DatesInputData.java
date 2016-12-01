package testCode.testData;


import org.testng.annotations.DataProvider;
import pageObjects.business.DatesInput;

public class DatesInputData
{
    @DataProvider(name = "DatesPageTest")
    public static Object[][] test1() {
        return new Object[][] {{new DatesInput("Antonio", "Banderas", "Artist", "25", "50")},
                                {new DatesInput("Mark", "Twen", "Writer", "26", "98")},
                                {new DatesInput("Alexander", "Pushkin", "Poet", "15", "33")},
                                {new DatesInput("Ivan", "The Terrible", "Tsar", "2", "70")},
                                {new DatesInput("Axl", "Rose", "Singer", "14", "65")}};
    }
}
