package com.soccer.a06soccer;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import Data.Database;

/**
 * Created by anton on 17.05.2017.
 */

public class gamestats_gui extends AppCompatActivity {
    private Database database = null;
    private TextView goalDefault = null;
    private TextView goalPenalty = null;
    private TextView goalHeadSnow = null;
    private TextView goalOwn = null;
    private TextView nutmeg = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gamestats_gui);

        try{
            database = Database.getInstance();
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

    }

    public void registrateEventHandlers()
    {

    }
}
