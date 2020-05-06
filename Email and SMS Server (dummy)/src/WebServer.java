import controller.ApiConnection;
import model.Sensor;

import java.util.ArrayList;

public class WebServer {

    public static void main(String[] args) throws Exception {
        ApiConnection connection = new ApiConnection();
        System.out.println("Email and SMS Server Running! ");
        while (true) {

            //get all sensor with alert status
            ArrayList<Sensor> alertList = connection.getItemsWithAlert();

            for (Sensor sensor : alertList) {

                //send emails
                EmailServer.sendEmail(sensor);
                //send sms
                SMSServer.sendSMS(sensor);

                //set alert false after sending email and sms
                connection.updateAlertStatus(sensor);
            }
        }
    }


}
