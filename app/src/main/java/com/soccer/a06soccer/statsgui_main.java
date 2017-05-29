package com.soccer.a06soccer;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import Data.Database;
import Data.Player;

/**
 * Created by anton on 26.04.2017.
 */

public class statsgui_main extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener{
    private Button btnShow = null;
    private ListView lvPlayer = null;
    private Database db = null;
    private int curPos = -1;
    private ArrayAdapter<Player>adapter = null;
    private Spinner spSpats = null;
    private String[] arraySpinner = new String[] {"GoalDiff","GoalsShot","GoalsGot","GoalHead","GoalHeadSnow","GoalOwn","GoalDefault","GoalPenalty","Nutmeg"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.statsgui_main);

        try{
            getAllViews();
            registrateEventHandlers();
            db = Database.getInstance();
            loadPlayer();
            fillSpinner();
        }
        catch(Exception ex)
        {
            Toast.makeText(getApplicationContext(),
                    ex.getMessage(), Toast.LENGTH_LONG)
                    .show();
        }
    }

    @Override
    public void onClick(View v) {
        if(curPos != -1) {
            Intent intent = new Intent(this, playerstats_overall.class);
            startActivity(intent);
        }
        else
        {
            Toast.makeText(getApplicationContext(), "No Player selected", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        curPos = position;
        db.setCurrentPlayer((Player)lvPlayer.getItemAtPosition(curPos));
    }

    public void getAllViews()
    {
        btnShow = (Button) this.findViewById(R.id.btnShow);
        lvPlayer = (ListView) this.findViewById(R.id.listViewPlayer);
        spSpats = (Spinner) this.findViewById(R.id.spRanking);
    }

    public void registrateEventHandlers()
    {
        btnShow.setOnClickListener(this);
        lvPlayer.setOnItemClickListener(this);
    }

    public void loadPlayer() {
        adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                db.getPlayers()
        );
        lvPlayer.setAdapter(adapter);
    }

    public void fillSpinner() {
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, arraySpinner);
        spSpats.setAdapter(adapter);
    }
}
