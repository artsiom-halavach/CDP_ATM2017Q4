package runner;
import org.testng.TestListenerAdapter;
import org.testng.TestNG;
import org.testng.xml.XmlSuite;
import java.util.ArrayList;
import java.util.List;
import listeners.SuiteListener;
import listeners.TestListener;
/**
 * Created by Artsiom_Halavach1 on 12/20/2017.
 */
public class TestRunner {

    public static void main(String[] args) {
            TestNG tng = new TestNG();

            tng.addListener(new TestListenerAdapter());
            tng.addListener(new SuiteListener());
            tng.addListener(new TestListener());

            XmlSuite suite = new XmlSuite();
            suite.setName("TmpSuite");

            List<String> files = new ArrayList<>();
            files.addAll(new ArrayList<String>() {{
                add("./src/test/resources/calculatorArithmeticsSuite.xml");
                add("./src/test/resources/calculatorTrigonometrySuite.xml");
            }});
            suite.setSuiteFiles(files);
        suite.setParallel(XmlSuite.ParallelMode.METHODS);
        suite.setThreadCount(4);


            List<XmlSuite> suites = new ArrayList<>();
            suites.add(suite);
            tng.setXmlSuites(suites);

            tng.run();
        }

}
