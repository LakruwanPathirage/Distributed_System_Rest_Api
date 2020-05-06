import model.Sensor;

public class EmailServer {

    public static void sendEmail(Sensor sensor){


        if (sensor.isSmokeAlertStatus()){
            System.out.println("Email Sent :");
            System.out.println("Detected High Smoke level ( "+sensor.getSmokeValue() + " )"+ "in floor "+sensor.getFloorNo()+" in room : "
                    +sensor.getSmokeValue());

        }

        if (sensor.isCo2AlertStatus()){
            System.out.println("Email Sent :");
            System.out.println("Detected High C02 level ( "+sensor.getCo2Value() + " )"+ "in floor "+sensor.getFloorNo()+" in room : "
                    +sensor.getSmokeValue());

        }

    }
}
