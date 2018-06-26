# QA Cinemas Application

## How to run it with Docker
Assume you already have Docker installed. See https://docs.docker.com/installation/.

~~~
set DOCKER_HOST=unix:///private/var/tmp/docker.sock
~~~

TODO: change README.md for QA Cinemas
For company computers:

1. Install MySQL, VMBox and Docker workbench from LocalInstall. Add MySQL/bin to environmental variable.

2. Run VMBox.

3. Clone the project and build locally with command line in folder, and deploy with Docker Quickstart Terminal:

~~~
mvn install
mvn clean package docker:build
~~~

4. VMBox should have a virtual machine running now. Right click it and go to settings->network->port forwarding. Make a new rule called 'demo-app', give both its Host Port and Guest Port the value 8080.

5. Run the command to launch MySQL in Docker. 

~~~
docker run --name demo-mysql -e MYSQL_ROOT_PASSWORD=password -e MYSQL_DATABASE=demo -e MYSQL_USER=demo_user -e MYSQL_PASSWORD=demo_pass -d mysql:5.7
~~~

6. Run demo application in Docker container and link to demo-mysql:

~~~
docker run -p 8080:8080 --name demo-app --link demo-mysql:mysql -d jiwhiz/spring-boot-docker-mysql
~~~

You can check the log by
~~~
docker logs demo-mysql
docker logs demo-app
~~~

Open http://localhost:8080 in browser and you should see the message. If you are using Boot2Docker in Mac OSX, 
find ip by *boot2docker ip* and replace _localhost_ to _boot2docker ip_.

NOTE: This may not work first time around. Run steps 3 onwards again in a new terminal.

To stop/remove all of Docker containers:

docker stop $(docker ps -a -q)
docker rm $(docker ps -a -q)

