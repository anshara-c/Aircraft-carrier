package milestone.pkg3;

import java.io.Serializable;

public class Person extends employee implements Serializable {

    String Relationship;

    public Person(String Relationship, String name, String lastname, String phone, String address) {
        super(name, lastname, phone, address);
        this.Relationship = Relationship;
    }

    public String getRelationship() {
        return Relationship;
    }

    public void setRelationship(String Relationship) {
        this.Relationship = Relationship;
    }

    @Override
    public String toString() {
        return "Person{" + "Relationship=" + Relationship + '}';
    }

}
