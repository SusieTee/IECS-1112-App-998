package fcu.app.signinapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.time.temporal.Temporal;
import java.util.List;

public class ListViewAdapter extends BaseAdapter {

    private Context context;
    private List<FoodItem> listFoods;

    public ListViewAdapter(Context context, List<FoodItem> listFoods) {
        this.context = context;
        this.listFoods = listFoods;
    }

    @Override
    public int getCount() {
        return listFoods.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }


    @SuppressLint("SetTextI18n")
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.food_item_layout, viewGroup, false);
        }

        FoodItem food = listFoods.get(i);

        ImageView iv = view.findViewById(R.id.iv_food_image);
        iv.setImageResource(food.getFood_img());

        TextView tvFoodName = view.findViewById(R.id.tv_food_name);
        tvFoodName.setText(food.getFood_name());

        TextView tvFoodPrice = view.findViewById(R.id.tv_food_price);
        tvFoodPrice.setText("$" + food.getFood_price());
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 在這裡執行項目點擊後的操作，例如跳轉到詳細菜品資訊頁面
                Intent intent = new Intent(context, SetDetailActivity.class);
                intent.putExtra("food_img", food.getFood_img());
                intent.putExtra("food_name", food.getFood_name());
                intent.putExtra("food_price", food.getFood_price());
                context.startActivity(intent);
            }
        });

        return view;
    }
}