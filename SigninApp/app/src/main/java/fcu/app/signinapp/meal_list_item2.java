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
import android.widget.TextView;
import android.widget.Toast;

public class meal_list_item2 extends AppCompatActivity {

    private Button btnMealMangement;

    private ListView lvMainMeals;

    private DatabaseHandler databaseHandler;

    private SimpleCursorAdapter adapter;
    private TextView totalAmount;

    private Button home;
    private Button order;

    @SuppressLint({"MissingInflatedId", "Range"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meal_list_item2);
        int total = 0;
        totalAmount =findViewById(R.id.tv_total);
        btnMealMangement = findViewById(R.id.btn_meal_management);
        lvMainMeals = findViewById(R.id.lv_main_meals);


        databaseHandler = new DatabaseHandler(this);
        databaseHandler.open();

        adapter = new SimpleCursorAdapter(
                this,
                R.layout.meal_list_item1,
                null,
                new String[]{"name", "description", "price"},
                new int[]{R.id.tv_meal_name, R.id.tv_meal_description, R.id.tv_meal_price},
                0
        );
        lvMainMeals.setAdapter(adapter);


        btnMealMangement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 打开管理菜单的界面
                databaseHandler.deleteTable();
                Intent intent = new Intent(meal_list_item2.this, SignInActivity.class);
                startActivity(intent);
            }
        });

        /*
        Cursor cursor = databaseHandler.getAllMeals();
        for(int k=0;k<=cursor.getCount();k++){
            total += (int) Integer.parseInt(String.valueOf(cursor.getColumnIndex("price")));
            System.out.println(total);
        }
        totalAmount.setText(""+ total);
        */

        total = databaseHandler.getSum();
        totalAmount.setText(""+total);



        //回到首頁
        home = findViewById(R.id.btn_cart_home);
        order = findViewById(R.id.btn_cart_order);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(meal_list_item2.this, MainActivity.class);
                startActivity(intent);
            }
        });
        //

        //前往購物車
        order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(meal_list_item2.this, OrderActivity.class);
                startActivity(intent);
            }
        });
        //
    }

    protected void onResume() {
        super.onResume();
        showAllMeals();
    }

    private void showAllMeals() {
         Cursor cursor = databaseHandler.getAllMeals();
        adapter.changeCursor(cursor);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // 关闭数据库连接
        databaseHandler.close();
    }
}