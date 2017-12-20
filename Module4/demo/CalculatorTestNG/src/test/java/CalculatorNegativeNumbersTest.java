
/**
 * Created by Artsiom_Halavach1 on 12/19/2017.
 */
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.util.Random;


public class CalculatorNegativeNumbersTest extends BaseCalculatorTest {

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
                {3, false},
                {0, false},
                {-1, true},
//                {1.3, true},
//                {-1.3, false}


        };
    }

    @Test(dataProvider = "dataProviderAdd")
    public void isNumberNegativeVerivfication(long a, boolean expected) {
        // When:
        boolean result = calculator.isNegative(a);
        // Then:
        Assert.assertEquals(result, expected);
    }


}
