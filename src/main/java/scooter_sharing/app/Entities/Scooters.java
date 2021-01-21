package scooter_sharing.app.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Scooters {
    @Id
    @GeneratedValue
    private long scooter_ID;
    private float charge;
    private boolean is_active;
    private float longitude;
    private float latitude;


    public Scooters() {
        charge = 0;
        is_active = false;
        longitude = 0;
        latitude = 0;
    }

    public Scooters(float charge) {
        this.charge = charge;
        is_active = false;
        longitude = 0;
        latitude = 0;
    }

    public Scooters(float longitude, float latitude) {
        this.longitude = longitude;
        this.latitude = latitude;
        charge = 0;
        is_active = false;
    }

    public Scooters(float charge, boolean is_active, float longitude, float latitude) {
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
