package com.soccer.a06soccer;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import Data.Database;

/**
 * Created by anton on 26.04.2017.
 */

public class statsgui_main extends AppCompatActivity {
    private Database database = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.statsgui_main);

        try{
            getAllViews();
            registrateEventHandlers();
            database = Database.getInstance();
            getData();
        }
        catch(Exception ex)
        {
            Toast.makeText(getApplicationContext(),
                    ex.getMessage(), Toast.LENGTH_SHORT)
                    .show();
        }
    }

    public void getAllViews()
    {

    }

    public void registrateEventHandlers()
    {

    }

    public void getData()
    {

    }
}
