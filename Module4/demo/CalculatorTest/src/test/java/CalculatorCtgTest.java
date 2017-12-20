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
public class CalculatorCtgTest extends CalculatorBasicTests {
    private double arg1;
    private double expected;

    @DataProvider
    public static Object[][] dataProviderAdd () {
        double r = new Random().nextDouble();
        double ctg  = 1/Math.tan(r);
        return new Object[][]{
                {314.159265, 0},
                {5, -3.380515},
                {Math.PI/2, 0},
                {0,Double.POSITIVE_INFINITY},
                {Math.PI/4,1},
                {Math.PI,Double.POSITIVE_INFINITY},
                {Math.PI/4*3,-1},
//                Random element in data provider to avoid Pesticide Paradox
                {r, ctg}

//
        };
    }



    @Test
    @UseDataProvider("dataProviderAdd")
    public void Assertion(double arg1, double expected) {
        // When:
        double result = calculator.ctg(arg1);
        // Then:
        Assert.assertEquals(expected, result, 0.001);
    }




}