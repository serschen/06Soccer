package com.soccer.a06soccer;

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

import Data.Database;
import Data.Player;

/**
 * Created by anton on 26.04.2017.
 */

public class playerstats_overall extends AppCompatActivity {
    private TextView tvName = null;
    private TextView tvGoalDefault = null;
    private TextView tvGoalPenalty = null;
    private TextView tvGoalHead = null;
    private TextView tvGoalHeadSnow = null;
    private TextView tvGoalOwn = null;
    private TextView tvNutmeg = null;
    private Database db = null;
    Player curPlayer = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.playerstats_overall);

        try{
            db=Database.getInstance();
            getAllViews();
            setDetails();
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
        tvName = (TextView) this.findViewById(R.id.txtViewName);
        tvGoalDefault = (TextView) this.findViewById(R.id.txtViewGoalDefault);
        tvGoalPenalty = (TextView) this.findViewById(R.id.txtViewGoalPenalty);
        tvGoalHead = (TextView) this.findViewById(R.id.txtViewGoalHead);
        tvGoalHeadSnow = (TextView) this.findViewById(R.id.txtViewGoalHeadSnow);
        tvGoalOwn = (TextView) this.findViewById(R.id.txtViewGoalOwn);
        tvNutmeg = (TextView) this.findViewById(R.id.txtViewNutmeg);
    }

    public void setDetails()
    {
        curPlayer = db.getCurrentPlayer();
        tvName.setText(curPlayer.getName());

        /*
        *setStatsofthePlayerSelected();
        * */
    }

}
