package controller;

import model.Sensor;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class ApiConnection {


    public  ArrayList<Sensor> getItemsWithAlert() throws Exception {
        ArrayList<Sensor> faList = new ArrayList<>();
        JSONArray myResponse ;
        try {
            String url = "http://localhost:4000/monitoring/details/";
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            // optional default is GET
            con.setRequestMethod("GET");
            //add request header
            con.setRequestProperty("User-Agent", "Mozilla/5.0");
            int responseCode = con.getResponseCode();

            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();


            myResponse = new JSONArray(response.toString());

            JSONObject sensor;

            for (int i = 0; i < myResponse.length(); i++) {
                sensor =  myResponse.getJSONObject(i);

                Sensor currentSensor = new Sensor();

                currentSensor.setCo2AlertStatus(sensor.getBoolean("co2_Alert"));
                currentSensor.setSmokeAlertStatus(sensor.getBoolean("smoke_Alert"));

                //fileter objects with alert status true
                if (currentSensor.isCo2AlertStatus() || currentSensor.isSmokeAlertStatus()) {
                    currentSensor.setStatus(sensor.getBoolean("status"));
                    currentSensor.setId(String.valueOf(sensor.getString("_id")));
                    currentSensor.setFloorNo(String.valueOf(sensor.getInt("floorNo")));
                    currentSensor.setRoomNo(String.valueOf(sensor.getInt("roomNo")));
                    currentSensor.setSmokeValue(Integer.valueOf(sensor.getInt("smokelevel")));
                    currentSensor.setCo2Value(Integer.valueOf(sensor.getInt("co2_level")));
                    faList.add(currentSensor);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return faList;
    }

    public void updateAlertStatus(Sensor sensor) throws Exception {

        final String POST_PARAMS =
                "{\n" + "\"status\": "+sensor.isStatus()+",\r\n" +
                        "    \"floorNo\": "+sensor.getFloorNo()+",\r\n" +
                        "    \"roomNo\": "+sensor.getRoomNo()+",\r\n" +
                        "    \"smokelevel\":"+sensor.getSmokeValue()+",\r\n" +
                        "    \"co2_Alert\":"+false+",\r\n" +
                        "    \"smoke_Alert\":"+false+",\r\n" +
                        "    \"co2_level\": "+sensor.getCo2Value()+"" + "\n}";


        URL obj = new URL("http://localhost:4000/monitoring/details/"+sensor.getId());
        HttpURLConnection postConnection = (HttpURLConnection) obj.openConnection();
        postConnection.setRequestMethod("PUT");
        postConnection.setRequestProperty("Content-Type", "application/json");
        postConnection.setDoOutput(true);
        OutputStream os = postConnection.getOutputStream();
        os.write(POST_PARAMS.getBytes());
        os.flush();
        os.close();
        int responseCode = postConnection.getResponseCode();

        int req=HttpURLConnection.HTTP_CREATED ;

        if (responseCode == (req-1)) { //success
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    postConnection.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in .readLine()) != null) {
                response.append(inputLine);
            } in .close();


        } else {
            System.out.println("UPDATE NOT WORKED");
        }


    }
}
