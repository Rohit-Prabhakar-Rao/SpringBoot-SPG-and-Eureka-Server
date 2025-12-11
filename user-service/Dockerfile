# multi-stage not building inside image — build jar locally first
FROM eclipse-temurin:25-jre-jammy AS runtime
WORKDIR /app

# install netcat for wait script
USER root
RUN apt-get update && apt-get install -y --no-install-recommends netcat && \
    rm -rf /var/lib/apt/lists/*

# create non-root user
RUN addgroup --system app && adduser --system --ingroup app app

# copy application jar (caller should set --build-arg JAR_FILE or ensure target/*.jar)
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar

# copy simple wait-for script
COPY wait-for-db.sh /app/wait-for-db.sh
RUN chmod +x /app/wait-for-db.sh

USER app
EXPOSE 8080
ENTRYPOINT ["/app/wait-for-db.sh"]
CMD ["java","-jar","/app/app.jar"]
