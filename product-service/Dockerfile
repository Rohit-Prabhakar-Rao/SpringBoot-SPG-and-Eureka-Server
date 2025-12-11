# Runtime Dockerfile (copy pre-built jar into image)
FROM eclipse-temurin:25-jre-jammy
WORKDIR /app

# Install netcat (apt for jammy) and cleanup apt lists
USER root
RUN apt-get update && \
    apt-get install -y netcat-openbsd && \
    rm -rf /var/lib/apt/lists/*

# Create non-root user
RUN addgroup --system app && adduser --system --ingroup app app

# Allow overriding which jar to copy; default picks whatever is in target/*.jar
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar

# Copy wait script
COPY wait-for-db.sh /app/wait-for-db.sh
RUN chmod +x /app/wait-for-db.sh

# Ensure the app files are owned by the non-root user
RUN chown app:app /app/app.jar /app/wait-for-db.sh

USER app

# Product service listens on 8083
EXPOSE 8083

ENTRYPOINT ["/app/wait-for-db.sh"]
CMD ["java","-jar","/app/app.jar"]
