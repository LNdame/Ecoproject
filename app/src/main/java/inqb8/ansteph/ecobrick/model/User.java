package inqb8.ansteph.ecobrick.model;

/**
 * Created by loicstephan on 2018/07/21.
 */

public class User {


    int id;
    String firstname, lastname, username, joinDate, contact, usercode;


    public User(int id, String firstname, String lastname, String username, String joinDate, String contact, String usercode) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.username = username;
        this.joinDate = joinDate;
        this.contact = contact;
        this.usercode = usercode;
    }


    public User(String firstname, String lastname, String username, String joinDate, String contact, String usercode) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.username = username;
        this.joinDate = joinDate;
        this.contact = contact;
        this.usercode = usercode;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(String joinDate) {
        this.joinDate = joinDate;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getUsercode() {
        return usercode;
    }

    public void setUsercode(String usercode) {
        this.usercode = usercode;
    }
}
