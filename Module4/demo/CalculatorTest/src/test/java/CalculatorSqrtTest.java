import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.hamcrest.Factory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(DataProviderRunner.class)
public class CalculatorSqrtTest extends CalculatorBasicTests {
    private double arg1;
    private double expected;

    @Factory
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

    @Test
    @UseDataProvider("dataProviderAdd")
    public void testAdd(double a,  double expected) {
        // When:
        double result = calculator.sqrt(a);
        // Then:
        Assert.assertEquals(expected, result, 0.000000001);
    }

    @Test(expected = Exception.class)
    public void testAddExceptionCase() {
        // When:
        double result = calculator.sqrt(-3.0);
        // Then:
    }
}



