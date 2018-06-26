# QA Cinemas Application

## How to run it with Docker
Assume you already have Docker installed. See https://docs.docker.com/installation/.

TODO: change README.md for QA Cinemas
For company computers:

1. Install MySQL, VMBox and Docker workbench from LocalInstall. Add MySQL/bin to environmental variable.

2. Run VMBox.

3. Clone the project and build locally with command line in folder, and deploy with Docker Quickstart Terminal:

~~~
mvn install
mvn clean package docker:build
~~~

4. VMBox should have a virtual machine running now. Right click it and go to settings->network->port forwarding. Make a new rule called 'demo-app', give both its Host Port and Guest Port the value 8080. Also run:

~~~
set DOCKER_HOST=unix:///private/var/tmp/docker.sock
~~~

5. Run the command to launch MySQL in Docker. 

~~~
docker run --name demo-mysql -e MYSQL_ROOT_PASSWORD=password -e MYSQL_DATABASE=demo -e MYSQL_USER=demo_user -e MYSQL_PASSWORD=demo_pass -d mysql:5.7
~~~

6. Run demo application in Docker container and link to demo-mysql:

~~~
docker run -p 8080:8080 --name demo-app --link demo-mysql:mysql -d cinema/qa-cinema
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

~~~
docker stop $(docker ps -aq)
docker rm $(docker ps -aq)

READ ME.

Run the following:

From the directory that contains the POM file:

mvn clean package docker:build

Then run:

docker run --name demo-mysql -e MYSQL_ROOT_PASSWORD=password -e MYSQL_DATABASE=demo -e MYSQL_USER=demo_user -e MYSQL_PASSWORD=demo_pass -d mysql:5.6

docker logs demo-mysql (ensure mysql server is up)

docker run -p 8080:8080 --name cinema-app --link demo-mysql:mysql -d cinema/qa-cinema

docker logs trainer-app (ensure app is up by accessing http://localhost:8080)

~~~

