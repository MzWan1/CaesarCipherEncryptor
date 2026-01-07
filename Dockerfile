FROM tomcat:9-jdk11-openjdk

# Copy the built web application
COPY MessageEncryptorWebApplication/build/web /usr/local/tomcat/webapps/ROOT

# Set JVM options to fix cgroup issue
ENV JAVA_OPTS="-Djdk.cgroup.disable=true"

# Expose port
EXPOSE 8080

# Start Tomcat
CMD ["catalina.sh", "run"]