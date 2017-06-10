package com.soccer.a06soccer;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.TreeSet;
import java.util.concurrent.ExecutionException;

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
    private ArrayList<Position> positions = null;

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
        positions = player.getPositions();
        txtPlayerName.setText(player.getName());

        if(positions == null)
        {
            positions = new ArrayList<>();
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
        if(positions != null)
        {
            if(positions.contains(Position.DEFENSE))
            {
                cbDefender.setChecked(true);
            }
            if(positions.contains(Position.MIDFIELD))
            {
                cbMidfielder.setChecked(true);
            }
            if(positions.contains(Position.ATTACK))
            {
                cbForward.setChecked(true);
            }
            if(positions.contains(Position.GOAL))
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
                pos = Position.GOAL;
            } else if (buttonView == cbDefender) {
                pos = Position.DEFENSE;
            } else if (buttonView == cbForward) {
                pos = Position.ATTACK;
            } else if (buttonView == cbMidfielder) {
                pos = Position.MIDFIELD;
            }

            if (isChecked == true) {
                if(!positions.contains(pos)) {
                    positions.add(pos);
                }
            } else {
                if(positions.contains(pos)) {
                    positions.remove(pos);
                }
            }

            player.setPositions(positions);
        }
        catch(Exception ex)
        {
            Toast.makeText(getApplicationContext(),
                    ex.getMessage(), Toast.LENGTH_LONG)
                    .show();
        }
    }

    @Override
    public void onBackPressed() {
        try {
            String ret = database.updatePlayer(player);

            Toast.makeText(getApplicationContext(),
                    ret, Toast.LENGTH_SHORT)
                    .show();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        finally {
            super.onBackPressed();
        }
    }
}
