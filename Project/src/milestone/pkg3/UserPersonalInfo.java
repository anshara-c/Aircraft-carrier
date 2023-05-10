package milestone.pkg3;

import java.io.Serializable;

public class UserPersonalInfo extends employee implements Serializable {

    private String Allergy;
    private String Sickness;

    public UserPersonalInfo(String name, String lastname, String bloodgroup, String phone, String address, String height, int weight, String Allergy, String Sickness) {
        super(name, lastname, bloodgroup, phone, address, height, weight);
        this.Allergy = Allergy;
        this.Sickness = Sickness;
    }

    public String getAllergy() {
        return Allergy;
    }

    public String getSickness() {
        return Sickness;
    }

    public void setAllergy(String Allergy) {
        this.Allergy = Allergy;
    }

    public void setSickness(String Sickness) {
        this.Sickness = Sickness;
    }

    @Override
    public String toString() {
        return getName() + getLastname() + "\n" + "Allergy: \n" + Allergy + " Sickness: \n" + Sickness;
    }

    void display() {
        System.out.println("UserPersonalInfo{" + "Allergy=" + Allergy + ", Sickness=" + Sickness + "]");
    }
}
