

/**
 * Created by Artsiom_Halavach1 on 12/18/2017.
 */
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.util.Random;


public class CalculatorTgTest extends BaseCalculatorTest {
    private double arg1;
    private double expected;

    @DataProvider
    public static Object[][] dataProviderAdd () {
        double r = new Random().nextDouble();
        double tg  = Math.tan(r);
        return new Object[][]{
                {314.159265, 0},
                {5, -3.380515},
                {Math.PI/2, 0},
                {0,0},
                {Math.PI/4,1},
//                Random element in data provider to avoid Pesticide Paradox
                {r, tg}

//
        };
    }



    @Test(dataProvider = "dataProviderAdd",groups = "complex")
    public void TgVerivfication(double arg1, double expected) {
        // When:
        double result = calculator.tg(arg1);
        // Then:
        Assert.assertEquals(result, expected, 0.001);
    }




}