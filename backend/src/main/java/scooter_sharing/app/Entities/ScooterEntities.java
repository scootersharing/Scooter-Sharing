package scooter_sharing.app.Entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class ScooterEntities implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "scooter_ID")
    private long scooter_ID;
    private float charge;
    private boolean is_active;
    private float longitude;
    private float latitude;
    @OneToMany(mappedBy="scooterEntities")
    private List<UsingHistoryEntities> usingHistoryEntities;
//    @OneToMany(mappedBy = "scooters")
//    Set<UsingHistoryEntities> usinghistories;
//
//    public Set<UsingHistoryEntities> getUsinghistories() {
//        return usinghistories;
//    }
//
//    public void setUsinghistories(Set<UsingHistoryEntities> usinghistories) {
//        this.usinghistories = usinghistories;
//    }

    //    @OneToMany(mappedBy = "scooters", cascade = CascadeType.PERSIST)
//    private Set<UsingHistoryEntities> usingHistoryEntities;

//    public Set<UsingHistoryEntities> getUsingHistory() {
//        return usingHistoryEntities;
//    }
//
//    public void setUsingHistory(Set<UsingHistoryEntities> usingHistoryEntities) {
//        this.usingHistoryEntities = usingHistoryEntities;
//    }

    public ScooterEntities() {
        charge = 0;
        is_active = false;
        longitude = 0;
        latitude = 0;
    }

    public ScooterEntities(float charge) {
        this.charge = charge;
        is_active = false;
        longitude = 0;
        latitude = 0;
    }

    public ScooterEntities(float longitude, float latitude) {
        this.longitude = longitude;
        this.latitude = latitude;
        charge = 0;
        is_active = false;
    }

    public ScooterEntities(float charge, boolean is_active, float longitude, float latitude) {
        this.charge = charge;
        this.is_active = is_active;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public long getScooter_ID() {
        return scooter_ID;
    }

    public void setScooter_ID(long scooter_ID) {
        this.scooter_ID = scooter_ID;
    }

    public float getCharge() {
        return charge;
    }

    public void setCharge(float charge) {
        this.charge = charge;
    }

    public boolean isIs_active() {
        return is_active;
    }

    public void setIs_active(boolean is_active) {
        this.is_active = is_active;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }
}
