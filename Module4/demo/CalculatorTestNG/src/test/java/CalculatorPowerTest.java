import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Random;


public class CalculatorPowerTest extends BaseCalculatorTest {
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
                {1.15, -1.3, 0.83385935904053470850862650912529},
                {1.0, 1.0, 1.0},
                {2, -1, 0.5},
                {4,3,64},
                {2,1.5, 2.8284271}
                 /* ... */
        };
    }

    @Test(dataProvider = "dataProviderAdd")
    public void PowerVerivfication(double a, double b, double expected) {
        // When:
        double result = calculator.pow(a, b);
        // Then:
        Assert.assertEquals(result, expected, 0.000000001);
    }


}



