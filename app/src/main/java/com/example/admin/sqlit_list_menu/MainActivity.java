package com.example.admin.sqlit_list_menu;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends Activity
{
    EditText et1,et2,et3;
    Button b,b1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1=(EditText)findViewById(R.id.et1);
        et2=(EditText)findViewById(R.id.et2);
        et3=(EditText)findViewById(R.id.et3);
        b=(Button)findViewById(R.id.button);
        b1=(Button)findViewById(R.id.button1);

        SQLiteDatabase db=openOrCreateDatabase("mydb.db", Context.MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS STUDENT(sroll_no Int primerykey ,sname Text,CPI Text)");


        db.close();

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                for (int j = 0; j <= 100; j++)
                {
                    SQLiteDatabase db = openOrCreateDatabase("mydb.db", Context.MODE_PRIVATE, null);
                    db.execSQL("INSERT INTO STUDENT (sroll_no,sname,CPI) VALUES ('" +j + "','" + et2.getText().toString() + "','" + et3.getText().toString() + "')");
                    db.close();
                }
                Toast.makeText(MainActivity.this, "DATA INSERTED", Toast.LENGTH_LONG).show();
                et1.setText("");
                et2.setText("");
                et3.setText("");
            }
        });

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i=new Intent(MainActivity.this,Main2Activity.class);
                startActivity(i);

            }
        });
    }
}
