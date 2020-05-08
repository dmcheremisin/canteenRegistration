# Canteen Registration Application
Project for the self registration in the canteen

## To run backend:
1. Install JDK Java 11 and Maven version greater than 3.6.3
2. Go to the root project directory
3. Execute command in the command line: mvn clean package
4. Go to the folder backend/target/
5. Execute in this folder in the command line: java -jar canteenApp.jar
6. Go to the browser: localhost:8080 

## To run frontend separately from backend:
1. Install node and npm
2. Go to folder frontend and run command: ng serve
3. Go to the browser: localhost:4200

## Logs
Application writes log files.
Log files can be found in the same folder as application jar file in the folder "logs".

### Remaining tasks
1. Week initialization if week quantity < 6
2. Export by day and week
3. Backend SSO
4. Frontend SSO
5. Markup