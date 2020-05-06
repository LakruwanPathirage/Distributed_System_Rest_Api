package model;

public class Sensor {

    private String id ;
    private String roomNo;
    private String floorNo;
    private int co2Value;
    private int smokeValue;
    private  boolean status;

    public Sensor(String id, String roomNo, String floorNo, int co2Value, int smokeValue, boolean status) {
        this.id = id;
        this.roomNo = roomNo;
        this.floorNo = floorNo;
        this.co2Value = co2Value;
        this.smokeValue = smokeValue;
        this.status = status;
    }

    public Sensor() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(String roomNo) {
        this.roomNo = roomNo;
    }

    public String getFloorNo() {
        return floorNo;
    }

    public void setFloorNo(String floorNo) {
        this.floorNo = floorNo;
    }

    public int getCo2Value() {
        return co2Value;
    }

    public void setCo2Value(int co2Value) {
        this.co2Value = co2Value;
    }

    public int getSmokeValue() {
        return smokeValue;
    }

    public void setSmokeValue(int smokeValue) {
        this.smokeValue = smokeValue;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Sensor{" +
                "id='" + id + '\'' +
                ", roomNo='" + roomNo + '\'' +
                ", floorNo='" + floorNo + '\'' +
                ", co2Value=" + co2Value +
                ", smokeValue=" + smokeValue +
                ", status=" + status +
                '}';
    }
}


