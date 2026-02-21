package com.example.pizzarecipes.ui;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.example.pizzalma.R;

/**
 * A splash screen that appears when the app is launched.
 * It displays for a short period and then navigates to the main pizza list.
 */
public class SplashActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        // A background thread to delay the splash screen
        Thread splashThread = new Thread(() -> {
            try {
                // Hold the screen for 2 seconds
                Thread.sleep(2000);
            } catch (InterruptedException ignored) {
                // In case of interruption, proceed directly
            }
            // Start the main activity
            Intent intent = new Intent(SplashActivity.this, PizzaListActivity.class);
            startActivity(intent);
            // Finish this activity to prevent the user from returning to it
            finish();
        });
        splashThread.start();
    }
}
