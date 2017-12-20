
/**
 * Created by Artsiom_Halavach1 on 12/18/2017.
 */
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.util.Random;


public class CalculatorSinTest extends BaseCalculatorTest {
    private double arg1;
    private double expected;

    @DataProvider
    public static Object[][] dataProviderAdd () {
        double r = new Random().nextDouble();
        double sin  = Math.sin(r);
        return new Object[][]{
                {314.159265, 0},
                {5, -0.95892427},
                {3, 0.14112},
                {0,0},
                {Math.PI/4,0.70710678118},
//                Random element in data provider to avoid Pesticide Paradox
                {r, sin}

//
        };
    }



    @Test(dataProvider = "dataProviderAdd", groups = "simple")
    public void SinVerivfication(double arg1, double expected) {
        // When:
        double result = calculator.sin(arg1);
        // Then:
        Assert.assertEquals(result, expected, 0.001);
    }




}
