package com.soccer.a06soccer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import Data.Database;
import Data.Player;

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
            updateStats();
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

    private void updateStats() {
        Player loadPlayer = db.getCurrentPlayer();

        /*etGoalDefault.setText(loadPlayer.getGoalDefault() + "");
        etGoalPenalty.setText(loadPlayer.getGoalPenalty() + "");
        etGoalHeadSnow.setText(loadPlayer.getGoalHeadSnow() + "");
        etGoalOwn.setText(loadPlayer.getGoalOwn() + "");
        etNuttmeg.setText(loadPlayer.getNuttmeg() + "");*/
    }

    @Override
    public void onBackPressed() {
        Player updatedPlayer = db.getCurrentPlayer();

        /*updatedPlayer.setGoalDefault(Integer.parseInt(etGoalDefault.getText().toString()));
        updatedPlayer.setGoalPenalty(Integer.parseInt(etGoalPenalty.getText().toString()));
        updatedPlayer.setGoalHeadSnow(Integer.parseInt(etGoalHeadSnow.getText().toString()));
        updatedPlayer.setGoalOwn(Integer.parseInt(etGoalOwn.getText().toString()));
        updatedPlayer.setNuttmeg(Integer.parseInt(etNuttmeg.getText().toString()));*/

        db.setCurrentPlayer(updatedPlayer);

        super.onBackPressed();
    }
}
