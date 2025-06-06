package runner;

import org.testng.TestNG;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;
import org.testng.xml.internal.Parser;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

public class TestNGRunner {
    public static void main(String[] args) throws IOException {

//        System.out.println("CLASSPATH: " + System.getProperty("java.class.path"));
//
//        InputStream input = TestNGRunner.class.getClassLoader().getResourceAsStream("testng.xml");
//
//        if (input == null) {
//            throw new RuntimeException("testng.xml not found in classpath");
//        }
//
//        File xmlFile = File.createTempFile("testng", ".xml");
//        Files.copy(input, xmlFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
//
//        TestNG testng = new TestNG();
//        testng.setTestSuites(Collections.singletonList(xmlFile.getAbsolutePath()));
//        testng.run();


        // new file
        String groupToRun = System.getProperty("groupToRun");  // Use: -DgroupToRun=smoke
        System.out.println("Group to run: " + groupToRun);

        // Load the original testng.xml file
        List<XmlSuite> suites = new Parser("src/test/resources/testng.xml").parseToList();

        if (groupToRun != null && !groupToRun.isEmpty()) {
            for (XmlSuite suite : suites) {
                for (XmlTest test : suite.getTests()) {
                    test.setIncludedGroups(Collections.singletonList(groupToRun));
                }
            }
        }

        TestNG testng = new TestNG();
        testng.setXmlSuites(suites);
        testng.run();
   if(testng.hasFailure()){
       System.exit(1);
   }

    }
}
