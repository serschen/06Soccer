package com.soccer.a06soccer;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;

import Data.Database;

/**
 * Created by anton on 26.04.2017.
 */

public class positiongui extends AppCompatActivity {
    private Database database = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.positiongui);

        try{
            getAllViews();
            registrateEventHandlers();
            database = Database.getInstance();
        }
        catch(Exception ex)
        {

        }
    }

    public void getAllViews() {

    }

    public void registrateEventHandlers()
    {

    }
}
