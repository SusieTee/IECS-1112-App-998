package fcu.app.signinapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    SharedPreferences sharedPreferences = getSharedPreferences("user_info", MODE_PRIVATE);
    boolean isSignedIn = sharedPreferences.getBoolean("signed_in", false);
    if (isSignedIn) {
      Intent intent = new Intent(MainActivity.this, SignInActivity.class);
      startActivity(intent);
    }
    Toast.makeText(this, "onCreate method is called", Toast.LENGTH_SHORT).show();
  }

  @Override
  protected void onStart() {
    super.onStart();
    Toast.makeText(this, "onStart method is called", Toast.LENGTH_SHORT).show();
  }

  @Override
  protected void onResume() {
    super.onResume();
    Toast.makeText(this, "onResume method is called", Toast.LENGTH_SHORT).show();
  }

  @Override
  protected void onPause() {
    super.onPause();
    Toast.makeText(this, "onPause method is called", Toast.LENGTH_SHORT).show();
  }

  @Override
  protected void onStop() {
    super.onStop();
    Toast.makeText(this, "onStop method is called", Toast.LENGTH_SHORT).show();
  }

  @Override
  protected void onDestroy() {
    super.onDestroy();
    Toast.makeText(this, "onDestroy method is called", Toast.LENGTH_SHORT).show();
  }

  @Override
  protected void onRestart() {
    super.onRestart();
    Toast.makeText(this, "onRestart method is called", Toast.LENGTH_SHORT).show();
  }
}
