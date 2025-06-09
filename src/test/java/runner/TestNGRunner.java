package runner;

import org.testng.TestNG;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;
import org.testng.xml.internal.Parser;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;

public class TestNGRunner {
    public static void main(String[] args) throws IOException {

        // new file
        String groupToRun = System.getProperty("groupToRun");  // Use: -DgroupToRun=smoke
       // System.out.println("Group to run: " + groupToRun);

        // Load the original testng.xml file
        List<XmlSuite> suites = new Parser("src/test/resources/testng.xml").parseToList();

        if (groupToRun != null && !groupToRun.isEmpty()) {
            for (XmlSuite suite : suites) {
                for (XmlTest test : suite.getTests()) {
                    System.out.println("Adding included group to test: " + test.getName());
                    test.setIncludedGroups(Collections.singletonList(groupToRun));
                   // System.out.println(test.getIncludedGroups());
                    for (XmlClass clazz : test.getClasses()) {
                     //   System.out.println("  - " + clazz.getName());
                    }
                }
            }
        }

        TestNG testng = new TestNG();
        testng.setXmlSuites(suites);
        testng.run();

        if (testng.hasFailure()) {
            System.exit(1);
        }
    }
}
