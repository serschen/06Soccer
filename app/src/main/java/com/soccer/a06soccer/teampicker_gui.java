package com.soccer.a06soccer;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ListView;
import android.widget.Button;
import Data.Database;
import Data.Player;

/**
 * Created by Martin on 08.05.2017.
 */

public class teampicker_gui extends AppCompatActivity implements View.OnClickListener,AdapterView.OnItemClickListener {
    private ListView ListViewSelectedPlayer = null;
    private ListView ListViewAllPlayer = null;
    private Button btnAdd = null;
    private Button btnRemove = null;
    private TextView tvTeamName = null;
    String teamSelected = null;

    private Database db = null;
    private Player curPlayer = null;
    private int curPos = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.teampicker_gui);

        try{
            getAllViews();
            registrateEventHandlers();
            db = Database.getInstance();
            loadPlayer();
            teamSelected = getIntent().getStringExtra("TEAM SELECTED");
            tvTeamName.setText(teamSelected);
        }
        catch(Exception ex)
        {
            Toast.makeText(getApplicationContext(), ex.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }

    public void getAllViews()
    {
        ListViewSelectedPlayer = (ListView) this.findViewById(R.id.lvSelectedPlayer);
        ListViewAllPlayer = (ListView) this.findViewById(R.id.lvAllPlayer);
        btnAdd = (Button) this.findViewById(R.id.bttnAdd);
        btnRemove = (Button) this.findViewById(R.id.bttnRemove);
        tvTeamName = (TextView) findViewById(R.id.tvTeamName);
    }

    public void registrateEventHandlers()
    {
        ListViewSelectedPlayer.setOnItemClickListener(this);
        ListViewAllPlayer.setOnItemClickListener(this);
        btnAdd.setOnClickListener(this);
        btnRemove.setOnClickListener(this);
    }

    private void loadPlayer()
    {

    }
}
