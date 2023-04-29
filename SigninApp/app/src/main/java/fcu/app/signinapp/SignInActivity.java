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

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_sign_in3);

    btnSignIn = findViewById(R.id.btn_signin);
    btnSignUp = findViewById(R.id.btn_signup);
    etUsername = findViewById(R.id.et_signin_username);
    etPassword = findViewById(R.id.et_signin_password);

    View.OnClickListener onClickListener = new View.OnClickListener() {
      @Override
      public void onClick(View v) {
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
            sharedPreferences.edit().putBoolean("signed_in", true).apply();
            Intent intent = new Intent(SignInActivity.this, MainActivity.class);
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
  }
}