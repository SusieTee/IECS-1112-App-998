package fcu.app.signinapp;

import java.io.Serializable;

public class CartItem implements Serializable {
    private int itemImg;
    private String itemName;
    private int itemAmount;
    private int itemPrice;

    public CartItem(int itemImg,String itemName, int itemAmount, int itemPrice) {
        this.itemImg = itemImg;
        this.itemName = itemName;
        this.itemAmount = itemAmount;
        this.itemPrice = itemPrice;
    }

    public int getItemImg() {
        return itemImg;
    }

    public String getItemName() {
        return itemName;
    }

    public int getItemAmount(){ return itemAmount;}

    public int getItemPrice() {
        return itemPrice;
    }
}
