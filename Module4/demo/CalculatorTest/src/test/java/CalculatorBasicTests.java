/**
 * Created by Artsiom_Halavach1 on 12/14/2017.
 */


import com.epam.tat.module4.Calculator;

import org.junit.*;

import java.util.Random;


public class CalculatorBasicTests {
    public Calculator calculator = new Calculator();

    @BeforeClass
    public static void setUp() {

        System.out.println("Config prepare calculator" );

    }
    @AfterClass
    public static void setAfter() {

        System.out.println("Finish" );

    }



}