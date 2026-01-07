FROM tomcat:9-jdk11-openjdk

# Install ant
RUN apt-get update && apt-get install -y ant && rm -rf /var/lib/apt/lists/*

# Copy the project
COPY . /app

WORKDIR /app

# Build the web application
RUN ant -f MessageEncryptorWebApplication/build.xml dist

# Copy the WAR to Tomcat webapps
RUN cp MessageEncryptorWebApplication/dist/MessageEncryptorWebApplication.war /usr/local/tomcat/webapps/

# Expose port
EXPOSE 8080

# Start Tomcat
CMD ["catalina.sh", "run"]