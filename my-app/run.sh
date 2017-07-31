#Stop the jdk process
### ps -ef 
## Get process id
## kill the process

## Give explicit path
##Give your file path , I used : C:\\Users\\rajan\\Desktop\\LineServerApplication\\my-app\\src\\main\\resources\\TestFile.txt
java -cp target/my-app-0.0.1-SNAPSHOT-jar-with-dependencies.jar com.circle.controllers.MainController "C:\Users\rajan\Desktop\LineServerApplication\my-app\src\main\resources\TestFile.txt"