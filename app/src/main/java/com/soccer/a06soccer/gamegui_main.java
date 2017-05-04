package com.soccer.a06soccer;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.ButtonBarLayout;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import Data.Database;
import Data.Game;

/**
 * Created by anton on 03.05.2017.
 */

public class gamegui_main extends AppCompatActivity implements AdapterView.OnItemClickListener, View.OnClickListener{
    private Database database = null;
    private ListView lvGame = null;
    private Button btnAdd = null;
    private Button btnRemove = null;
    private Button btnUpdate = null;
    private Button btnShow = null;
    private ArrayAdapter<Game> adapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gamegui_main);

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
        lvGame = (ListView) this.findViewById(R.id.lvGames);
        btnAdd = (Button) this.findViewById(R.id.bttnAdd);
        btnRemove = (Button) this.findViewById(R.id.bttnRemove);
        btnUpdate = (Button) this.findViewById(R.id.bttnUpdate);
        btnShow = (Button) this.findViewById(R.id.bttnShow);
    }

    public void registrateEventHandlers()
    {
        lvGame.setOnItemClickListener(this);
        btnAdd.setOnClickListener(this);
        btnRemove.setOnClickListener(this);
        btnUpdate.setOnClickListener(this);
        btnShow.setOnClickListener(this);
    }

    public void getData()
    {
        adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                database.getGames()
        );
        lvGame.setAdapter(adapter);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        database.setCurrentGame((Game) parent.getItemAtPosition(position));
    }

    @Override
    public void onClick(View v) {
        if(v == btnAdd)
        {

        }
        else if(v == btnRemove)
        {
            database.removeGame(database.getCurrentGame());
            getData();
        }
        else if(v == btnUpdate)
        {

        }
        else if(v == btnShow)
        {

        }
    }
}
