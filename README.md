# Global Logistic
docker run -d --name local_global_logistic -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=global_logistic -e MYSQL_USER=admin -e MYSQL_PASSWORD=admin -p 3306:3306 mysql:latest