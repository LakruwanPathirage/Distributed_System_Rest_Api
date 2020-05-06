import model.Sensor;

public class SMSServer {

    public static void sendSMS(Sensor sensor){

        if (sensor.isSmokeAlertStatus()){
            System.out.println("SMS Sent :");
            System.out.println("Detected High Smoke level ( "+sensor.getSmokeValue() + " )"+ "in floor "+sensor.getFloorNo()+" in room : "
                    +sensor.getSmokeValue());

        }

        if (sensor.isCo2AlertStatus()){
            System.out.println("SMS Sent :");
            System.out.println("Detected High C02 level ( "+sensor.getCo2Value() + " )"+ "in floor "+sensor.getFloorNo()+" in room : "
                    +sensor.getSmokeValue());

        }

    }
}
