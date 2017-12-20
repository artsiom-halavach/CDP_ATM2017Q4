/**
 * Created by Artsiom_Halavach1 on 12/15/2017.
 */

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class CalculatorDivTest extends BaseCalculatorTest {
    private long arg1;
    private long arg2;
    private long expected;


    public void CalculatorTest(long arg1, long arg2, long expected) {
        this.arg1 = arg1;
        this.arg2 = arg2;
        this.expected = expected;
    }

    @DataProvider
    public static Object[][] dataProviderAdd() {
        // @formatter:off
        return new Object[][]{
                {8, 2, 4},
                {5, 1, 5},
                {3, -1, -3},
                {-12, -3, 4},
        };
    }

    @Test(dataProvider = "dataProviderAdd")
    public void DivisionVerivfication(long a, long b, long expected) {
        // When:
        long result = calculator.div(a, b);
        // Then:
        Assert.assertEquals( result, expected);
    }

    @Test(expectedExceptions = NumberFormatException.class, expectedExceptionsMessageRegExp = ".*Attempt.*")
    public void DivisionByZeroVerivfication() {
        // When:
        long result = calculator.div(3, 0);
        // Then:
        Assert.assertEquals( result, expected);
    }


}