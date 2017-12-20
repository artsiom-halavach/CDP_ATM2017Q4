import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.hamcrest.Factory;
import org.junit.*;
import org.junit.runner.RunWith;
import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;


/**
 * Created by Artsiom_Halavach1 on 12/19/2017.
 */
@RunWith(DataProviderRunner.class)
public class CalculatorPositiveNumbersTest extends CalculatorBasicTests {

    private long arg1;
    private boolean expected;

    @Factory
    public void CalculatorTest(long arg1, boolean expected) {
        this.arg1 = arg1;
        this.expected = expected;
    }

    @DataProvider
    public static Object[][] dataProviderAdd() {
        // @formatter:off
        return new Object[][]{
                {3, true},
                {0, false},
                {-1, false},
//                {1.3, true},
//                {-1.3, false}


        };
    }

    @Test
    @UseDataProvider("dataProviderAdd")
    public void testAdd(long a, boolean expected) {
        // When:
        boolean result = calculator.isPositive(a);
        // Then:
        Assert.assertEquals(expected, result);
    }


}
