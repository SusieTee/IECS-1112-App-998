package fcu.app.signinapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        lvFoods = findViewById(R.id.lv_foods);
        lvFoodsSingle = findViewById(R.id.lv_foods_single);
        lvFoodsDrinks = findViewById(R.id.lv_foods_drinks);


        //套餐ListView區段
        List<FoodItem> lsFoods = new ArrayList<FoodItem>();
        lsFoods.add(new FoodItem(R.drawable.set_01,"1號餐",110));
        lsFoods.add(new FoodItem(R.drawable.set_02,"2號餐",150));
        lsFoods.add(new FoodItem(R.drawable.set_03,"3號餐",90));

        ListViewAdapter adapter = new ListViewAdapter(this,lsFoods);
        lvFoods.setAdapter(adapter);

        lvFoods.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                String selectedItem = breakfastSetItems[position];

                Intent intent = new Intent(OrderActivity.this, SetDetailActivity.class);
                intent.putExtra("selectedItem", selectedItem);
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
        lvFoodsSingle.setAdapter(adapter_single);

        //


        //飲料ListView區段
        List<FoodItem> lsFoodsDrinks = new ArrayList<FoodItem>();
        lsFoodsDrinks.add(new FoodItem(R.drawable.drink_01,"奶茶",45));
        lsFoodsDrinks.add(new FoodItem(R.drawable.drink_02,"紅茶",25));
        lsFoodsDrinks.add(new FoodItem(R.drawable.drink_03,"咖啡",35));

        ListViewAdapter adapter_drinks = new ListViewAdapter(this,lsFoodsDrinks);
        lvFoodsDrinks.setAdapter(adapter_drinks);

        //

    }




}