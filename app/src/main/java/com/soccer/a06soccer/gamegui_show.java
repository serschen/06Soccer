package com.soccer.a06soccer;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import Data.Database;

/**
 * Created by anton on 17.05.2017.
 */

public class gamegui_show extends AppCompatActivity implements AdapterView.OnItemClickListener{
    private Database database = null;
    private ListView team1 = null;
    private ListView team2 = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gamegui_show);

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
        team1 = (ListView) this.findViewById(R.id.lvTeam1);
        team2 = (ListView) this.findViewById(R.id.lvTeam2);
    }

    public void registrateEventHandlers()
    {
        team1.setOnItemClickListener(this);
        team2.setOnItemClickListener(this);
    }

    public void fillLists()
    {

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        
    }
}
