FROM payara/server-full:6.2023.12-jdk17

# Copy the built web application
COPY MessageEncryptorWebApplication/dist/MessageEncryptorWebApplication.war /opt/payara/deployments/

# Expose port
EXPOSE 8080

# Create a startup script
RUN echo '#!/bin/bash\nasadmin start-domain --verbose --jvmoptions="-Dorg.glassfish.grizzly.nio.DefaultSelectorHandler.force-selector-spin-detection=true"' > /opt/payara/start.sh && chmod +x /opt/payara/start.sh

# Start Payara with JVM options
CMD ["/opt/payara/start.sh"]