package com.soccer.a06soccer;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

import Data.Database;
import Data.Player;

/**
 * Created by anton on 26.04.2017.
 */

public class playergui_main extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener {
    private Button btnAdd = null;
    private Button btnRemove = null;
    private Button btnUpdate = null;
    private TextView txtMessage = null;
    private Database database = null;
    private ListView playerList = null;

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
        playerList.setOnItemSelectedListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v == btnAdd)
        {
            txtMessage.setText("add");
        }
        else if(v == btnRemove)
        {
            txtMessage.setText("remove");
        }
        else if(v == btnUpdate)
        {
            txtMessage.setText("update");
        }
    }

    public void updatePlayerList()
    {
        ArrayAdapter<Player> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                database.getPlayers()
        );
        playerList.setAdapter(adapter);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
