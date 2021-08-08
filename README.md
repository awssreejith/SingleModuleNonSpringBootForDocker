# SingleModuleNonSpringBootForDocker
How to create jar for a Single module Non Spring boot application
=================================================================
This project is a side car project created for below purposes
0) To showcase how to create a jar for a single module NON SPRINGBOOT application
1) Act as a sample application to test docker interactive mode.

Note: This program while ran will create an interactive menu where user can enter a random text
and a count variable. The system will print the text that many times in to a file

   If windows then to --> C:\MyTemp\sreejith\MyProgOut.txt;

   If Linux   then to = "/tmp/sreejith/MyProgOut.txt";

Thus this side car project will be used to test two things
 - Intercative running of a docker container
 - Volume mapping to save logs 
 
 
Note: There will be another repositiory created to showcase different Docker ways using this side car project

Step-1) In order to create a new JAR file, simply update the root pom.xml as below


 
    <groupId>org.sreejith</groupId>
    <artifactId>ProgramForDocker</artifactId>
    <version>1.0.0</version>
    <packaging>jar</packaging>

    <properties>
        <maven.compiler.source>8</maven.compiler.source>
        <maven.compiler.target>8</maven.compiler.target>
    </properties>

    <build>
        <plugins>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-jar-plugin</artifactId>
                <version>2.6</version>
                <configuration>
                    <archive>
                        <manifest>
                            <mainClass>com.sreejith.MyMain</mainClass>
                        </manifest>
                    </archive>
                </configuration>
            </plugin>

        </plugins>
    </build>
	
	
	
Step-2) mvn clean install

Step-3) java -jar C:\MyStudy\Java\ProgramForDocker\target\ProgramForDocker-1.0.0.jar

The out file can be found under C:\MyTemp\sreejith\MyProgOut.txt for windows or /tmp/sreejith/MyProgOut.txt for Linux
