package listeners;

        import org.testng.ISuite;
        import org.testng.ISuiteListener;
        import org.testng.xml.XmlSuite;

/**
 * Created by Artsiom_Halavach1 on 12/18/2017.
 */
public class SuiteListener implements ISuiteListener {

    @Override
    public void onStart(ISuite suite) {
        suite.getXmlSuite().setParallel(XmlSuite.ParallelMode.METHODS);
        suite.getXmlSuite().setThreadCount(4);
    }

    @Override
    public void onFinish(ISuite suite) {
    }
}
