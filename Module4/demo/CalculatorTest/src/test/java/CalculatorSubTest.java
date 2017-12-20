/**
 * Created by Artsiom_Halavach1 on 12/15/2017.
 */
import com.epam.tat.module4.Calculator;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.hamcrest.Factory;
import org.junit.*;
import org.junit.runner.RunWith;
import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;

@RunWith(DataProviderRunner.class)
public class CalculatorSubTest extends CalculatorBasicTests{
    private long arg1;
    private long arg2;
    private long expected;

    @Factory
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
                {1, 1, 0},
                {1, -1, 2},
//                {1.15, 1.5, 2.65}
                 /* ... */
        };
    }

    @Test
    @UseDataProvider("dataProviderAdd")
    public void testAdd(long a, long b, long expected) {
        // When:
        long result = calculator.sub(a,b);
        // Then:
        Assert.assertEquals(expected, result);
    }


}
