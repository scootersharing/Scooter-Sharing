package scooter_sharing.app.Entities;

import java.sql.Timestamp;

public class UsingHistoryModel {
    private float start_longitude;
    private float start_latitude;
    private float end_longitude;
    private float end_latitude;
    private java.sql.Timestamp start_timestamp;
    private java.sql.Timestamp end_timestamp;
    private long scooter_ID;
    private long user_ID;

    public UsingHistoryModel(float start_longitude, float start_latitude, float end_longitude, float end_latitude, Timestamp start_timestamp, Timestamp end_timestamp, long scooter_ID, long user_ID) {
        this.start_longitude = start_longitude;
        this.start_latitude = start_latitude;
        this.end_longitude = end_longitude;
        this.end_latitude = end_latitude;
        this.start_timestamp = start_timestamp;
        this.end_timestamp = end_timestamp;
        this.scooter_ID = scooter_ID;
        this.user_ID = user_ID;
    }

    public UsingHistoryModel() {
    }

    public float getStart_longitude() {
        return start_longitude;
    }

    public void setStart_longitude(float start_longitude) {
        this.start_longitude = start_longitude;
    }

    public float getStart_latitude() {
        return start_latitude;
    }

    public void setStart_latitude(float start_latitude) {
        this.start_latitude = start_latitude;
    }

    public float getEnd_longitude() {
        return end_longitude;
    }

    public void setEnd_longitude(float end_longitude) {
        this.end_longitude = end_longitude;
    }

    public float getEnd_latitude() {
        return end_latitude;
    }

    public void setEnd_latitude(float end_latitude) {
        this.end_latitude = end_latitude;
    }

    public Timestamp getStart_timestamp() {
        return start_timestamp;
    }

    public void setStart_timestamp(Timestamp start_timestamp) {
        this.start_timestamp = start_timestamp;
    }

    public Timestamp getEnd_timestamp() {
        return end_timestamp;
    }

    public void setEnd_timestamp(Timestamp end_timestamp) {
        this.end_timestamp = end_timestamp;
    }

    public long getScooter_ID() {
        return scooter_ID;
    }

    public void setScooter_ID(long scooter_ID) {
        this.scooter_ID = scooter_ID;
    }

    public long getUser_ID() {
        return user_ID;
    }

    public void setUser_ID(long user_ID) {
        this.user_ID = user_ID;
    }
}
