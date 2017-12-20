import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.util.Random;

/**
 * Created by Artsiom_Halavach1 on 12/18/2017.
 */

public class CalculatorCtgTest extends BaseCalculatorTest {
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



    @Test(dataProvider = "dataProviderAdd",groups = "complex")
    public void CtgVerivfication(double arg1, double expected) {
        // When:
        double result = calculator.ctg(arg1);
        // Then:
        Assert.assertEquals( result, expected, 0.001);
    }




}