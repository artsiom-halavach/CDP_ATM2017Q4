import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.hamcrest.Factory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(DataProviderRunner.class)
    public class CalculatorPowerTest extends CalculatorBasicTests {
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
                    {1.15, -1.3, 0.83385935904053470850862650912529},
                    {1.0, 1.0, 1.0},
                    {2, -1, 0.5},
                {-1.15, 2.8, 2.65}
                 /* ... */
            };
        }

        @Test
        @UseDataProvider("dataProviderAdd")
        public void testAdd(double a, double b, double expected) {
            // When:
            double result = calculator.pow(a, b);
            // Then:
            Assert.assertEquals(expected, result, 0.000000001);
        }


}



