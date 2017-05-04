package com.soccer.a06soccer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import Data.Database;
//192.168.194.27:8080
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnPlayer = null;
    Button btnGames = null;
    Button btnStats = null;
    TextView messageLine = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try{
            getAllViews();
            registrateEventHandlers();
        }
        catch(Exception ex)
        {
            Toast.makeText(getApplicationContext(),
                    ex.getMessage(), Toast.LENGTH_LONG)
                    .show();
        }
    }

    public void getAllViews()
    {
        btnPlayer = (Button) this.findViewById(R.id.btnPlayer);
        btnGames = (Button) this.findViewById(R.id.btnGames);
        btnStats = (Button) this.findViewById(R.id.btnStats);
        messageLine = (TextView) this.findViewById(R.id.messageLine);
    }

    public void registrateEventHandlers()
    {
        btnPlayer.setOnClickListener(this);
        btnGames.setOnClickListener(this);
        btnStats.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v == btnPlayer)
        {
            Intent intent = new Intent(this, playergui_main.class);
            startActivity(intent);
        }
        else if(v == btnGames)
        {
            Intent intent = new Intent(this, gamegui_main.class);
            startActivity(intent);
        }
        else if(v == btnStats)
        {
            Intent intent = new Intent(this, statsgui_main.class);
            startActivity(intent);
        }
    }
}
