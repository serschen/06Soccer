package com.soccer.a06soccer;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.TreeSet;

import Data.Database;
import Data.Player;
import Data.Position;

/**
 * Created by anton on 26.04.2017.
 */

public class positiongui extends AppCompatActivity implements CheckBox.OnCheckedChangeListener {
    private Database database = null;
    private CheckBox cbGoalie = null;
    private CheckBox cbMidfielder = null;
    private CheckBox cbDefender = null;
    private CheckBox cbForward = null;
    private TextView txtPlayerName = null;
    private Player player = null;
    private TreeSet<Position> tsPosition = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.positiongui);

        try{
            getAllViews();
            registrateEventHandlers();
            database = Database.getInstance();
            getData();
            setPositionBoxes();
        }
        catch(Exception ex)
        {

        }
    }

    public void getData()
    {
        player = database.getCurrentPlayer();
        tsPosition = player.getTsPositions();
        txtPlayerName.setText(player.getName());

        if(tsPosition == null)
        {
            tsPosition = new TreeSet<>();
        }
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
        cbGoalie.setOnCheckedChangeListener(this);
        cbDefender.setOnCheckedChangeListener(this);
        cbForward.setOnCheckedChangeListener(this);
        cbMidfielder.setOnCheckedChangeListener(this);
    }

    public void setPositionBoxes()
    {
        if(tsPosition != null)
        {
            if(tsPosition.contains(Position.DEFENDER))
            {
                cbDefender.setChecked(true);
            }
            if(tsPosition.contains(Position.MIDFIELDER))
            {
                cbMidfielder.setChecked(true);
            }
            if(tsPosition.contains(Position.ATTACK))
            {
                cbForward.setChecked(true);
            }
            if(tsPosition.contains(Position.DEFENDER))
            {
                cbDefender.setChecked(true);
            }
            if(tsPosition.contains(Position.GOALIE))
            {
                cbGoalie.setChecked(true);
            }
        }
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        try {
            Position pos = null;

            if (buttonView == cbGoalie) {
                pos = Position.GOALIE;
            } else if (buttonView == cbDefender) {
                pos = Position.DEFENDER;
            } else if (buttonView == cbForward) {
                pos = Position.ATTACK;
            } else if (buttonView == cbMidfielder) {
                pos = Position.MIDFIELDER;
            }

            if (isChecked == true) {
                tsPosition.add(pos);
            } else {
                tsPosition.remove(pos);
            }

            player.setTsPositions(tsPosition);
        }
        catch(Exception ex)
        {
            Toast.makeText(getApplicationContext(),
                    ex.getMessage(), Toast.LENGTH_LONG)
                    .show();
        }
    }
}
