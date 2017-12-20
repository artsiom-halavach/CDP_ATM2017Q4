/**
 * Created by Artsiom_Halavach1 on 12/15/2017.
 */
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.hamcrest.Factory;
import org.junit.*;
import org.junit.runner.RunWith;
import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;


@RunWith(DataProviderRunner.class)
public class CalculatorDivTestDouble extends CalculatorBasicTests {
    private double arg1;
    private double arg2;
    private double expected;

    @Factory
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

    @Test
    @UseDataProvider("dataProviderAdd")
    public void testAdd(double a, double b, double expected) {
        // When:
        double result = calculator.div(a, b);
        // Then:
        Assert.assertEquals(expected, result, 0.000000001);
    }


}
