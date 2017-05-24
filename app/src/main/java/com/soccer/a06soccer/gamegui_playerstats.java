package com.soccer.a06soccer;

import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import Data.Database;

public class gamegui_playerstats extends AppCompatActivity {
    private TextView tvPlayername = null;
    private EditText etGoalDefault = null;
    private EditText etGoalPenalty = null;
    private EditText etGoalHeadSnow = null;
    private EditText etGoalOwn = null;
    private EditText etNuttmeg = null;

    private Database db = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gamegui_playerstats);

        try {
            getAllViews();
            db = Database.getInstance();
            tvPlayername.setText(db.getCurrentPlayer().getName());
        }
        catch(Exception ex)
        {
            Toast.makeText(getApplicationContext(), ex.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    public void getAllViews()
    {
        tvPlayername = (TextView) this.findViewById(R.id.tvPlayername);
        etGoalDefault = (EditText) this.findViewById(R.id.etGoalDefault);
        etGoalPenalty = (EditText) this.findViewById(R.id.etGoalPenalty);
        etGoalHeadSnow = (EditText) this.findViewById(R.id.etGoalHeadSnow);
        etGoalOwn = (EditText) this.findViewById(R.id.etGoalOwn);
        etNuttmeg = (EditText) this.findViewById(R.id.etNuttmeg);
    }
}
