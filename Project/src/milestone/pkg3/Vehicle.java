
package milestone.pkg3;

import java.io.Serializable;


public class Vehicle implements Serializable {
    private String Name;
    private int Number;

    public void setName(String Name) {
        this.Name = Name;
    }

    public void setNumber(int Number) {
        this.Number = Number;
    }

    public String getName() {
        return Name;
    }

    public int getNumber() {
        return Number;
    }

    public Vehicle(String Name, int Number) {
        this.Name = Name;
        this.Number = Number;
    }
    
}
