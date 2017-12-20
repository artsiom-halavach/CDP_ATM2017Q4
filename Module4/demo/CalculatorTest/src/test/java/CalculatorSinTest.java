import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Random;

/**
 * Created by Artsiom_Halavach1 on 12/18/2017.
 */
@RunWith(DataProviderRunner.class)
public class CalculatorSinTest extends CalculatorBasicTests {
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



    @Test
    @UseDataProvider("dataProviderAdd")
    public void Assertion(double arg1, double expected) {
        // When:
        double result = calculator.sin(arg1);
        // Then:
        Assert.assertEquals(expected, result, 0.001);
    }




}
