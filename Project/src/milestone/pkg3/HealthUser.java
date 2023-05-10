/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package milestone.pkg3;

import java.io.Serializable;

/**
 *
 * @author DELL
 */
public class HealthUser extends employee implements Serializable{
    String Temperature;
    int BloodPressure;
    String Gender;
    String User;
    String PhysicalInjury;

    public String getTemperature() {
        return Temperature;
    }

    public int getBloodPressure() {
        return BloodPressure;
    }

    public String getGender() {
        return Gender;
    }

    public String getUser() {
        return User;
    }

    public String getPhysicalInjury() {
        return PhysicalInjury;
    }

    public void setTemperature(String Temperature) {
        this.Temperature = Temperature;
    }

    public void setBloodPressure(int BloodPressure) {
        this.BloodPressure = BloodPressure;
    }

    public void setGender(String Gender) {
        this.Gender = Gender;
    }

    public void setUser(String User) {
        this.User = User;
    }

    public void setPhysicalInjury(String PhysicalInjury) {
        this.PhysicalInjury = PhysicalInjury;
    }

    public HealthUser(String Temperature, int BloodPressure, String Gender, String User, String PhysicalInjury, String name, String lastname) {
        super(name, lastname);
        this.Temperature = Temperature;
        this.BloodPressure = BloodPressure;
        this.Gender = Gender;
        this.User = User;
        this.PhysicalInjury = PhysicalInjury;
    }
    void display(){
        System.out.println("user"+ getUser()+ "Gender" + getGender() + "name" + getName());
    }
}
