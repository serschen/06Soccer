package com.soccer.a06soccer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements onClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickPlayer() {
        String name = "";
        String lname = ";";

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(this, YourActivityName.class);
            startActivity(intent);
        }

    }
}
