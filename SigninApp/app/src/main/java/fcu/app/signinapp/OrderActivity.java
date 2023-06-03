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
    private String[] breakfastDrinksItems = {"奶茶", "紅茶", "柳橙汁"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        lvFoods = findViewById(R.id.lv_foods);
        lvFoodsSingle = findViewById(R.id.lv_foods_single);
        lvFoodsDrinks = findViewById(R.id.lv_foods_drinks);


        //套餐ListView區段
        List<FoodItem> lsFoods = new ArrayList<FoodItem>();
        lsFoods.add(new FoodItem(R.drawable.preview,"1號餐",110));
        lsFoods.add(new FoodItem(R.drawable.preview,"2號餐",150));
        lsFoods.add(new FoodItem(R.drawable.preview,"3號餐",90));

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
        lsFoodsSingle.add(new FoodItem(R.drawable.preview,"蛋餅",20));
        lsFoodsSingle.add(new FoodItem(R.drawable.preview,"三明治",25));
        lsFoodsSingle.add(new FoodItem(R.drawable.preview,"炒麵",45));

        ListViewAdapter adapter_single = new ListViewAdapter(this,lsFoodsSingle);
        lvFoodsSingle.setAdapter(adapter_single);

        lvFoodsSingle.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                String selectedItem = breakfastSingleItems[position];

                Intent intent = new Intent(OrderActivity.this, SingleDetailActivity.class);
                intent.putExtra("selectedItem", selectedItem);
                startActivity(intent);
            }
        });

        //


        //飲料ListView區段
        List<FoodItem> lsFoodsDrinks = new ArrayList<FoodItem>();
        lsFoodsDrinks.add(new FoodItem(R.drawable.preview,"奶茶",45));
        lsFoodsDrinks.add(new FoodItem(R.drawable.preview,"紅茶",25));
        lsFoodsDrinks.add(new FoodItem(R.drawable.preview,"柳橙汁",35));

        ListViewAdapter adapter_drinks = new ListViewAdapter(this,lsFoodsDrinks);
        lvFoodsDrinks.setAdapter(adapter_drinks);

        lvFoodsDrinks.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                String selectedItem = breakfastDrinksItems[position];

                Intent intent = new Intent(OrderActivity.this, DrinksDetailActivity.class);
                intent.putExtra("selectedItem", selectedItem);
                startActivity(intent);
            }
        });

        //

    }




}