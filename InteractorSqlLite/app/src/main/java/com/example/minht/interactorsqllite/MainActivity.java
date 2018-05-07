package com.example.minht.interactorsqllite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private UserDAO userDAO;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userDAO = new UserDAO(this);
        boolean check = userDAO.delete(3);
        if( check )
            Toast.makeText(this,"Ok",Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(this,"Not ok",Toast.LENGTH_SHORT).show();
    }
}
