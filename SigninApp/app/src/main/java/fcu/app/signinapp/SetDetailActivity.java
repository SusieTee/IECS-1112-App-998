package fcu.app.signinapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class SetDetailActivity extends AppCompatActivity {


    private ImageView imFood;
    private TextView tvTitle;
    private CheckBox cbEgg;
    private CheckBox cbSauce;
    private CheckBox cbChess;
    private Button btnsub;
    private TextView tvAmountNumber;
    private Button btnadd;
    private TextView tvTotal;
    private Button btnAddToCart;

    @SuppressLint("CutPasteId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_detail);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        Bundle extras = getIntent().getExtras();
        int foodImg = extras.getInt("food_img");
        String foodName = extras.getString("food_name");
        String foodPrice = extras.getString("food_price");

        imFood = findViewById(R.id.im_food);
        tvTitle = findViewById(R.id.tv_title);
        cbEgg = findViewById(R.id.cb_egg);
        cbChess = findViewById(R.id.cb_chess);
        cbSauce = findViewById(R.id.cb_chess);
        btnsub = findViewById(R.id.btn_sub);
        btnadd = findViewById(R.id.btn_add);
        tvAmountNumber = findViewById(R.id.tv_amount_number);
        tvTotal = findViewById(R.id.tv_total);
        btnAddToCart = findViewById(R.id.btn_add_to_cart);

        tvTitle.setText(foodName);
        String priceString = foodPrice.substring(1);
        tvTotal.setText(priceString);

        View.OnClickListener onClickListener = new View.OnClickListener() {

            int amount = Integer.parseInt(tvAmountNumber.getText().toString());
            int total = Integer.parseInt(tvTotal.getText().toString());
            int price = Integer.parseInt(priceString);


            @Override
            public void onClick(View v) {

                    if (v.getId() == R.id.cb_egg) {
                        if (cbEgg.isChecked()) {
                            price += 10;
                        } else {
                            price -= 10;
                        }
                    } else if (v.getId() == R.id.cb_sauce) {
                        if (cbSauce.isChecked()) {
                            price += 5;
                        } else {
                            price -= 5;
                        }
                    } else if (v.getId() == R.id.cb_chess) {
                        if (cbChess.isChecked()) {
                            price += 5;
                        } else {
                            price -= 5;
                        }
                    } else if (v.getId() == R.id.btn_sub) {
                        if (amount <= 0) {
                            Toast.makeText(SetDetailActivity.this, "數量不可小於0", Toast.LENGTH_SHORT).show();
                        } else {
                            amount--;
                        }
                    } else if (v.getId() == R.id.btn_add) {
                        amount++;
                    } else if (v.getId() == R.id.btn_add_to_cart) {
                        Toast.makeText(SetDetailActivity.this, "共" + total + "元，已加入購物車", Toast.LENGTH_SHORT).show();
                        Cart.getInstance().addToCart(new CartItem(foodImg, foodName, amount, total));
                        finish();
                    }
                total = price * amount;
                tvAmountNumber.setText(String.valueOf(amount));
                tvTotal.setText(String.valueOf(total));
            }
        };
        cbEgg.setOnClickListener(onClickListener);
        cbSauce.setOnClickListener(onClickListener);
        cbChess.setOnClickListener(onClickListener);
        btnsub.setOnClickListener(onClickListener);
        btnadd.setOnClickListener(onClickListener);
        btnAddToCart.setOnClickListener(onClickListener);
    }
}