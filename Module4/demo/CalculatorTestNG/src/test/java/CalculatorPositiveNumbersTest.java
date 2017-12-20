
/**
 * Created by Artsiom_Halavach1 on 12/19/2017.
 */
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.util.Random;


public class CalculatorPositiveNumbersTest extends BaseCalculatorTest {

    private long arg1;
    private boolean expected;

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

    @Test(dataProvider = "dataProviderAdd")
    public void isNumberPositiveVerivfication(long a, boolean expected) {
        // When:
        boolean result = calculator.isPositive(a);
        // Then:
        Assert.assertEquals(result, expected);
    }


}
