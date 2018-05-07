package com.example.minht.interactorsqllite;

import android.animation.TimeAnimator;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by minht on 4/23/2018.
 */

public class UserDAO {
    private SQLiteDatabase db;
    private Context context;

    public UserDAO(Context context){
        Sqlite sqlite = new Sqlite(context);
        db = sqlite.open();
        this.context = context;
    }

    public boolean addUser(User user){
        ContentValues content = new ContentValues();
        content.put(Sqlite.NAME_User,user.getName());
        content.put(Sqlite.AGE_User,user.getAge());

        long res = db.insert(Sqlite.TB_User,null,content);

        if( res != 0 )
            return true;
        else
            return false;
    }

    public List<User> getListUser(){
        List<User> list = new ArrayList<>();
        String query = "select * from " + Sqlite.TB_User;
        Cursor cursor = db.rawQuery(query,null);

        cursor.moveToFirst();
        while( !cursor.isAfterLast()){
            User user = new User(cursor.getInt(0),cursor.getString(1),cursor.getInt(2));
            list.add(user);
            cursor.moveToNext();
        }

        return list;
    }

    public boolean delete(int id){
        int res = db.delete(Sqlite.TB_User,Sqlite.ID_User + " = " +id,null);
        return res != 0? true:false;
    }

    public boolean update(User user){
        ContentValues content = new ContentValues();
        content.put(Sqlite.NAME_User,user.getName());
        content.put(Sqlite.AGE_User,user.getAge());

        long res = db.update(Sqlite.TB_User,content,Sqlite.ID_User + " = " + user.getId() ,null);

        return res != 0 ? true:false;
    }

}
