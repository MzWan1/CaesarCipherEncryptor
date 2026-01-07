FROM payara/server-full:6.2023.12-jdk17

# Copy the built web application
COPY MessageEncryptorWebApplication/dist/MessageEncryptorWebApplication.war /opt/payara/deployments/

# Expose port
EXPOSE 8080

# Start Payara
CMD ["asadmin", "start-domain", "--verbose"]