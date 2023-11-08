git pull
sh mvnw clean package
java -jar -Dserver.port=8080 target/code_net_mongodb-0.0.1-SNAPSHOT.jar