package fcu.app.signinapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.content.Intent; //跳轉
import android.widget.AdapterView;//適配器
import java.util.ArrayList;
import java.util.List;

public class OrderActivity extends AppCompatActivity {

    //private Switch Switch_Favorite;

    private ListView lvFoods;
    private ListView lvFoodsSingle;
    private ListView lvFoodsDrinks;

    private String[] breakfastSetItems = {"1號餐", "2號餐", "3號餐"};
    private String[] breakfastSingleItems = {"蛋餅", "三明治", "炒麵"};
    private String[] breakfastDrinksItems = {"奶茶", "紅茶", "咖啡"};

    private Button home;
    private Button cart;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        lvFoods = findViewById(R.id.lv_foods);
        lvFoodsSingle = findViewById(R.id.lv_foods_single);
        lvFoodsDrinks = findViewById(R.id.lv_foods_drinks);

        home = findViewById(R.id.btn_order_home);
        cart = findViewById(R.id.btn_order_cart);
        //回到首頁
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OrderActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
        //

        //前往購物車
        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OrderActivity.this, meal_list_item2.class);
                startActivity(intent);
            }
        });
        //

        //套餐ListView區段
        List<FoodItem> lsFoods = new ArrayList<FoodItem>();
        lsFoods.add(new FoodItem(R.drawable.set_01,"1號餐",110));
        lsFoods.add(new FoodItem(R.drawable.set_02,"2號餐",150));
        lsFoods.add(new FoodItem(R.drawable.set_03,"3號餐",90));

        ListViewAdapter adapter = new ListViewAdapter(this,lsFoods);
        lvFoods.setAdapter((ListAdapter) adapter);

        lvFoods.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                FoodItem foodItem = lsFoods.get(position);

                Intent intent = new Intent(OrderActivity.this, SetDetailActivity.class);
                intent.putExtra("isDrink", false);
                intent.putExtra("food_img", foodItem.getFood_img());
                intent.putExtra("food_name", foodItem.getFood_name());
                intent.putExtra("food_price", foodItem.getFood_price());
                startActivity(intent);
            }
        });
        //


        //單點ListView區段
        List<FoodItem> lsFoodsSingle = new ArrayList<FoodItem>();
        lsFoodsSingle.add(new FoodItem(R.drawable.food_01,"蛋餅",20));
        lsFoodsSingle.add(new FoodItem(R.drawable.food_02,"三明治",25));
        lsFoodsSingle.add(new FoodItem(R.drawable.food_03,"炒麵",45));

        ListViewAdapter adapter_single = new ListViewAdapter(this,lsFoodsSingle);
        lvFoodsSingle.setAdapter((ListAdapter) adapter_single);

        lvFoodsSingle.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                FoodItem foodItemSingle = lsFoodsSingle.get(position);

                Intent intent = new Intent(OrderActivity.this, SetDetailActivity.class);
                intent.putExtra("isDrink", false);
                intent.putExtra("food_img", foodItemSingle.getFood_img());
                intent.putExtra("food_name", foodItemSingle.getFood_name());
                intent.putExtra("food_price", foodItemSingle.getFood_price());
                startActivity(intent);
            }
        });

        //


        //飲料ListView區段
        List<FoodItem> lsFoodsDrinks = new ArrayList<FoodItem>();
        lsFoodsDrinks.add(new FoodItem(R.drawable.drink_02,"奶茶",45));
        lsFoodsDrinks.add(new FoodItem(R.drawable.drink_01,"紅茶",25));
        lsFoodsDrinks.add(new FoodItem(R.drawable.drink_03,"咖啡",35));

        ListViewAdapter adapter_drinks = new ListViewAdapter(this,lsFoodsDrinks);
        lvFoodsDrinks.setAdapter((ListAdapter) adapter_drinks);

        lvFoodsDrinks.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                FoodItem foodDrink = lsFoodsDrinks.get(position);

                Intent intent = new Intent(OrderActivity.this, SetDetailActivity.class);
                intent.putExtra("isDrink", true);
                intent.putExtra("food_img", foodDrink.getFood_img());
                intent.putExtra("food_name", foodDrink.getFood_name());
                intent.putExtra("food_price", foodDrink.getFood_price());
                startActivity(intent);
            }
        });

        //

    }




}