package com.circle.controllers;

/**
 * Controller class which maps the model to view
 * @author rajan
 * 
 */
import static spark.Spark.get;
import static spark.Spark.exception;

import static com.circle.utils.JsonUtil.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;


import com.circle.beans.Line;

import com.circle.constants.MyAppConstants;
import com.circle.utils.ResponseError;

public class MainController {

	
	
	public static void main(String[] args) {

		
		//staticFileLocation("public"); // index.html is served at localhost:4567
										// (default port)
		/*
		 * To get Data from Text
		 */
		
			get("/lines/:lineNumber", (req, res) -> {
				String lineNumber = req.params(":lineNumber");
				System.out.println("lineNumber is: " + lineNumber);
				
				String regex = "\\d+";
				
				Line line = new Line();
				if (lineNumber != null && lineNumber.matches(regex)) {
					line.setLineNumber(Long.parseLong(lineNumber));
					String responseText = getLineNumber(line.getLineNumber());
					if (responseText.equals(MyAppConstants.ERROR)) {
						res.status(413);
					} else {
						res.status(200);
					}
					line.setLine(responseText);
					return line;
				}
				res.status(400);
				return new ResponseError("No line with num '%s' found", lineNumber);
			}, json());
		
		
		

		/*exception(IllegalArgumentException.class, (e, req, res) -> {
			System.out.println("Exception");
			res.status(400);
			res.body(toJson(new ResponseError(e)));
		});*/

	}

	/**
	 * @param lineNumber
	 * @return
	 * @throws IOException
	 */
	private static String getLineNumber(long lineNumber) throws IOException {
		// Retrieve line
		if (lineNumber <= 0) {
			return MyAppConstants.ERROR;
		}
		String result = null;
		long countLine = 0;
		// retrieving and reading file
		File file = new File("src\\main\\resources\\TestFile.txt");
		InputStreamReader read = new InputStreamReader(new FileInputStream(file));
		BufferedReader bufferedReader = new BufferedReader(read);
		// returning line number's text
		while ((result = bufferedReader.readLine()) != null) {
			countLine++;
			if (countLine == lineNumber) {
				bufferedReader.close();
				return result;
			}
		}
		bufferedReader.close();
		return MyAppConstants.ERROR;
	}

}
