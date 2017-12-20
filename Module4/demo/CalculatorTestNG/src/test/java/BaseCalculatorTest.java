/**
 * Created by Artsiom_Halavach1 on 12/19/2017.
 */

import com.epam.tat.module4.Calculator;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.testng.*;

public class BaseCalculatorTest {
    public Calculator calculator = new Calculator();

    @BeforeClass
    public static void setUp() {
        System.out.println("Config prepare calculator");
    }

    @AfterClass
    public static void setAfter() {
        System.out.println("Finish class testing");
    }


}
