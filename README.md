# tmsandbox_project

Project set up
1. Download and install JAVA (I have installed JDK 23.0.2)
* Visit website, https://www.oracle.com/in/java/ Click on the “Download Java” icon.
* Now you can see the latest version is JDK 23 and there are options for Linux, macOS, and Windows. 
* Click the x64 Installer option to download the .exe file as per the operating system.
* Go to Downloads and double-click on that downloaded jdk-23_windows-x64_bin.exe file. So now Java Installation Wizard get open and then click Next button.
* Go to system properties in your computer, set up path variable for java. C:\Program Files\Java\jdk-23\bin and JAVA_HOME variable to where your jdk is. C:\Program Files\Java\jdk-23
* Open up command prompt and check the JAVA version. java --version

2. Download and install maven (I have installed Apache Maven 3.9.9 )
* Visit website https://maven.apache.org/download.cgi and download bin.zip for maven
* Copy the maven folder and paste it in program files of your computer
* Go to system properties in your computer, set up path variable for maven. C:\maven\apache-maven-3.9.9-bin and MAVEN_HOME variable to where your jdk is. C:\maven\apache-maven-3.9.9-bin\bin
* Open up command prompt and check the maven version. mvn -version

3. Download and install preferred IDE

4. Download and install git
* Visit website https://git-scm.com/downloads and download git as per operating system 

5. Create a Git hub repository

6. Create a Git hub project with a read me file

7. Open the project folder with your ide(as a maven project)

8. In your IDE set the java version and maven home path

9. Run command "mvn clean install" in your ide terminal. This will clean and install each module 

10. Add sonar qube plugin for code scanning