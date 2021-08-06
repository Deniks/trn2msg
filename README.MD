# Summary
# Goal
Task is to write a program named trn2msg.jar in Java or related framework, such as SpringBoot which reads transaction file and writes notification file.
## Client Requirements?
* As I did not manage to compile the project(Spring Boot Maven/JAR issues) I ensured that developement version follows requirements:
  * Transaction file(seed.txt) is in text line-by-line format and the path could be specified within the Input Manager static class
  * Notification file in JSON format is being produced when Transaction class absorbs and processes all inputs.
  * Error.log file is produced in case there error occurs.
  * Spring boot framework is installed in order to compile the project run a JAR file.
## Difficulties
* JAR compiler not working due messed up versions of Java Runtime ..
* I do realize that my code is not most readable. Class and function names are not as consistent and reusable as they could be
* Couldn't append text to existing file because it required multiple modules to be brought in and as a high-level language programmer I was merely used to `.append()` method but in Java I wasn't sure how to implement it.