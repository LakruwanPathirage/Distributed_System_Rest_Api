package controller;

import model.Sensor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;



public class SendDataToApi {


    public String makeRequest(Sensor sensor) throws IOException, InterruptedException {

        ArrayList<Sensor> faList = new ArrayList<>();
        String id = null;

        final String POST_PARAMS =
                "{\n" + "\"status\": "+sensor.isStatus()+",\r\n" +
                        "    \"floorNo\": "+sensor.getFloorNo()+",\r\n" +
                        "    \"roomNo\": "+sensor.getRoomNo()+",\r\n" +
                        "    \"smokelevel\":"+sensor.getSmokeValue()+",\r\n" +
                        "    \"co2_level\": "+sensor.getCo2Value()+"" + "\n}";

        System.out.println(POST_PARAMS);

        URL obj = new URL("http://localhost:4000/monitoring/details/");
        HttpURLConnection postConnection = (HttpURLConnection) obj.openConnection();
        postConnection.setRequestMethod("POST");
        //postConnection.setRequestProperty("IdNumber","101");
        postConnection.setRequestProperty("Content-Type", "application/json");
        postConnection.setDoOutput(true);
        OutputStream os = postConnection.getOutputStream();
        os.write(POST_PARAMS.getBytes());
        os.flush();
        os.close();
        int responseCode = postConnection.getResponseCode();
        System.out.println("POST Response Code :  " + responseCode);
        System.out.println("POST Response Message : " + postConnection.getResponseMessage());
        int req=HttpURLConnection.HTTP_CREATED ;

        if (responseCode == (req-1)) { //success
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    postConnection.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in .readLine()) != null) {
                response.append(inputLine);
            } in .close();
            // print result

            String responseStr = response.toString();
            System.out.println(responseStr);
            id = responseStr.substring(responseStr.indexOf("_id\":") + 6, responseStr.indexOf(",\"floorNo\"")-1);
            System.out.println(id);


        } else {
            System.out.println("POST NOT WORKED");
        }
        return id;
        }

    public void updateData(Sensor sensor) throws Exception {

        final String POST_PARAMS =
                "{\n" + "\"status\": "+sensor.isStatus()+",\r\n" +
                        "    \"floorNo\": "+sensor.getFloorNo()+",\r\n" +
                        "    \"roomNo\": "+sensor.getRoomNo()+",\r\n" +
                        "    \"smokelevel\":"+sensor.getSmokeValue()+",\r\n" +
                        "    \"co2_level\": "+sensor.getCo2Value()+"" + "\n}";

        System.out.println(POST_PARAMS);

        URL obj = new URL("http://localhost:4000/monitoring/details/"+sensor.getId());
        HttpURLConnection postConnection = (HttpURLConnection) obj.openConnection();
        postConnection.setRequestMethod("PUT");
        //postConnection.setRequestProperty("IdNumber","101");
        postConnection.setRequestProperty("Content-Type", "application/json");
        postConnection.setDoOutput(true);
        OutputStream os = postConnection.getOutputStream();
        os.write(POST_PARAMS.getBytes());
        os.flush();
        os.close();
        int responseCode = postConnection.getResponseCode();
        System.out.println("POST Response Code :  " + responseCode);
        System.out.println("POST Response Message : " + postConnection.getResponseMessage());
        int req=HttpURLConnection.HTTP_CREATED ;

        if (responseCode == (req-1)) { //success
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    postConnection.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in .readLine()) != null) {
                response.append(inputLine);
            } in .close();

            // print result
            System.out.println(response.toString());


        } else {
            System.out.println("UPDATE NOT WORKED");
        }


    }

    public void deleteData(Sensor sensor) throws Exception {



        URL obj = new URL("http://localhost:4000/monitoring/details/"+sensor.getId());
        HttpURLConnection postConnection = (HttpURLConnection) obj.openConnection();
        postConnection.setRequestMethod("DELETE");
        //postConnection.setRequestProperty("IdNumber","101");
        postConnection.setRequestProperty("Content-Type", "application/json");
        postConnection.setDoOutput(true);
        OutputStream os = postConnection.getOutputStream();
        os.flush();
        os.close();
        int responseCode = postConnection.getResponseCode();
        System.out.println("POST Response Code :  " + responseCode);
        System.out.println("POST Response Message : " + postConnection.getResponseMessage());
        int req=HttpURLConnection.HTTP_CREATED ;

        if (responseCode == (req-1)) { //success
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    postConnection.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in .readLine()) != null) {
                response.append(inputLine);
            } in .close();
            // print result
            System.out.println(response.toString());


        } else {
            System.out.println("DELETE NOT WORKED");
        }

    }

}