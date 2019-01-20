package com.Accolite.app;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase {
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest(String testName) {
        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        // suite of test cases
        return new TestSuite(AppTest.class);
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp() {
        App a = new App();
        assertEquals("abcd", a.reverseString("dcba"));
    }
    public void testApp2(){
        App a = new App();
        assertEquals(true, a.containsCheck("abcd"));
    }
    public void testApp3(){
        App a = new App();
        assertEquals(false, a.containsCheckInsensitive("abcde"));
    }
}
