/**
 * Created by Artsiom_Halavach1 on 12/15/2017.
 */

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.util.Random;



public class CalculatorMultTestDouble extends BaseCalculatorTest {
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
                {1.15, -3.18, -3.657},
                {1.0, 0, 0.0},
                {1.33, 7.5, -9.975},
//                {1.15, 1.5, 2.65}
                 /* ... */
        };
    }

    @Test(dataProvider = "dataProviderAdd")
    public void MultiplyVerivfication(double a, double b, double expected) {
        // When:
        double result = calculator.mult(a, b);
        // Then:
        Assert.assertEquals(result, expected,  0.0000001);
    }


}
