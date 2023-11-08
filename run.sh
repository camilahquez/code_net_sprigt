git pull
sh mvnw clean package
mkdir -p output
nohup java -jar -Dserver.port=8080 target/code_net_mongodb-0.0.1-SNAPSHOT.jar > output/logs.log 2>&1 &
echo $! > pid.txt
