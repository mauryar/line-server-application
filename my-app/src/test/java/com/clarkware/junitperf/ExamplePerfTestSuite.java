package com.clarkware.junitperf;

import java.io.IOException;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * The <code>ExamplePerfTestSuite</code> demonstrates how to 
 * assemble a test suite containing performance-related tests.
 * 
 * @author <b>Mike Clark</b>
 * @author Clarkware Consulting, Inc.
 */

public class ExamplePerfTestSuite {

	public static Test suite() throws SecurityException, IOException {
        
		TestSuite suite = new TestSuite();

		suite.addTest(ExampleTimedTest.suite());
		suite.addTest(ExampleLoadTest.suite());
		suite.addTest(ExampleDataDrivenLoadTest.suite());

		// Add more performance tests here.

		return suite;
	}
		
	public static void main(String args[]) throws SecurityException, IOException {
		junit.textui.TestRunner.run(suite());
	}
}
