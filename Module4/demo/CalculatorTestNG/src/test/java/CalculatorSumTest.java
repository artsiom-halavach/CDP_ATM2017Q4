/**
 * Created by Artsiom_Halavach1 on 12/15/2017.
 */

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.util.Random;


public class CalculatorSumTest extends BaseCalculatorTest{
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
                {0, 0, 0},
                {1, 1, 2},
                {1, -13, -12},
                {-10, 15, 5},


                //                {1.15, 1.5, 2.65}
                 /* ... */
        };
    }

    @Test(dataProvider = "dataProviderAdd")
    public void SummaryVerivfication(long a, long b, long expected) {
        // When:
        long result = calculator.sum(a,b);
        // Then:
        Assert.assertEquals(result, expected);
    }




}
