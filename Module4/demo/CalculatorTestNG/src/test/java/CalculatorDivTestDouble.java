/**
 * Created by Artsiom_Halavach1 on 12/15/2017.
 */

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.util.Random;



public class CalculatorDivTestDouble extends BaseCalculatorTest {
    private double arg1;
    private double arg2;
    private double expected;


    public void CalculatorTest(double arg1, double arg2, double expected) {
        this.arg1 = arg1;
        this.arg2 = arg2;
        this.expected = expected;
    }

    @DataProvider
    public static Object[][] dataProviderAdd() {
        // @formatter:off
        return new Object[][]{
                {7.8, -3.9, -2},
                {1.0, 1.0, 1.0},
                {1, -1.0, -1},
                {1.1, 0, Double.POSITIVE_INFINITY},
//                {1.15, 1.5, 2.65}
                 /* ... */
        };
    }

    @Test(dataProvider = "dataProviderAdd")
    public void DivisionVerivfication(double a, double b, double expected) {
        // When:
        double result = calculator.div(a, b);
        // Then:
        Assert.assertEquals( result, expected,0.000000001);
    }


}
