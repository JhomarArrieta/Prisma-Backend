FROM amazoncorretto:21

WORKDIR /app

COPY src/ ./src
COPY lib/ ./lib

RUN mkdir -p bin
RUN javac -d bin -cp "lib/*" src/*.java

ENV CLASSPATH=/app/bin:/app/lib/

# CMD ["java","-cp","/app/bin:/app/lib/*","TestConexion"]
CMD ["java","-cp","/app/bin:/app/lib/*","TestDAO"]