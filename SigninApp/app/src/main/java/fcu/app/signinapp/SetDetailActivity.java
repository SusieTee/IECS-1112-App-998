package fcu.app.signinapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class SetDetailActivity extends AppCompatActivity {

    private DatabaseHandler databaseHandler;
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
    private TextView tv_extramoney;
    private TextView tv_extramoney2;
    private TextView tv_extramoney3;
    private TextView tv_option;

    @SuppressLint("CutPasteId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_detail);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        Bundle extras = getIntent().getExtras();
        //Intent intent = getIntent();
        Boolean isDrink = extras.getBoolean("isDrink");
        int foodImg = extras.getInt("food_img");
        String foodName = extras.getString("food_name");
        int foodPrice = extras.getInt("food_price");
        System.out.println("Foodimg: "+ foodImg);
        System.out.println("Foodname: "+ foodName);
        System.out.println("foodPrice: "+ foodPrice);

        imFood = findViewById(R.id.im_food);
        tvTitle = findViewById(R.id.tv_title);
        cbEgg = findViewById(R.id.cb_egg);
        cbChess = findViewById(R.id.cb_chess);
        cbSauce = findViewById(R.id.cb_sauce);
        btnsub = findViewById(R.id.btn_sub);
        btnadd = findViewById(R.id.btn_add);
        tvAmountNumber = findViewById(R.id.tv_amount_number);
        tvTotal = findViewById(R.id.tv_total);
        btnAddToCart = findViewById(R.id.btn_add_to_cart);
        tv_extramoney = findViewById(R.id.tv_extramoney_1);
        tv_extramoney2 = findViewById(R.id.tv_extramoney_2);
        tv_extramoney3 = findViewById(R.id.tv_extramoney_3);
        tv_option = findViewById(R.id.tv_option);

        databaseHandler = new DatabaseHandler(this);
        databaseHandler.open();

        tvTitle.setText(foodName);
        System.out.println(isDrink);
        if(isDrink == true){
            tv_option.setVisibility(View.INVISIBLE);
            tv_extramoney.setVisibility(View.INVISIBLE);
            tv_extramoney2.setVisibility(View.INVISIBLE);
            tv_extramoney3.setVisibility(View.INVISIBLE);
            cbChess.setVisibility(View.INVISIBLE);
            cbSauce.setVisibility(View.INVISIBLE);
            cbEgg.setVisibility(View.INVISIBLE);
        }
        imFood.setImageResource(foodImg);
        String priceString = String.valueOf(foodPrice);
        tvTotal.setText(priceString);

        View.OnClickListener onClickListener = new View.OnClickListener() {

            int amount = Integer.parseInt(tvAmountNumber.getText().toString());
            int total = Integer.parseInt(tvTotal.getText().toString());
            int price = Integer.parseInt(priceString);


            @Override
            public void onClick(View v) {
                if (v == cbEgg) {
                    if (cbEgg.isChecked()) {
                        price += 10;
                    } else {
                        price -= 10;
                    }
                } else if (v == cbSauce) {
                    if (cbSauce.isChecked()) {
                        price += 5;
                    } else {
                        price -= 5;
                    }
                } else if (v == cbChess) {
                    if (cbChess.isChecked()) {
                        price += 5;
                    } else {
                        price -= 5;
                    }
                } else if (v == btnsub) {
                    if (amount <= 1) {
                        Toast.makeText(SetDetailActivity.this, "數量不可小於0", Toast.LENGTH_SHORT).show();
                    } else {
                        amount--;
                    }
                } else if (v == btnadd) {
                    amount++;
                } else if (v == btnAddToCart) {
                    Toast.makeText(SetDetailActivity.this, "共" + total + "元，已加入購物車", Toast.LENGTH_SHORT).show();
                    databaseHandler.addMeal(foodName, "", total);
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
        protected void onDestroy(){
            super.onDestroy();
            databaseHandler.close();
    }
}