package fcu.app.signinapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class OrderActivity extends AppCompatActivity {

    //private Switch Switch_Favorite;

    private ListView lvFoods;
    private ListView lvFoodsSingle;
    private ListView lvFoodsDrinks;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        lvFoods = findViewById(R.id.lv_foods);
        lvFoodsSingle = findViewById(R.id.lv_foods_single);
        lvFoodsDrinks = findViewById(R.id.lv_foods_drinks);

        List<FoodItem> lsFoods = new ArrayList<FoodItem>();
        lsFoods.add(new FoodItem(R.drawable.preview,"1號餐",110));
        lsFoods.add(new FoodItem(R.drawable.preview,"2號餐",150));
        lsFoods.add(new FoodItem(R.drawable.preview,"3號餐",90));

        ListViewAdapter adapter = new ListViewAdapter(this,lsFoods);
        lvFoods.setAdapter(adapter);


        List<FoodItem> lsFoodsSingle = new ArrayList<FoodItem>();
        lsFoodsSingle.add(new FoodItem(R.drawable.preview,"蛋餅",20));
        lsFoodsSingle.add(new FoodItem(R.drawable.preview,"三明治",25));
        lsFoodsSingle.add(new FoodItem(R.drawable.preview,"炒麵",45));

        ListViewAdapter adapter_single = new ListViewAdapter(this,lsFoodsSingle);
        lvFoodsSingle.setAdapter(adapter_single);



        List<FoodItem> lsFoodsDrinks = new ArrayList<FoodItem>();
        lsFoodsDrinks.add(new FoodItem(R.drawable.preview,"奶茶",45));
        lsFoodsDrinks.add(new FoodItem(R.drawable.preview,"紅茶",25));
        lsFoodsDrinks.add(new FoodItem(R.drawable.preview,"柳橙汁",35));

        ListViewAdapter adapter_drinks = new ListViewAdapter(this,lsFoodsDrinks);
        lvFoodsDrinks.setAdapter(adapter_drinks);

    }




}