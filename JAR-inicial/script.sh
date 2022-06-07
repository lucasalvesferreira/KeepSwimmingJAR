root@ip-172-31-22-89:/# ls
DOCKER  dev   keepSwimmingJAR  lib64       media  proc  sbin           srv  usr
bin     etc   lib              libx32      mnt    root  scrpitJava.sh  sys  var
boot    home  lib32            lost+found  opt    run   snap           tmp
root@ip-172-31-22-89:/# vi scrpitJava.sh 
root@ip-172-31-22-89:/# chmod +x scrpitJava.sh 
root@ip-172-31-22-89:/# vi scrpitJava.sh 
root@ip-172-31-22-89:/# ./scrpitJava.sh 
Clonando repositoio
fatal: destination path 'keepSwimmingJAR' already exists and is not an empty directory.
Entrando...
Mostrando conteudo
Dockerfile  JAR-inicial  LICENSE  swing-1.0-SNAPSHOT-jar-with-dependencies.jar
FIM
root@ip-172-31-22-89:/# sudo docker ps -a
CONTAINER ID   IMAGE       COMMAND                  CREATED        STATUS                   PORTS     NAMES
4ed0fc6bd0ac   mysql:5.7   "docker-entrypoint.s…"   10 hours ago   Exited (0) 9 hours ago             keepSwimming
929986101a69   mysql:5.7   "docker-entrypoint.s…"   7 days ago     Exited (0) 7 days ago              ConteinerBD



root@ip-172-31-22-89:/# ls
DOCKER  etc              lib32       media  root           snap  usr
bin     home             lib64       mnt    run            srv   var
boot    keepSwimmingJAR  libx32      opt    sbin           sys
dev     lib              lost+found  proc   scrpitJava.sh  tmp


root@ip-172-31-22-89:/# vi scpitStartCont

root@ip-172-31-22-89:/# ls
DOCKER  etc              lib32       media  root            scrpitJava.sh  tmp
bin     home             lib64       mnt    run             snap           usr
boot    keepSwimmingJAR  libx32      opt    sbin            srv            var
dev     lib              lost+found  proc   scpitStartCont  sys
root@ip-172-31-22-89:/# vi scpitStartCont.sh


root@ip-172-31-22-89:/# sudo docker run --name keepJavaCli -it
"docker run" requires at least 1 argument.
See 'docker run --help'.

Usage:  docker run [OPTIONS] IMAGE [COMMAND] [ARG...]

Run a command in a new container



root@ip-172-31-22-89:/# ls
DOCKER  home             libx32      proc            scpitStartCont.sh  tmp
bin     keepSwimmingJAR  lost+found  root            scrpitJava.sh      usr
boot    lib              media       run             snap               var
dev     lib32            mnt         sbin            srv
etc     lib64            opt         scpitStartCont  sys

root@ip-172-31-22-89:/# vi scpitStartCont


root@ip-172-31-22-89:/# sudo docker build . -t keepSwimming:v1
invalid argument "keepSwimming:v1" for "-t, --tag" flag: invalid reference format: repository name must be lowercase
See 'docker build --help'.


root@ip-172-31-22-89:/# docker build -t keepSwimming:v1
invalid argument "keepSwimming:v1" for "-t, --tag" flag: invalid reference format: repository name must be lowercase
See 'docker build --help'.


root@ip-172-31-22-89:/# docker build -t keepSwimming:v1 .
invalid argument "keepSwimming:v1" for "-t, --tag" flag: invalid reference format: repository name must be lowercase
See 'docker build --help'.

root@ip-172-31-22-89:/# vi scrpitJava.sh 

root@ip-172-31-22-89:/# /scrpitJava.sh 
Clonando repositoio
fatal: destination path 'keepSwimmingJAR' already exists and is not an empty directory.
Entrando...
Mostrando conteudo
Dockerfile  JAR-inicial  LICENSE  swing-1.0-SNAPSHOT-jar-with-dependencies.jar
FIM



root@ip-172-31-22-89:/# ls

