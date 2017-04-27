package com.soccer.a06soccer;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.widget.CheckBox;
import android.widget.TextView;

import Data.Database;
import Data.Player;

/**
 * Created by anton on 26.04.2017.
 */

public class positiongui extends AppCompatActivity {
    private Database database = null;
    private CheckBox cbGoalie = null;
    private CheckBox cbMidfielder = null;
    private CheckBox cbDefender = null;
    private CheckBox cbForward = null;
    private TextView txtPlayerName = null;
    private Player player = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.positiongui);

        try{
            getAllViews();
            registrateEventHandlers();
            database = Database.getInstance();
            getPlayer();
        }
        catch(Exception ex)
        {

        }
    }

    public void getPlayer()
    {
        player = database.getCurrentPlayer();
        txtPlayerName.setText(player.getName());
    }

    public void getAllViews() {
        cbGoalie = (CheckBox) this.findViewById(R.id.cbGoalie);
        cbMidfielder = (CheckBox) this.findViewById(R.id.cbMidfielder);
        cbDefender = (CheckBox) this.findViewById(R.id.cbDefender);
        cbForward = (CheckBox) this.findViewById(R.id.cbForward);
        txtPlayerName = (TextView) this.findViewById(R.id.txtPlayerName);
    }

    public void registrateEventHandlers()
    {

    }
}
