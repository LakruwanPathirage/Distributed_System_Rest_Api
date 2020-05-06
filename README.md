
# Setting Rest Api and Mongo DB
	Setting Mongodb

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

# sensor emulator (sensor app)
Java Application to simulate sensor behavior on fire alarm monitoring system

to run the app goto out\artifacts\Sensor_Emulator_jar and open cmd then run this command

` java -jar "Sensor Emulator.jar" `

# Email and Sms Server (dummy)
Java Application to simulate sensor behavior on fire alarm monitoring system
* note: this jar file compiled from java11 jdk

to run the app goto binarries\ and open cmd then run this command
* note: this jar file compiled from java11 jdk

` java -jar "Email and SMS Server dummy.jar.jar"


# RMI-Client

Java Desktop Application to add,update,delete sensors.

## -----How to Run------------

* to run the app go to binaries directory and open cmd then run this command.

* note: this jar file compiled from java11 jdk

` java -jar "RMI_Client.jar" `

Or clone this folder and run RMI_Client.java
