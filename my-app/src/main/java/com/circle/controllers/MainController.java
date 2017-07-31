package com.circle.controllers;

/**
 * Controller class which returns line for requested line number
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
	
		/*
		 * To get Line from Text file for given line number
		 */
		
		//gets the request with line number
			get("/lines/:lineNumber", (req, res) -> {
				String lineNumber = req.params(":lineNumber");
				
				// Regex to detect line number given is digit
				String regex = "\\d+";
				
				Line line = new Line();
				
				//check input line number if valid and then set Line number
				if (lineNumber != null && lineNumber.matches(regex)) {
					line.setLineNumber(Long.parseLong(lineNumber));
					
					//call function to read file and get the corresponding line
					String responseText = getLineNumber(line.getLineNumber(),args[0]);
					
					//if Line number less than 0 and greater than the line in file - HTTP 413 received
					//else when successful, get the corresponding line - HTTP 200 received
					if (responseText.equals(MyAppConstants.ERROR)) {
						res.status(413);
					} else {
						res.status(200);
					}
					line.setLine(responseText);
					return line;
				}
				//HTTP 400 for bad input
				res.status(400);
				return new ResponseError("No line with num '%s' found", lineNumber);
				
				//sending line number as key and line as value in the form of JSON to user
			}, json());
		
	}

	/**
	 * @param lineNumber
	 * @return
	 * @throws IOException
	 */
	public synchronized static String getLineNumber(long lineNumber,String path) throws IOException {
		
		// Retrieve line
		if (lineNumber <= 0) {
			return MyAppConstants.ERROR;
		}
		
		//line for corresponding line number given by user to be sent
		String result = null;
		
		//count to keep track when reaching the given line number
		long countLine = 0;
		
		// retrieving and reading file
		File file = new File(path);
		InputStreamReader read = new InputStreamReader(new FileInputStream(file));
		BufferedReader bufferedReader = new BufferedReader(read);
		
		// returning line number's text when countLine equals the given lineNumber
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
