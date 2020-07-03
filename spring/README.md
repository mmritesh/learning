mvn clean package -DskipTests
docker build -f Dockerfile -t my-springboot .
docker images
docker run -p 8085:8085 my-springboot