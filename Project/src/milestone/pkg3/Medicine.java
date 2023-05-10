package milestone.pkg3;

import java.io.Serializable;

public class Medicine implements Serializable {

    private String flName;
    private String Medicine;

    public Medicine(String flName, String Medicine) {
        this.flName = flName;
        this.Medicine = Medicine;
    }

    public String getFlName() {
        return flName;
    }

    public String getMedicine() {
        return Medicine;
    }

    public void setFlName(String flName) {
        this.flName = flName;
    }

    public void setMedicine(String Medicine) {
        this.Medicine = Medicine;
    }

}
