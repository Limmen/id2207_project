You can either import the project as a maven-project into any Java IDE and run/compile/build from inside the IDE or use the command-line.

Command-line options:

All commands should be executed in the project root, i.e:

root
| - src
| - README.txt
| - pom.xml
| - target

To build, fetch dependencies, compile and run tests, (including acceptance tests) execute : mvn install

The above without running tests: mvn install -DskipTests

To compile the project: mvn compile

To run tests: mvn test

To run the program: java -jar target/sep_system-1.0-SNAPSHOT-jar-with-dependencies.jar



