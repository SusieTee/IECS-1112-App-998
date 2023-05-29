package fcu.app.signinapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignInActivity extends AppCompatActivity {

  private Button btnSignIn;
  private Button btnSignUp;
  private EditText etUsername;
  private EditText etPassword;
  private Button button;
  private Button button2;
  private Button button3;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_sign_in3);

    btnSignIn = findViewById(R.id.btn_signin);
    btnSignUp = findViewById(R.id.btn_signup);
    etUsername = findViewById(R.id.et_signin_username);
    etPassword = findViewById(R.id.et_signin_password);
    button = findViewById(R.id.button);
    button2 = findViewById(R.id.button2);
    button3 = findViewById(R.id.button3);

    button.setVisibility(View.GONE);
    button2.setVisibility(View.GONE);
    button3.setVisibility(View.GONE);

    View.OnClickListener onClickListener = new View.OnClickListener() {
      @Override
      public void onClick(View v) {

        if (v.getId() == R.id.button) {
          Intent intent = new Intent(SignInActivity.this, MainActivity.class);
          startActivity(intent);
        }
        else if (v.getId() == R.id.button2) {
          Intent intent = new Intent(SignInActivity.this, OrderActivity.class);
          startActivity(intent);
        }
        else if (v.getId() == R.id.button3) {
          Intent intent = new Intent(SignInActivity.this, meal_list_item2.class);
          startActivity(intent);
        }

        if (v.getId() == R.id.btn_signin) {
          String username = etUsername.getText().toString();
          String password = etPassword.getText().toString();

          if (username.isEmpty() || password.isEmpty()) {
            Toast.makeText(SignInActivity.this, "Please enter username and password", Toast.LENGTH_SHORT).show();
            return;
          }

          SharedPreferences sharedPreferences = getSharedPreferences("user_info", MODE_PRIVATE);
          String sharedUsername = sharedPreferences.getString("username", "");
          String sharedPassword = sharedPreferences.getString("password", "");
          if (username.equals(sharedUsername) && password.equals(sharedPassword)) {
            button.setVisibility(View.VISIBLE);
            button2.setVisibility(View.VISIBLE);
            button3.setVisibility(View.VISIBLE);
            sharedPreferences.edit().putBoolean("signed_in", true).apply();
            Intent intent = new Intent(SignInActivity.this, OrderActivity.class);//登入後跳到後面的activity
            startActivity(intent);
          } else {
            Toast.makeText(SignInActivity.this, "Invalid username or password", Toast.LENGTH_SHORT).show();
          }
        }else if (v.getId() == R.id.btn_signup) {
          Intent intent = new Intent(SignInActivity.this, SignUpActivity.class);
          startActivity(intent);
        }
        }
    };
    btnSignIn.setOnClickListener(onClickListener);
    btnSignUp.setOnClickListener(onClickListener);
    button.setOnClickListener(onClickListener);
    button2.setOnClickListener(onClickListener);
    button3.setOnClickListener(onClickListener);
  }
}