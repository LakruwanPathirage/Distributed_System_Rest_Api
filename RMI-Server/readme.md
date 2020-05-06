RMI Server

Java Application to connect desktop client and REST API and updates desktop client every 15 seconds and alert the REST Api inside fire alarm monitoring system. 

-----How to Run------------
Method 1

* Clone this folder and goto bin folder and run "start rmi registry" inside cmd
* Then run "rmic RMI_Server" command inside same bin folder to create server's stub file
* Then paste that "RMI_Server_Stub.class" to bin folder of RMI-Client
* Then run the RMI_Server.java

Method 2

* to run the app goto binaries directory and open cmd then run this command.
* note: this jar file compiled from java11 jdk 

## java -jar "RMI-Server.jar"
