package inqb8.ansteph.ecobrick.model;

import java.io.Serializable;

/**
 * Created by loicstephan on 2018/07/21.
 */

public class Depot implements Serializable {

    int id;

    String name, address,contact_person, contact_number ;
    String latitude,longitude,status;
    String openHour, closeHour;
    String description;


    byte [] logo;


    public Depot(int id, String name, String address, String contact_person, String contact_number, String latitude, String longitude, String status, String openHour, String closeHour, String description) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.contact_person = contact_person;
        this.contact_number = contact_number;
        this.latitude = latitude;
        this.longitude = longitude;
        this.status = status;
        this.openHour = openHour;
        this.closeHour = closeHour;
        this.description = description;
    }

    public Depot(String name, String address, String contact_person, String contact_number, String latitude, String longitude, String status, String openHour, String closeHour, String description) {
        this.name = name;
        this.address = address;
        this.contact_person = contact_person;
        this.contact_number = contact_number;
        this.latitude = latitude;
        this.longitude = longitude;
        this.status = status;
        this.openHour = openHour;
        this.closeHour = closeHour;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContact_person() {
        return contact_person;
    }

    public void setContact_person(String contact_person) {
        this.contact_person = contact_person;
    }

    public String getContact_number() {
        return contact_number;
    }

    public void setContact_number(String contact_number) {
        this.contact_number = contact_number;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getOpenHour() {
        return openHour;
    }

    public void setOpenHour(String openHour) {
        this.openHour = openHour;
    }

    public String getCloseHour() {
        return closeHour;
    }

    public void setCloseHour(String closeHour) {
        this.closeHour = closeHour;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