DOCKER  home             libx32      proc            scpitStartCont.sh  tmp
bin     keepSwimmingJAR  lost+found  root            scrpitJava.sh      usr
boot    lib              media       run             snap               var
dev     lib32            mnt         sbin            srv
etc     lib64            opt         scpitStartCont  sys
root@ip-172-31-22-89:/# cd keepSwimmingJAR/

root@ip-172-31-22-89:/ keepSwimmingJAR # ls
Dockerfile  JAR-inicial  LICENSE  swing-1.0-SNAPSHOT-jar-with-dependencies.jar


root@ip-172-31-22-89:/keepSwimmingJAR # sudo docker build -t keepSwimming:v1 .
invalid argument "keepSwimming:v1" for "-t, --tag" flag: invalid reference format: repository name must be lowercase
See 'docker build --help'.
root@ip-172-31-22-89:/keepSwimmingJAR # sudo docker build . -t keepSwimming:v1 
invalid argument "keepSwimming:v1" for "-t, --tag" flag: invalid reference format: repository name must be lowercase
See 'docker build --help'.

# Incia o build com base no arquivo dockerFile
root@ip-172-31-22-89:/keepSwimmingJAR # sudo docker build . -t keepswimming:v1 
Sending build context to Docker daemon  70.58MB
Step 1/4 : FROM openjdk:11
 ---> c644efd24273
Step 2/4 : WORKDIR /keepSwimmingJAR/
 ---> Running in 45aaaa785168
Removing intermediate container 45aaaa785168
 ---> 1062196998a6
Step 3/4 : COPY swing-1.0-SNAPSHOT-jar-with-dependencies.jar /keepSwimmingJAR/
 ---> aa9c75a0277c
Step 4/4 : CMD ["java", "-jar", "swing-1.0-SNAPSHOT-jar-with-dependencies.jar"]
 ---> Running in 62dbfe3f8ee5
Removing intermediate container 62dbfe3f8ee5
 ---> 3eb83a856cdc
Successfully built 3eb83a856cdc
Successfully tagged keepswimming:v1

root@ip-172-31-22-89:/keepSwimmingJAR # sudo docker ps -a
CONTAINER ID   IMAGE       COMMAND                  CREATED        STATUS                    PORTS     NAMES
4ed0fc6bd0ac   mysql:5.7   "docker-entrypoint.s…"   10 hours ago   Exited (0) 10 hours ago             keepSwimming
929986101a69   mysql:5.7   "docker-entrypoint.s…"   7 days ago     Exited (0) 7 days ago               ConteinerBD
root@ip-172-31-22-89:/keepSwimmingJAR# ^C
4
root@ip-172-31-22-89:/keepSwimmingJAR # sudo docker exec -it keepswimming
"docker exec" requires at least 2 arguments.
See 'docker exec --help'.

Usage:  docker exec [OPTIONS] CONTAINER COMMAND [ARG...]

Run a command in a running container
root@ip-172-31-22-89:/keepSwimmingJAR # sudo docker exec -it keepswimming:v1
"docker exec" requires at least 2 arguments.
See 'docker exec --help'.

Usage:  docker exec [OPTIONS] CONTAINER COMMAND [ARG...]

Run a command in a running container
root@ip-172-31-22-89:/keepSwimmingJAR # sudo docker run --name keepJavaCli -it 3eb83a856cdc


===============Tela de Login===============


Insira seu login para continuar!!


Nome de Usuario:

bruno^C^Croot@ip-172-31-22-89:/keepSwimmingJAR# e

Command 'e' not found, but can be installed with:

apt install e-wrapper

root@ip-172-31-22-89:/keepSwimmingJAR# exit
exit
ubuntu@ip-172-31-22-89:~$ ls
docker
ubuntu@ip-172-31-22-89:~$ cd ..
ubuntu@ip-172-31-22-89:/home$ ^C
ubuntu@ip-172-31-22-89:/home$ ^C
ubuntu@ip-172-31-22-89:/home$ exit
logout
Connection to ec2-54-146-101-45.compute-1.amazonaws.com closed.
