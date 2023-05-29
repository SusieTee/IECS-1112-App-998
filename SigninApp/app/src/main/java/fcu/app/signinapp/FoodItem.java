package fcu.app.signinapp;

public class FoodItem {

    private int imageID;
    private String foodName;
    private int foodPrice;

    public FoodItem(int imageID, String foodName, int foodPrice) {
        this.imageID = imageID;
        this.foodName = foodName;
        this.foodPrice = foodPrice;
    }

    public int getImageID() {
        return imageID;
    }

    public void setImageID(int imageID) {
        this.imageID = imageID;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public int getFoodPrice() {
        return foodPrice;
    }

    public void setFoodPrice(int foodPrice) {
        this.foodPrice = foodPrice;
    }
}
