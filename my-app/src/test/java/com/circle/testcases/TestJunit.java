package com.circle.testcases;

/**
 * Test Case Executor
 * @author rajan
 *
 */
import org.junit.Test;

import com.circle.beans.Line;
import com.circle.constants.MyAppConstants;
import com.circle.controllers.MainController;

import static org.junit.Assert.assertEquals;

import java.io.IOException;



public class TestJunit {
	
	// Save the path of file to test
	//private static String path = "C:\\Users\\rajan\\Desktop\\LineServerApplication\\my-app\\src\\main\\resources\\TestFile.txt";
	private static String path = "C:\\fbhr.csv";
	
	//Test Case 1. Test by exceeding line number from that in input file
	@Test
	public void testExceededLineNumber() {
		
		Line line = new Line();
		line.setLineNumber(7);
		String exceededOutput = null;
		try {
			exceededOutput = MainController.getLineNumber(line.getLineNumber(), path);
			System.out.println("Test 1: "+exceededOutput);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(exceededOutput , MyAppConstants.ERROR );
	}
	
	
	//Test Case 2. Test with negative line number i.e '-1'
	@Test
	public void testNoLineNumber() {
		
		Line line = new Line();
		line.setLineNumber(-1);
		String exceededOutput = null;
		try {
			exceededOutput = MainController.getLineNumber(line.getLineNumber(), path);
			System.out.println("Test 2: "+exceededOutput);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(exceededOutput , MyAppConstants.ERROR );
	}
  
	
	
	//Test Case 3. Test with boundary line number i.e '0'
	@Test
	public void testBoundaryLineNumber() {
		
		Line line = new Line();
		line.setLineNumber(0);
		String exceededOutput = null;
		try {
			exceededOutput = MainController.getLineNumber(line.getLineNumber(), path);
			System.out.println("Test 3: "+exceededOutput);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(exceededOutput , MyAppConstants.ERROR );
	}
	
	
	//Test Case 4. Test with existing line number in input file
	@Test
	public void testCorrectLineNumber() {
		
		Line line = new Line();
		line.setLineNumber(1048575);
		String exceededOutput = null;
		try {
			exceededOutput = MainController.getLineNumber(line.getLineNumber(), path);
			System.out.println("Test 4: "+exceededOutput);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(exceededOutput , "Each line is terminated by end line, let us search now." );
	}
	
}