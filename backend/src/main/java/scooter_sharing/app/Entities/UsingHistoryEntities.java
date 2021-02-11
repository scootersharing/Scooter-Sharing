package scooter_sharing.app.Entities;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
public class UsingHistoryEntities implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long history_ID;
    private float start_longitude;
    private float start_latitude;
    private float end_longitude;
    private float end_latitude;
    private java.sql.Timestamp start_timestamp;
    private java.sql.Timestamp end_timestamp;
    @ManyToOne(targetEntity = ScooterEntities.class, fetch=FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinColumn(name = "scooter_ID", nullable = false,referencedColumnName = "scooter_ID")
    private ScooterEntities scooterEntities;

    @ManyToOne(targetEntity = UserEntities.class, fetch=FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinColumn(name = "user_ID", nullable = false,referencedColumnName = "user_ID")
    private UserEntities userEntities;
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (!(o instanceof UsingHistoryEntities)) return false;
//        UsingHistoryEntities that = (UsingHistoryEntities) o;
//        return Objects.equals(userEntities.getUser_ID(), that.userEntities.getUser_ID()) &&
//                Objects.equals(scooterEntities.getScooter_ID(), that.scooterEntities.getScooter_ID()) &&
//                Objects.equals(history_ID, that.history_ID);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(scooterEntities.getScooter_ID(), userEntities.getUser_ID(), history_ID);
//    }

    public UsingHistoryEntities(float start_longitude, float start_latitude, float end_longitude, float end_latitude, Timestamp start_timestamp, Timestamp end_timestamp, ScooterEntities scooterEntities, UserEntities userEntities) {
        this.start_longitude = start_longitude;
        this.start_latitude = start_latitude;
        this.end_longitude = end_longitude;
        this.end_latitude = end_latitude;
        this.start_timestamp = start_timestamp;
        this.end_timestamp = end_timestamp;
        this.scooterEntities = scooterEntities;
        this.userEntities = userEntities;
    }

    public ScooterEntities getScooters() {
        return scooterEntities;
    }

    public void setScooters(ScooterEntities scooterEntities) {
        this.scooterEntities = scooterEntities;
    }

    public UserEntities getUsers() {
        return userEntities;
    }

    public void setUsers(UserEntities userEntities) {
        this.userEntities = userEntities;
    }

    public long getHistory_ID() {
        return history_ID;
    }

    public void setHistory_ID(long history_ID) {
        this.history_ID = history_ID;
    }

    public UsingHistoryEntities() {

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
}
