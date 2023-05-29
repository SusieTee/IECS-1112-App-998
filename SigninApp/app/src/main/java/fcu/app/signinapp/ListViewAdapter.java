package fcu.app.signinapp;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

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

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view == null){
            view = LayoutInflater.from(context).inflate(R.layout.food_item_layout,viewGroup,false);
        }

        FoodItem food = listFoods.get(i);

        ImageView iv = view.findViewById(R.id.iv_food_image1);
        iv.setImageResource(food.getImageID());

        return iv;
    }
}
