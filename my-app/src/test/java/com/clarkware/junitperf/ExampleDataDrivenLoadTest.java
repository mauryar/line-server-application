package com.clarkware.junitperf;

import static org.junit.Assert.assertEquals;

import java.io.*;
import java.util.*;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Logger;

import junit.framework.Test;
import junit.framework.TestCase;

import com.circle.beans.Line;
import com.circle.constants.MyAppConstants;
import com.circle.controllers.MainController;
import com.clarkware.junitperf.*;

/**
 * The <code>ExampleDataDrivenLoadTest</code> demonstrates one technique for
 * creating a load test where each thread uses a distinct piece of test data.
 *
 * @author <b>Mike Clark</b>
 * @author Clarkware Consulting, Inc.
 *
 * @see com.clarkware.junitperf.LoadTest
 */

public class ExampleDataDrivenLoadTest extends TestCase {
	/*

	private static final int CONCURRENT_USERS = 100000;
	private static Iterator testDataIterator;
	private static Logger logger = Logger.getLogger("LoadTest");
	public ExampleDataDrivenLoadTest(String name, ArrayList <Long>testData) throws SecurityException, IOException {
		super(name);
		Handler fh = new FileHandler("wombat.log");
		Logger.getLogger("").addHandler(fh);
		testDataIterator = testData.iterator();
	}

	public synchronized String testExceededLineNumber(long lineNumber) {

		String exceededOutput = null;
		try {
			exceededOutput = MainController.getLineNumber(lineNumber);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return exceededOutput + " time " + new Date();
		// assertEquals(exceededOutput , MyAppConstants.ERROR );
	}

	static long randomWithRange(long min, long max) {
		long range = (max - min) + 1;
		return (long) (Math.random() * range) + min;
	}

	public static Test suite() throws SecurityException, IOException {

		ArrayList testData = new ArrayList();
		for (int i = 0; i < CONCURRENT_USERS; i++) {
			testData.add(randomWithRange(0,100));
		}
	Test test = new ExampleDataDrivenLoadTest("testData", testData);
		LoadTest loadTest = new LoadTest(test, CONCURRENT_USERS);
		return loadTest;
	}

	private synchronized static Long getNextTestData() {
		return (Long) testDataIterator.next();
	}

	public void testData() {
		Long data = getNextTestData();
		String op = testExceededLineNumber(data);
		//System.out.println(op);
		logger.info(op);
	}
	*/
}
