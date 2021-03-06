package com.soccer.a06soccer;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;
import java.util.concurrent.ExecutionException;

import Data.Database;
import Data.Player;
import Data.Position;

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
    private AlertDialog dialog = null;
    private AlertDialog dialogSearch = null;
    private EditText txtNameDialog = null;
    private Button btnAddPlayerDialog = null;
    private Button btnCancelAddPlayerDialog = null;
    private Button btnSearch = null;
    private EditText etSearch = null;
    private Button btnSearchDialog = null;
    private TextView txtUsername = null;
    private TextView txtPassword = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.playergui_main);

        try{
            getAllViews();
            registrateEventHandlers();
            database = Database.getInstance();
            updatePlayerList();
            createDialog();
            createSearchDialog();
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
        btnAdd = (Button) this.findViewById(R.id.btnAdd);
        btnRemove = (Button) this.findViewById(R.id.btnRemove);
        btnUpdate = (Button) this.findViewById(R.id.btnUpdate);
        playerList = (ListView) this.findViewById(R.id.listView);
        btnSearch = (Button) this.findViewById(R.id.btnSearch);
    }

    public void registrateEventHandlers()
    {
        btnAdd.setOnClickListener(this);
        btnRemove.setOnClickListener(this);
        btnUpdate.setOnClickListener(this);
        playerList.setOnItemClickListener(this);
        playerList.setChoiceMode(AbsListView.CHOICE_MODE_SINGLE);
        btnSearch.setOnClickListener(this);
        //playerList.setMultiChoiceModeListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v == btnAdd)
        {
            add();
        }
        else if(v == btnRemove)
        {
            remove();
        }
        else if(v == btnUpdate)
        {
            update();
        }
        else if(v == btnAddPlayerDialog)
        {
            if(!txtNameDialog.getText().toString().isEmpty())
            {
                try {
                    addPlayer();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                dialog.hide();
                txtNameDialog.setText("");
                txtUsername.setText("");
                txtPassword.setText("");
            }
            else
            {
                Toast.makeText(getApplicationContext(),
                        "Type in a name", Toast.LENGTH_SHORT)
                        .show();
            }
        }
        else if(v == btnCancelAddPlayerDialog)
        {
            dialog.hide();
            txtNameDialog.setText("");
            txtUsername.setText("");
            txtPassword.setText("");
        }
        else if(v == btnSearch)
        {
            search();
        }
        else if(v == btnSearchDialog)
        {
            dialogSearch.hide();
            try {
                updateList(etSearch.getText().toString());
            } catch (ExecutionException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            etSearch.setText("");

        }
    }

    public void updatePlayerList() throws ExecutionException, InterruptedException {
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
                String r = database.removePlayer(curPlayer);
                Toast.makeText(getApplicationContext(),
                        r, Toast.LENGTH_SHORT)
                        .show();
                updatePlayerList();
                curPosition = -1;
            }
            else
            {
                Toast.makeText(getApplicationContext(),
                        "No Player selected", Toast.LENGTH_SHORT)
                        .show();
            }
        }
        catch(Exception ex)
        {
            Toast.makeText(getApplicationContext(),
                    ex.getMessage(), Toast.LENGTH_LONG)
                    .show();
        }

    }

    public void add()
    {
        dialog.show();
    }

    public void addPlayer() throws ExecutionException, InterruptedException {
        try {
            Player player = new Player(null, txtNameDialog.getText().toString(), txtUsername.getText().toString(), true);
            String r = database.addPlayer(player);
            updatePlayerList();
            String pr = database.setPassword(database.getLastPlayer(), txtPassword.getText().toString());
            Toast.makeText(getApplicationContext(),
                    r, Toast.LENGTH_SHORT)
                    .show();
        }
        catch(Exception ex)
        {
            Toast.makeText(getApplicationContext(),
                    ex.getMessage(), Toast.LENGTH_SHORT)
                    .show();
        }
    }

    public void createDialog()
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(playergui_main.this);
        View view = getLayoutInflater().inflate(R.layout.addplayer_dialog, null);
        txtNameDialog = (EditText) view.findViewById(R.id.txtPlayerNameDialog);
        txtUsername = (EditText) view.findViewById(R.id.txtUsernameDialog);
        txtPassword = (EditText) view.findViewById(R.id.txtPasswordDialog);
        btnAddPlayerDialog = (Button) view.findViewById(R.id.btnAddPlayerDialog);
        btnCancelAddPlayerDialog = (Button) view.findViewById(R.id.btnCancelAddPlayerDialog);
        btnAddPlayerDialog.setOnClickListener(this);
        btnCancelAddPlayerDialog.setOnClickListener(this);
        builder.setView(view);
        dialog = builder.create();
    }

    public void createSearchDialog()
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(playergui_main.this);
        View view = getLayoutInflater().inflate(R.layout.searchplayer_dialog, null);
        etSearch = (EditText) view.findViewById(R.id.etSearchPlayerDialog);
        btnSearchDialog = (Button) view.findViewById(R.id.btnSearchDialog);
        btnSearchDialog.setOnClickListener(this);
        builder.setView(view);
        dialogSearch = builder.create();
    }

    public void update()
    {
        if(curPosition != -1)
        {
            Intent intent = new Intent(this, positiongui.class);
            startActivity(intent);
        }
        else
        {
            Toast.makeText(getApplicationContext(),
                    "No Player selected", Toast.LENGTH_SHORT)
                    .show();
        }
    }

    public void updateList(String name) throws ExecutionException, InterruptedException {
        adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                database.getFilteredPlayer(name)
        );
        playerList.setAdapter(adapter);
    }

    public void search()
    {
        dialogSearch.show();
    }
}
