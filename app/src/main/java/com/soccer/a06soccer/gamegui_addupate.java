package com.soccer.a06soccer;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import Data.Database;
import Data.Game;
@SuppressWarnings("deprecation")
public class gamegui_addupate extends AppCompatActivity implements View.OnClickListener {
    static final int DATE_DIALOG_ID = 0;
    private Button bttnDate = null;
    private Button bttnTeam1 = null;
    private Button bttnTeam2 = null;
    private Button bttnRandom = null;
    private TextView tvDate = null;
    private EditText etTeam1 = null;
    private EditText etTeam2 = null;
    private Game currentGame = null;
    private Date currentDate = null;
    private Database database = null;
    private DatePickerDialog.OnDateSetListener mDateSetListener = null;

    SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");

    private Calendar calendar = Calendar.getInstance();

    private int mYear = calendar.get(Calendar.YEAR);
    private int mMonth = calendar.get(Calendar.MONTH);
    private int mDay = calendar.get(Calendar.DAY_OF_MONTH);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gamegui_addupdate);

        try{
            getAllViews();
            registrateEventHandlers();
            database = Database.getInstance();
            currentGame = database.getCurrentGame();
            currentDate = currentGame.getDate();


            String sdate = dateFormat.format(currentDate);

            tvDate.setText(sdate);

            etTeam1.setText("" + currentGame.getGoalsShotTeam1());
            etTeam2.setText("" + currentGame.getGoalsShotTeam2());
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
        tvDate = (TextView) this.findViewById(R.id.tvDate);
        etTeam1 = (EditText) this.findViewById(R.id.etTeam1);
        etTeam2 = (EditText) this.findViewById(R.id.etTeam2);
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
                mMonth = month + 1;
                mDay = dayOfMonth;
                Calendar cal = Calendar.getInstance();
                cal.set(year, month, dayOfMonth);
                String showDate = mDay + "." + mMonth + "." + mYear;
                tvDate.setText(showDate);      //Date wird aktualisiert

                Date newDate = null;
                try {
                    newDate = dateFormat.parse(showDate);
                } catch (ParseException e) {
                    Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG).show();
                }
                currentGame.setDate(newDate);   //Datum wird beim Game gespeichert
            }
        };
    }

    @Override
    public void onClick(View v) {
        if (v == bttnDate) {
            showDialog(DATE_DIALOG_ID);
        } else if (v == bttnTeam1) {
            Intent intent = new Intent(getBaseContext(), teampicker_gui.class);
            intent.putExtra("TEAM SELECTED", "T1");
            startActivity(intent);
        } else if (v == bttnTeam2) {
            Intent intent = new Intent(getBaseContext(), teampicker_gui.class);
            intent.putExtra("TEAM SELECTED", "T2");
            startActivity(intent);
        } else if (v == bttnRandom) {

        }
    }

    @Override
    public void onBackPressed () {
        currentGame.setGoalsShotTeam1(Integer.parseInt(etTeam1.getText().toString()));
        currentGame.setGoalsShotTeam2(Integer.parseInt(etTeam2.getText().toString()));

        super.onBackPressed();
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
