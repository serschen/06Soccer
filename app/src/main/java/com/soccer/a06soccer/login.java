package com.soccer.a06soccer;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import Data.Database;

/**
 * Created by anton on 15.05.2017.
 */

public class login  extends AppCompatActivity implements View.OnClickListener {
    private Button loginButton = null;
    private TextView txtUsername = null;
    private TextView txtPassword = null;
    private Database database = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        try{
            getAllViews();
            registrateEventHandlers();
            database = Database.getInstance();
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
        loginButton = (Button) this.findViewById(R.id.BtnLogin);
        txtUsername = (TextView) this.findViewById(R.id.txtLoginName);
        txtPassword = (TextView) this.findViewById(R.id.txtLoginPassword);
    }

    public void registrateEventHandlers()
    {
        loginButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        try {
            if(!txtUsername.getText().toString().isEmpty()&&!txtPassword.getText().toString().isEmpty()) {
                if (v == loginButton) {
                    if (database.checkUserData(txtUsername.getText().toString(), txtPassword.getText().toString())) {
                        Intent intent = new Intent(this, MainActivity.class);
                        startActivity(intent);
                    }
                }
            }
            else
            {
                Toast.makeText(getApplicationContext(),
                        "Data missing", Toast.LENGTH_SHORT)
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
}
