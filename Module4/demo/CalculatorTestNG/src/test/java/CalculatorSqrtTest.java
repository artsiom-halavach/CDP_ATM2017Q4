import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.util.Random;


public class CalculatorSqrtTest extends BaseCalculatorTest {
    private double arg1;
    private double expected;


    public void CalculatorTest(double arg1, double expected) {
        this.arg1 = arg1;
        this.expected = expected;
    }

    @DataProvider
    public static Object[][] dataProviderAdd() {
        // @formatter:off
        return new Object[][]{
                {0.83385935904053470850862650912529,  0.913158},
                {1.0, 1.0},
                {0,0},
                {144, 12},
//                {-1, Math.sqrt(-1)}
                 /* ... */
        };
    }

    @Test(dataProvider = "dataProviderAdd")
    public void SquareRootVerivfication(double a,  double expected) {
        // When:
        double result = calculator.sqrt(a);
        // Then:
        Assert.assertEquals(result, expected, 0.000000001);
    }

    @Test(expectedExceptions = NumberFormatException.class, expectedExceptionsMessageRegExp = ".*Attempt.*")
    public void testAddExceptionCase() {
        // When:
        double result = calculator.sqrt(-3.0);
        // Then:
    }
}



