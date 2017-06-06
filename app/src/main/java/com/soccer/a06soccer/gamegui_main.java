package com.soccer.a06soccer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.ButtonBarLayout;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import Data.Database;
import Data.Game;

/**
 * Created by anton on 03.05.2017.
 */

public class gamegui_main extends AppCompatActivity implements AdapterView.OnItemClickListener, View.OnClickListener {
    private Database database = null;
    private ListView lvGame = null;
    private Button btnAdd = null;
    private Button btnRemove = null;
    private Button btnUpdate = null;
    private Button btnShow = null;
    private ArrayAdapter<Game> adapter = null;
    private int curPosition = -1;
    private Button btnSearch = null;
    private AlertDialog searchDialog = null;
    private Button btnSearchDialog = null;
    private EditText etSearchYear = null;
    private EditText etSearchMonth = null;
    private EditText etSearchDay = null;
    private ArrayList<Game> helpnow = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gamegui_main);

        try {
            getAllViews();
            registrateEventHandlers();
            database = Database.getInstance();
            getData();
            createDialog();
        } catch (Exception ex) {
            Toast.makeText(getApplicationContext(),
                    ex.getMessage(), Toast.LENGTH_SHORT)
                    .show();
        }
    }

    public void getAllViews() {
        lvGame = (ListView) this.findViewById(R.id.lvGames);
        btnAdd = (Button) this.findViewById(R.id.bttnAdd);
        btnRemove = (Button) this.findViewById(R.id.bttnRemove);
        btnUpdate = (Button) this.findViewById(R.id.bttnUpdate);
        btnShow = (Button) this.findViewById(R.id.bttnShow);
        btnSearch = (Button) this.findViewById(R.id.btnSearch);
    }

    public void registrateEventHandlers() {
        lvGame.setOnItemClickListener(this);
        btnAdd.setOnClickListener(this);
        btnRemove.setOnClickListener(this);
        btnUpdate.setOnClickListener(this);
        btnShow.setOnClickListener(this);
        btnSearch.setOnClickListener(this);
    }

    public void getData() {

        adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                database.getGames()
        );
        lvGame.setAdapter(adapter);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        curPosition = position;
        database.setCurrentGame((Game) parent.getItemAtPosition(position));
        String currDate = database.getCurrentGame().getDate().toString();
    }

    @Override
    public void onClick(View v) {
        if (v == btnSearch) {
            openDialog();

        }
        else if (v == btnSearchDialog) {


            searchDialog.hide();

            updateList();

            etSearchYear.setText("");
            etSearchDay.setText("");
            etSearchMonth.setText("");


        }
        else if (v == btnAdd) {
            database.addGame(new Game());
            getData();
        }
        else {
            if(curPosition != -1) {
                if(v == btnRemove) {
                    database.removeGame(database.getCurrentGame());
                    getData();
                    curPosition = -1;
                } else if (v == btnUpdate) {
                    Intent intent = new Intent(this, gamegui_addupate.class);
                    startActivity(intent);
                } else if (v == btnShow) {
                    Intent intent = new Intent(this, gamegui_show.class);
                    startActivity(intent);
                }
            }

            else
            {
                Toast.makeText(getApplicationContext(), "No Game selected", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void createDialog()
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(gamegui_main.this);
        View view = getLayoutInflater().inflate(R.layout.searchgame_dialog, null);
        etSearchYear = (EditText) view.findViewById(R.id.etSearchYear);
        etSearchDay = (EditText) view.findViewById(R.id.etSearchDay);
        etSearchMonth = (EditText) view.findViewById(R.id.etSearchMonth);
        btnSearchDialog = (Button) view.findViewById(R.id.btnSearchDialog);
        btnSearchDialog.setOnClickListener(this);
        builder.setView(view);
        searchDialog = builder.create();
    }
    public void openDialog()
    {
        searchDialog.show();
    }

    @Override
    protected void onRestart()
    {

        getData();
        super.onRestart();

    }

    public void updateList()
    {
        try {

            int checkedYear = database.checkData(etSearchYear.getText().toString());
            int checkedMonth = database.checkData(etSearchMonth.getText().toString());
            int checkedDay = database.checkData(etSearchDay.getText().toString());

            //Toast.makeText(getApplicationContext(),database.getFilteredGames(checkedYear,checkedMonth,checkedDay), Toast.LENGTH_SHORT).show();

         helpnow = database.getFilteredGames(checkedYear,checkedMonth,checkedDay);



        adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                helpnow
        );
        lvGame.setAdapter(adapter);

            Toast.makeText(getApplicationContext(),helpnow.get(0).toString(), Toast.LENGTH_SHORT).show();

        } catch (Exception e) {
            Toast.makeText(getApplicationContext(),e.getMessage(), Toast.LENGTH_SHORT).show();
        }



    }
}
