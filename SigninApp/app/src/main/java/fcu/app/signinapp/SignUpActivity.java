package fcu.app.signinapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity {

  private EditText etUserName;
  private EditText etPassword;
  private Button btnSignUp;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_sign_up);

    etUserName = findViewById(R.id.et_signup_username);
    etPassword = findViewById(R.id.et_signup_password);
    btnSignUp = findViewById(R.id.btn_signup_2);

    View.OnClickListener onClickListener = new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        if (v.getId() == R.id.btn_signup_2) {
            String username = etUserName.getText().toString();
            String password = etPassword.getText().toString();
            if (username.isEmpty() || password.isEmpty()) {
              Toast.makeText(SignUpActivity.this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
              return;
            }
            SharedPreferences sharedPreferences = getSharedPreferences("user_info", MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("username", username);
            editor.putString("password", password);
            editor.apply();
            Toast.makeText(SignUpActivity.this, "Sign Up Successful", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(SignUpActivity.this, MainActivity.class);
            startActivity(intent);
        }
      }
    };
    btnSignUp.setOnClickListener(onClickListener);
  }
}