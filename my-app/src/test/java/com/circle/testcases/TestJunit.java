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
	
	
	@Test
	public void testExceededLineNumber() {
		
		Line line = new Line();
		line.setLineNumber(7);
		String exceededOutput = null;
		try {
			exceededOutput = MainController.getLineNumber(7);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(exceededOutput , MyAppConstants.ERROR );
	}
  
}