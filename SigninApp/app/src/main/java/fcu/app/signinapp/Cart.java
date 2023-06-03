package fcu.app.signinapp;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private static Cart instance;
    private List<CartItem> cartItemList;

    private Cart() {
        cartItemList = new ArrayList<>();
    }

    public static Cart getInstance() {
        if (instance == null) {
            instance = new Cart();
        }
        return instance;
    }

    public List<CartItem> getCartItemList() {
        return cartItemList;
    }

    public void addToCart(CartItem item) {
        cartItemList.add(item);
    }

    public void removeFromCart(CartItem item) {
        cartItemList.remove(item);
    }

    public void clearCart() {
        cartItemList.clear();
    }
}
