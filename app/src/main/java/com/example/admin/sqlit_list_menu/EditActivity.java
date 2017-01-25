package com.example.admin.sqlit_list_menu;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class EditActivity extends AppCompatActivity {
    EditText et2,et3;
    TextView tv;
    Button b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        et2=(EditText)findViewById(R.id.edt2);
        et3=(EditText)findViewById(R.id.edt3);
        tv=(TextView)findViewById(R.id.tvd);
        b=(Button)findViewById(R.id.buttond);
        Intent i=getIntent();
        final int rn=i.getIntExtra("name",0);
        tv.setText("ROLL NO:"+rn+"");
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = openOrCreateDatabase("mydb.db", Context.MODE_PRIVATE, null);
                String sql="UPDATE STUDENT SET sname = '" + et2.getText().toString() + "' , CPI = '" + et3.getText().toString() + "' WHERE sroll_no =" + rn;
                Log.d("sssqqqlll",sql);
                db.execSQL(sql);

                db.close();
                Intent i1 = new Intent(EditActivity.this, Main2Activity.class);
                startActivity(i1);

            }
        });
    }
}
