import com.epam.tat.module4.Calculator;
import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.lang.annotation.Target;
import java.util.Random;

/**
 * Created by Artsiom_Halavach1 on 12/18/2017.
 */

@RunWith(DataProviderRunner.class)
public class CalculatorCosTest extends CalculatorBasicTests {
    private double arg1;
    private double expected;
    String s = this.getClass().getName();

//@Before
//    public static void ClassNameOutput(){
//    System.out.print(this.getClass().getName());
//
//    }

    @DataProvider
    public static Object[][] dataProviderAdd () {
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



    @Test
    @UseDataProvider("dataProviderAdd")
    public void testAdd(double arg1, double expected) {
        // When:
        double result = calculator.cos(arg1);
        // Then:
        Assert.assertEquals(expected, result, 0.001);
    }





}
