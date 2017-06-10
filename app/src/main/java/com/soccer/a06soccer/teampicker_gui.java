package com.soccer.a06soccer;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ListView;
import android.widget.Button;

import java.util.ArrayList;

import Data.Database;
import Data.Player;

/**
 * Created by Martin on 08.05.2017.
 */

public class teampicker_gui extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener {
    private TextView tvTeamName = null;
    private ListView lvSelectedPlayer = null;
    private Button bttnAdd = null;
    private Button bttnRemove = null;
    private ListView lvAllPlayer = null;

    Player movePlayer = null;
    String teamSelected = null;
    private int curPositionAll = -1;
    private int curPositionSel = -1;
    private Database db = null;
    private ArrayList<Player> alPlayerAll = null;
    private ArrayList<Player> alPlayerSel = new ArrayList<>();
    private ArrayAdapter<Player> adapterAll = null;
    private ArrayAdapter<Player> adapterSel = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.teampicker_gui);

        try {
            getAllViews();
            registrateEventHandlers();
            db = Database.getInstance();
            alPlayerAll = db.getLocalPlayers();
            teamSelected = getIntent().getStringExtra("TEAM SELECTED");

            if (teamSelected.equals("T1")) {
                alPlayerAll.removeAll(db.getCurrentGame().getTsTeamOnePlayer());
                alPlayerAll.removeAll(db.getCurrentGame().getTsTeamTwoPlayer());
                alPlayerSel = db.getCurrentGame().getTsTeamOnePlayer();
                tvTeamName.setText("Players of team 1");
            }
            else {
                alPlayerAll.removeAll(db.getCurrentGame().getTsTeamOnePlayer());
                alPlayerAll.removeAll(db.getCurrentGame().getTsTeamTwoPlayer());
                alPlayerSel = db.getCurrentGame().getTsTeamTwoPlayer();
                tvTeamName.setText("Players of team 2");
            }

            updateAllPlayerList();
            updateSelPlayerList();
        }
        catch(Exception ex)
        {
            Toast.makeText(getApplicationContext(), ex.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    public void getAllViews()
    {
        lvSelectedPlayer = (ListView) this.findViewById(R.id.lvSelectedPlayer);
        lvAllPlayer = (ListView) this.findViewById(R.id.lvAllPlayer);
        bttnAdd = (Button) this.findViewById(R.id.bttnAdd);
        bttnRemove = (Button) this.findViewById(R.id.bttnRemove);
        tvTeamName = (TextView) findViewById(R.id.tvTeamName);
    }

    public void registrateEventHandlers()
    {
        lvSelectedPlayer.setOnItemClickListener(this);
        lvSelectedPlayer.setChoiceMode(AbsListView.CHOICE_MODE_SINGLE);
        lvAllPlayer.setOnItemClickListener(this);
        lvAllPlayer.setChoiceMode(AbsListView.CHOICE_MODE_SINGLE);
        bttnAdd.setOnClickListener(this);
        bttnRemove.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        try {
            if (v == bttnAdd) {
                movePlayer = alPlayerAll.remove(curPositionAll);
                updateAllPlayerList();

                if (teamSelected.equals("T1")) {
                    db.addPlayerTeamOne(movePlayer);
                    alPlayerSel = db.getCurrentGame().getTsTeamOnePlayer();
                } else {
                    db.addPlayerTeamTwo(movePlayer);
                    alPlayerSel = db.getCurrentGame().getTsTeamTwoPlayer();
                }

                updateSelPlayerList();
            } else if (v == bttnRemove) {
                movePlayer = alPlayerSel.remove(curPositionSel);
                adapterAll.add(movePlayer);
                updateAllPlayerList();

                if (teamSelected.equals("T1")) {
                    db.removePlayerTeamOne(movePlayer);
                    alPlayerSel = db.getCurrentGame().getTsTeamOnePlayer();
                } else {
                    db.removePlayerTeamTwo(movePlayer);
                    alPlayerSel = db.getCurrentGame().getTsTeamTwoPlayer();
                }

                updateSelPlayerList();
            }
        }
        catch (Exception ex)
        {
            Toast.makeText(getApplicationContext(), ex.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if (parent.equals(lvAllPlayer)) {
            curPositionAll = position;
        }
        else
        {
            curPositionSel = position;
        }
    }

    public void updateAllPlayerList() {
        adapterAll = new ArrayAdapter<Player>(
                this,
                android.R.layout.simple_list_item_1,
                alPlayerAll
        );

        lvAllPlayer.setAdapter(adapterAll);
    }

    private void updateSelPlayerList()
    {
        adapterSel = new ArrayAdapter<Player>(
                this,
                android.R.layout.simple_list_item_1,
                alPlayerSel
        );

        lvSelectedPlayer.setAdapter(adapterSel);
    }
}
