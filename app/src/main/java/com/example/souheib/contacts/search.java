package com.example.souheib.contacts;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;

import static android.R.attr.visible;

public class search extends AppCompatActivity {
    SQLiteDatabase Contacts;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        Contacts = MainActivity.Contacts;
        //Contacts =this.openOrCreateDatabase("Contacts",MODE_PRIVATE,null);

    }

    public void chercher(View v) {


        try {

            TextView res=(TextView) findViewById(R.id.sTTel);
            EditText lname=(EditText) findViewById(R.id.slname);
            res.setVisibility(View.INVISIBLE);

            Cursor c=Contacts.rawQuery("SELECT * FROM contacts where nom LIKE '%" +
                                        lname.getText() +"%' or prenom LIKE '%"+
                                        lname.getText() +"%'",null);

            if(c.getCount() != 0){
                c.moveToFirst();
                int inom=c.getColumnIndex("nom");
                int iprenom=c.getColumnIndex("prenom");
                int itel=c.getColumnIndex("tel");

                res.setText(c.getString(iprenom) + " " +
                            c.getString(inom) + " : " +
                            Integer.toString(c.getInt(itel)));
            }else{
                res.setText("Aucune correspondance !");
            }

            res.setVisibility(View.VISIBLE);
        }catch(Exception e){
            Log.e ("Main : ",e.toString());
        }
    }



}
