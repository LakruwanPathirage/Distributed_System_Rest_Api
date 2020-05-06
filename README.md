
# Setting Rest Api and Mongo DB
##	Setting Mongodb

•	Download mongo db from https://www.mongodb.com/download-center/community
•	Before install the mongo db go to  C drive in computer,create folder called “data”
•	Go inside the data folder and create a  folder called “db”
•	Go to bin folder where  mongodb installed under “C:\Program Files\MongoDB\Server\4.2\bin”
Open command prompt in bin folder and type , mongod in the prompt
•	Open another  command prompt in bin folder and type , mongo  in the prompt,the you can see mongo db is up and running


#	Setting Rest Api server

•	Find the folder called “Rest-api” and open it with the IDE
•	Open that folder in the  command prompt
Ex: C:\Users\Sumudu Lakruwan\Desktop\Rest-api
•	type in the command prompt,
` npm install `

then you will download node modules

•	Finally type the below command in the   command prompt
    ` node index.js `
then rest api sever is up and running
 
# Sensor web Monitoring System (web client)

## --- How to run ---
run ` npm install ` command to install required node mudules
then run ` npm start` to start developemnt server

# Sensor Emulator (sensor app)
Java Application to simulate sensor behavior on fire alarm monitoring system

## --- How to run ---
to run the app goto out\artifacts\Sensor_Emulator_jar and open cmd then run this command
* note: this jar file compiled from java11 jdk

` java -jar "Sensor Emulator.jar" `

# Email and Sms Server (dummy)
Java Application to simulate sensor behavior on fire alarm monitoring system

## --- How to run ---
to run the app goto binarries\ and open cmd then run this command
* note: this jar file compiled from java11 jdk

` java -jar "Email and SMS Server dummy.jar.jar" `


# RMI Server

Java Application to connect desktop client and REST API and updates desktop client every 15 seconds and alert the REST Api inside fire alarm monitoring system.

## -----How to Run------------

### Method 1

*Clone this folder and goto bin folder and run `start rmi registry` inside cmd
*Then run `rmic RMI_Server` command inside same bin folder to create server's stub file
*Then paste that "RMI_Server_Stub.class" to bin folder of RMI-Client
*Then run the RMI_Server.java

### Method 2

*to run the app goto binaries directory and open cmd then run this command.
*note: this jar file compiled from java11 jdk

#` java -jar "RMI-Server.jar ` 


# RMI-Client

## -----How to Run------------

### Method 1

*Paste that "RMI_Server_Stub.class" to bin folder of RMI-Client

*Then run the RMI_Client.java

### Method 2

*to run the app goto binaries directory and open cmd then run this command.
*note: this jar file compiled from java11 jdk

#` java -jar "RMI_Client.jar ` 
