package com.soccer.a06soccer;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.icu.text.DateFormat;
import android.icu.text.SimpleDateFormat;
import android.icu.util.Calendar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import Data.Database;
import Data.Game;

public class gamegui_addupate extends AppCompatActivity implements View.OnClickListener {
    static final int DATE_DIALOG_ID = 0;
    private Button bttnDate = null;
    private Button bttnTeam1 = null;
    private Button bttnTeam2 = null;
    private Button bttnRandom = null;

    private Database database = null;
    private DatePickerDialog.OnDateSetListener mDateSetListener = null;

    int mYear = 0;
    int mMonth = 0;
    int mDay = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gamegui_addupdate);

        try{
            getAllViews();
            registrateEventHandlers();
            database = Database.getInstance();
        }
        catch(Exception ex)
        {
            Toast.makeText(getApplicationContext(), ex.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    public void getAllViews()
    {
        bttnDate = (Button) this.findViewById(R.id.bttnDate);
        bttnTeam1 = (Button) this.findViewById(R.id.bttnTeam1);
        bttnTeam2 = (Button) this.findViewById(R.id.bttnTeam2);
        bttnRandom = (Button) this.findViewById(R.id.bttnRandom);
    }

    public void registrateEventHandlers()
    {
        bttnDate.setOnClickListener(this);
        bttnTeam1.setOnClickListener(this);
        bttnTeam2.setOnClickListener(this);
        bttnRandom.setOnClickListener(this);
        mDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                mYear = year;
                mMonth = month;
                mDay = dayOfMonth;
                Calendar cal = Calendar.getInstance();
                cal.set(year, month, dayOfMonth);
                DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
            }
        };
    }

    @Override
    public void onClick(View v) {
        if (v == bttnDate) {
            showDialog(DATE_DIALOG_ID);
        } else if (v == bttnTeam1) {

        } else if (v == bttnTeam2) {

        } else if (v == bttnRandom) {

        }
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        switch (id) {
            case DATE_DIALOG_ID:
                return new DatePickerDialog(this,
                        mDateSetListener,
                        mYear, mMonth, mDay);
        }
        return null;
    }
}
