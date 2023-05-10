package milestone.pkg3;

import java.io.Serializable;
import java.time.LocalDate;
import javafx.beans.property.SimpleStringProperty;

public abstract class employee implements Serializable{
    private String name;
    private String lastname;
    private String bloodgroup;
    private String phone;
    private String address;
    private String height;
    private int weight;

    public employee(String name, String lastname, String bloodgroup, String phone, String address, String height, int weight) {
        this.name = name;
        this.lastname = lastname;
        this.bloodgroup = bloodgroup;
        this.phone = phone;
        this.address = address;
        this.height = height;
        this.weight = weight;
    }

    public employee(String name, String lastname) {
        this.name = name;
        this.lastname = lastname;
    }

    public employee(String name, String lastname, String phone, String address) {
        this.name = name;
        this.lastname = lastname;
        this.phone = phone;
        this.address = address;
    }

    @Override
    public String toString() {
        return "employee{" + "name=" + name + ", lastname=" + lastname + ", bloodgroup=" + bloodgroup + ", phone=" + phone + ", address=" + address + ", height=" + height + ", weight=" + weight + '}';
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setBloodgroup(String bloodgroup) {
        this.bloodgroup = bloodgroup;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getLastname() {
        return lastname;
    }

    public String getBloodgroup() {
        return bloodgroup;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public String getHeight() {
        return height;
    }

    public int getWeight() {
        return weight;
    }


    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        //return firstName;
        return name;
    }
    public employee(String name) {
        this.name = name;
    }
}
