package scooter_sharing.app.Entities;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class UsingHistory implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long history_ID;
    private float start_longitude;
    private float start_latitude;
    private float end_longitude;
    private float end_latitude;
    private java.sql.Timestamp start_timestamp;
    private java.sql.Timestamp end_timestamp;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "scooter_ID")
    private Scooters scooters;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_ID")
    private Users users;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UsingHistory)) return false;
        UsingHistory that = (UsingHistory) o;
        return Objects.equals(users.getUser_ID(), that.users.getUser_ID()) &&
                Objects.equals(scooters.getScooter_ID(), that.scooters.getScooter_ID()) &&
                Objects.equals(history_ID, that.history_ID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(scooters.getScooter_ID(), users.getUser_ID(), history_ID);
    }

    public UsingHistory(float start_longitude, float start_latitude, float end_longitude, float end_latitude, Timestamp start_timestamp, Timestamp end_timestamp, Scooters scooters, Users users) {
        this.start_longitude = start_longitude;
        this.start_latitude = start_latitude;
        this.end_longitude = end_longitude;
        this.end_latitude = end_latitude;
        this.start_timestamp = start_timestamp;
        this.end_timestamp = end_timestamp;
        this.scooters = scooters;
        this.users = users;
    }

    public Scooters getScooters() {
        return scooters;
    }

    public void setScooters(Scooters scooters) {
        this.scooters = scooters;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public long getHistory_ID() {
        return history_ID;
    }

    public void setHistory_ID(long history_ID) {
        this.history_ID = history_ID;
    }

    public UsingHistory() {

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
