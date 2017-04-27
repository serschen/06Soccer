package com.soccer.a06soccer;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import Data.Database;
import Data.Player;

/**
 * Created by anton on 26.04.2017.
 */

public class playergui_main extends AppCompatActivity implements View.OnClickListener,AdapterView.OnItemClickListener {
    private Button btnAdd = null;
    private Button btnRemove = null;
    private Button btnUpdate = null;
    private TextView txtMessage = null;
    private Database database = null;
    private ListView playerList = null;
    private int curPosition = -1;
    private ArrayAdapter<Player> adapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.playergui_main);

        try{
            getAllViews();
            registrateEventHandlers();
            database = Database.getInstance();
            updatePlayerList();
        }
        catch(Exception ex)
        {
            txtMessage.setText(ex.getMessage());
        }
    }

    public void getAllViews()
    {
        btnAdd = (Button) this.findViewById(R.id.btnAdd);
        btnRemove = (Button) this.findViewById(R.id.btnRemove);
        btnUpdate = (Button) this.findViewById(R.id.btnUpdate);
        txtMessage = (TextView) this.findViewById(R.id.txtMessage);
        playerList = (ListView) this.findViewById(R.id.listView);
    }

    public void registrateEventHandlers()
    {
        btnAdd.setOnClickListener(this);
        btnRemove.setOnClickListener(this);
        btnUpdate.setOnClickListener(this);
        playerList.setOnItemClickListener(this);
        //playerList.setChoiceMode(AbsListView.CHOICE_MODE_SINGLE);
        //playerList.setMultiChoiceModeListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v == btnAdd)
        {
            Player player = new Player(database.getId(), "asd", null);
            database.addPlayer(player);
            updatePlayerList();
            txtMessage.setText(player.getName() + " added");
        }
        else if(v == btnRemove)
        {
            remove();
        }
        else if(v == btnUpdate)
        {
            if(curPosition != -1)
            {
                Intent intent = new Intent(this, positiongui.class);
                startActivity(intent);
            }
            else
            {
                txtMessage.setText("No Player selected");
            }
        }
    }

    public void updatePlayerList() {
        adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                database.getPlayers()
        );
        playerList.setAdapter(adapter);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        curPosition = position;
        database.setCurrentPlayer((Player) playerList.getItemAtPosition(curPosition));
    }

    public void remove()
    {
        try{
            Player curPlayer = database.getCurrentPlayer();
            if(curPosition != -1)
            {
                database.removePlayer(curPlayer);
                txtMessage.setText(curPlayer.getName() + " removed");
                updatePlayerList();
                curPosition = -1;
            }
            else
            {
                txtMessage.setText("No Player selected");
            }
        }
        catch(Exception ex)
        {
            txtMessage.setText(ex.getMessage());
        }

    }
}
