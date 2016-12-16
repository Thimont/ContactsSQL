package com.example.souheib.contacts;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    public static SQLiteDatabase Contacts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Contacts =this.openOrCreateDatabase("Contacts",MODE_PRIVATE,null);
        Contacts.execSQL("CREATE TABLE IF NOT EXISTS contacts " +
                "(nom VARCHAR, prenom VARCHAR, tel  INTEGER(10))");
        setContentView(R.layout.activity_main);
    }

    public void addContact(View v){
        Intent intent = new Intent(this, add.class);
        startActivity(intent);
    }

    public void searchContact(View v){
        Intent intent = new Intent(this, search.class);
        startActivity(intent);
    }
}
