package com.soccer.a06soccer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import Data.Database;
import Data.Player;

/**
 * Created by anton on 17.05.2017.
 */

public class gamegui_show extends AppCompatActivity implements AdapterView.OnItemLongClickListener, AdapterView.OnItemClickListener {
    private Database db = null;
    private TextView tvDate = null;
    private TextView tvTeam1 = null;
    private TextView tvTeam2 = null;
    private ListView team1 = null;
    private ListView team2 = null;

    private ArrayList<Player> alPlayerTeamOne = null;
    private ArrayList<Player> alPlayerTeamTwo = null;
    private ArrayAdapter<Player> adapterTeamOne = null;
    private ArrayAdapter<Player> adapterTeamTwo = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gamegui_show);

        try {
            db = Database.getInstance();
            getAllViews();
            registrateEventHandlers();
            tvDate.setText(db.getCurrentGame().getDate().toString());
            tvTeam1.setText("Team 1 - " + db.getCurrentGame().getGoalsShotTeam1());
            tvTeam2.setText("Team 2 - " + db.getCurrentGame().getGoalsShotTeam2());
            alPlayerTeamOne = db.getCurrentGame().getTsTeamOnePlayer();
            alPlayerTeamTwo = db.getCurrentGame().getTsTeamTwoPlayer();
            loadPlayers();
        }
        catch(Exception ex)
        {
            Toast.makeText(getApplicationContext(), ex.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    public void getAllViews()
    {
        tvDate = (TextView) this.findViewById(R.id.tvDate);
        tvTeam1 = (TextView) this.findViewById(R.id.tvTeam1);
        tvTeam2 = (TextView) this.findViewById(R.id.tvTeam2);
        team1 = (ListView) this.findViewById(R.id.lvTeam1);
        team2 = (ListView) this.findViewById(R.id.lvTeam2);
    }

    public void registrateEventHandlers()
    {
        //team1.setOnItemLongClickListener(this);
        //team2.setOnItemLongClickListener(this);
        team1.setOnItemClickListener(this);
        team2.setOnItemClickListener(this);
    }

    public void loadPlayers()
    {
        adapterTeamOne = new ArrayAdapter<Player>(
                this,
                android.R.layout.simple_list_item_1,
                alPlayerTeamOne
        );

        team1.setAdapter(adapterTeamOne);

        adapterTeamTwo = new ArrayAdapter<Player>(
                this,
                android.R.layout.simple_list_item_1,
                alPlayerTeamTwo
        );

        team2.setAdapter(adapterTeamTwo);
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        //db.setCurrentPlayer(db.getPlayers().get(position));

        return true;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        db.setCurrentPlayer(db.getPlayers().get(position));

        Intent intent = new Intent(this, gamegui_playerstats.class);
        startActivity(intent);
    }
}
