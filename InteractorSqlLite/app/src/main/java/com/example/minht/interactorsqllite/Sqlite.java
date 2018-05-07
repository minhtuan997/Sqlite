package com.example.minht.interactorsqllite;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by minht on 4/23/2018.
 */

public class Sqlite extends SQLiteOpenHelper {
    public static final String NAME_DB = "UserManager";
    public static final String TB_User = "User";
    public static final String ID_User= "ID";
    public static final String NAME_User = "Name";
    public static final String AGE_User= "Age";
    private Context context;

    public Sqlite(Context context) {
        super(context, NAME_DB, null, 3);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query_TB_User = "create table " + TB_User  + " ( " + ID_User + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + NAME_User + " text not null,"
                + AGE_User + " integer not null)";

        sqLiteDatabase.execSQL(query_TB_User);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if( oldVersion < newVersion ){
            db.execSQL("drop table if exists " +  TB_User);
            onCreate(db);
        }
    }

    public SQLiteDatabase open(){
        return this.getWritableDatabase();
    }
}
