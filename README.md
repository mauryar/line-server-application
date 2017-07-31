# Line Server Application

Application retrieves and sends the line for corresponding line number from the file requested by clients (Many clients can provide the line number to the Application at a given instant of time).  
(Read Help_Document for detailed implementation)

### Prerequisites
- Eclipse IDE
- Spark Java
- Input File path
- Browser to get line using REST API


## Running the tests

Set the input file path in the TestJunit.java under folder src/test/java

4 Test Cases:

1. Test by exceeding line number from that in input file
2. Test with negative line number i.e '-1'
3. Test with boundary line number i.e '0' 
4. Test with existing line number in input file

## Deployment

-	Download the source code from GitHub or unzip the Source code file
-	Open my-app folder and then open the run.sh file in Notepad
-	Enter the path of the input file that will give the line for corresponding line number
-	Run build.sh file to create the build
-	Run run.sh file
-   Use a REST Call on browser (I have used Postman)
		Example 1: http://localhost:4567/lines/3

## Built With

* Maven


## Authors

* **Rajani Maurya** - *Initial work* 


## Acknowledgments

http://www.mscharhag.com/java/building-rest-api-with-spark
http://sparkjava.com/tutorials/
https://dzone.com/articles/building-simple-restful-api
http://www.cdn.geeksforgeeks.org/fast-io-in-java-in-competitive-programming/
https://github.com/arekgofi/Setting-up-Spark-with-Maven