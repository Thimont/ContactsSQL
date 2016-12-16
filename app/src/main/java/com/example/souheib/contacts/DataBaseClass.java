package com.example.souheib.contacts;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by flthiebl on 16/12/2016.
 */
// pour utiliser cette classe, l'instancier dans le main et faire un get dans le add et le search
public class DataBaseClass {
    private static SQLiteDatabase instantce = null;

    public DataBaseClass() {
    }

    public static void initInstance(Context c) {
        if(instantce == null) {
            instantce = c.openOrCreateDatabase("Contacts",MODE_PRIVATE,null);
            instantce.execSQL("CREATE TABLE IF NOT EXISTS contacts " +
                    "(nom VARCHAR, prenom VARCHAR, tel  INTEGER(10))");
        }
    }

    public static SQLiteDatabase getInstantce() {
        return instantce;
    }
}
