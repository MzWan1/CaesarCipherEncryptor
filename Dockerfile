FROM payara/server-full:6.2023.12-jdk17

# Switch to root to install packages
USER root

# Install wget, unzip and curl (for healthcheck)
RUN apt-get clean && apt-get update && apt-get install -y wget unzip curl ca-certificates && rm -rf /var/lib/apt/lists/*

# Switch back to payara user
USER payara

# Copy and unzip Apache Ant
COPY apache-ant.zip /tmp/
RUN cd /tmp && unzip apache-ant.zip

# Build the EJB module
RUN /tmp/apache-ant-1.10.14/bin/ant -f MessageEncryptorEJBModule/build.xml

# Build the web application
RUN /tmp/apache-ant-1.10.14/bin/ant -f MessageEncryptorWebApplication/build.xml

# Copy the built EJB module
COPY MessageEncryptorEJBModule/dist/MessageEncryptorEJBModule.jar /opt/payara/deployments/

# Copy the built web application as ROOT.war to deploy at root context
COPY MessageEncryptorWebApplication/dist/MessageEncryptorWebApplication.war /opt/payara/deployments/ROOT.war

# Expose common Payara ports (http, https/admin, admin console, JMX)
EXPOSE 8080 8181 4848 8686

# Set JVM options environment variable and enable OpenTelemetry auto-config
ENV PAYARA_JAVA_OPTS="-Dorg.glassfish.grizzly.nio.DefaultSelectorHandler.force-selector-spin-detection=true -Dotel.java.global-autoconfigure.enabled=true"

# Simple Docker healthcheck that retries until Payara responds on root context
HEALTHCHECK --interval=30s --timeout=10s --start-period=60s --retries=3 \
  CMD curl -f http://localhost:8080/ || exit 1

# Start Payara
CMD ["asadmin", "start-domain", "--verbose"]