package milestone.pkg3;

import java.io.Serializable;

public class food implements Serializable {

    private String FoodName;
    private int Quantity;

    public food(String FoodName, int Quantity) {
        this.FoodName = FoodName;
        this.Quantity = Quantity;
    }

    public String getFoodName() {
        return FoodName;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setFoodName(String FoodName) {
        this.FoodName = FoodName;
    }

    public void setQuantity(int Quantity) {
        this.Quantity = Quantity;
    }

    @Override
    public String toString() {
        return "Food{" + "FoodName=" + FoodName + ", Quantity=" + Quantity + '}';
    }

}
