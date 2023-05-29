package fcu.app.signinapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class OrderActivity extends AppCompatActivity {

    //private Switch Switch_Favorite;

    private ListView lvFoods;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        lvFoods = findViewById(R.id.lv_foods);

        List<FoodItem> lsFoods = new ArrayList<FoodItem>();
        lsFoods.add(new FoodItem(R.drawable.preview,"1號餐",110));
        lsFoods.add(new FoodItem(R.drawable.preview,"2號餐",150));
        lsFoods.add(new FoodItem(R.drawable.preview,"3號餐",90));

        ListViewAdapter adapter = new ListViewAdapter(this,lsFoods);
        lvFoods.setAdapter(adapter);

    }




}