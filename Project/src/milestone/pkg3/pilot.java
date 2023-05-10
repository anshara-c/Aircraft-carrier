package milestone.pkg3;

import java.io.Serializable;

public class pilot extends employee implements Serializable {

    private int pId;
    private String sqdrn;
    private String availability;
    private final static String UserName = "Pilot1234";
    private static int Password = 1234;

    public String getAvailability() {
        return availability;
    }

    public pilot(int pId, String sqdrn, String availability, String name) {
        super(name);
        this.pId = pId;
        this.sqdrn = sqdrn;
        this.availability = availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    public void setPassword(int Password) {
        this.Password = Password;
    }

    public static int  getPassword() {
        return Password;
    }

    public String isAvailability() {
        return availability;
    }

    public pilot(int pId, String sqdrn, String name) {
        super(name);
        this.pId = pId;
        this.sqdrn = sqdrn;
    }

    public void setpId(int pId) {
        this.pId = pId;
    }

    public void setSqdrn(String sqdrn) {
        this.sqdrn = sqdrn;
    }

    public int getpId() {
        return pId;
    }

    public String getSqdrn() {
        return sqdrn;
    }

    public static String getUserName() {
        return UserName;
    }

    @Override
    public String toString() {
        return "Pilot Name:" + getName() + "\n" + "Pilot ID: " + pId + "\n" + "Squadron number: " + sqdrn + "\n" + availability + "\n";
    }

    public void display() {
        System.out.println("nnnnnnn");
    }
};
