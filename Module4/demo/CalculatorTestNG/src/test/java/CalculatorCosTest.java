

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.util.Random;

/**
 * Created by Artsiom_Halavach1 on 12/18/2017.
 */


public class CalculatorCosTest extends BaseCalculatorTest {
    private double arg1;
    private double expected;
    String s = this.getClass().getName();


    @DataProvider
    public static Object[][] dataToTestCos () {
        double r = new Random().nextDouble();
        double cos  = Math.cos(r);
        return new Object[][]{
                {314.159265, 1},
                {5, 0.996194698091},
                {3, -0.989992496},
                {0,1},
                {Math.PI/4,0.70710678118},
//                Random element in data provider to avoid Pesticide Paradox
                {r, cos}

//
        };
    }


    @Test(dataProvider = "dataToTestCos",groups = "simple")
    public void CosVerivfication(double arg1, double expected) {
        // When:
        double result = calculator.cos(arg1);
        // Then:
        Assert.assertEquals( result, expected, 0.001);
    }





}
