FROM tomcat:9-jdk11-openjdk

# Install ant and wget
RUN apt-get update && apt-get install -y ant wget && rm -rf /var/lib/apt/lists/*

# Copy the project
COPY . /app

WORKDIR /app

# Download the NetBeans CopyLibs jar
RUN wget https://repo1.maven.org/maven2/org/netbeans/modules/org-netbeans-modules-java-j2seproject-copylibstask/1.0/org-netbeans-modules-java-j2seproject-copylibstask-1.0.jar -O /tmp/copylibstask.jar

# Build the web application
RUN ant -Dlibs.CopyLibs.classpath=/tmp/copylibstask.jar -f MessageEncryptorWebApplication/build.xml dist

# Copy the WAR to Tomcat webapps
RUN cp MessageEncryptorWebApplication/dist/MessageEncryptorWebApplication.war /usr/local/tomcat/webapps/

# Expose port
EXPOSE 8080

# Start Tomcat
CMD ["catalina.sh", "run"]