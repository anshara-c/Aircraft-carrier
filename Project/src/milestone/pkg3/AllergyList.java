package milestone.pkg3;

import java.io.Serializable;

public class AllergyList implements Serializable {

    String iName, A1, A2, A3, A4, NoFood;

    public String getiName() {
        return iName;
    }

    public String getA1() {
        return A1;
    }

    public String getA2() {
        return A2;
    }

    public String getA3() {
        return A3;
    }

    public String getA4() {
        return A4;
    }

    public String getNoFood() {
        return NoFood;
    }

    public void setiName(String iName) {
        this.iName = iName;
    }

    public void setA1(String A1) {
        this.A1 = A1;
    }

    public void setA2(String A2) {
        this.A2 = A2;
    }

    public void setA3(String A3) {
        this.A3 = A3;
    }

    public void setA4(String A4) {
        this.A4 = A4;
    }

    public void setNoFood(String NoFood) {
        this.NoFood = NoFood;
    }

    public AllergyList(String iName, String A1, String A2, String A3, String A4, String NoFood) {
        this.iName = iName;
        this.A1 = A1;
        this.A2 = A2;
        this.A3 = A3;
        this.A4 = A4;
        this.NoFood = NoFood;
    }

}
