package com.app.staysafefinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;
import android.widget.TextView;

public class splashScreen extends AppCompatActivity {

    private ImageView familyiv;
    private TextView caretv,familytv,staytv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        familyiv = findViewById(R.id.familyiv);
        caretv = findViewById(R.id.caretv);
        familytv = findViewById(R.id.familytv);
        staytv = findViewById(R.id.staytv);

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent intent = new Intent(getApplicationContext(),LoginActivity.class);
                startActivity(intent);

            }
        }, 1000);


    }
}
