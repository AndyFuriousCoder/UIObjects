package testCode.testData;

import org.testng.annotations.DataProvider;
import pageObjects.enums.TableColumns;

public class CheckingComplexTableData {
    @DataProvider(name = "CheckingComplexTableTest")
    public static Object[][] test1() {
        return new Object[][] {{TableColumns.COLUMN1},
                                {TableColumns.COLUMN2},
                                {TableColumns.COLUMN3}};
    }
}
