package fcu.app.signinapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class meal_list_item2 extends AppCompatActivity {

    private Button btnMealMangement;

    private ListView lvMainMeals;

    private DatabaseHandler databaseHandler;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meal_list_item2);

        btnMealMangement = findViewById(R.id.btn_meal_management);
        lvMainMeals = findViewById(R.id.lv_main_meals);

        databaseHandler = new DatabaseHandler(this);
        databaseHandler.open();
    }
    protected void onResume() {
        super.onResume();
        showAllMeals();
    }
    private void showAllMeals() {
        Cursor cursor = databaseHandler.getAllMeals();
        SimpleCursorAdapter adapter = new SimpleCursorAdapter(
                this,
                R.layout.meal_list_item1,
                cursor,
                new String[]{"name", "description", "price"},
                new int[]{R.id.tv_meal_name, R.id.tv_meal_description, R.id.tv_meal_price},
                0
        );
        lvMainMeals.setAdapter(adapter);
    }
}