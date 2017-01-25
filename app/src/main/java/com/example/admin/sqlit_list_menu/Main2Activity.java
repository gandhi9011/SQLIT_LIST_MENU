package com.example.admin.sqlit_list_menu;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.ActionMode;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity {
    GridView lvDetail;
    ArrayList data=new ArrayList();
    Context context = Main2Activity.this;
    List_Adapter la=new List_Adapter(context,data);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        lvDetail = (GridView) findViewById(R.id.lvCustomList);
        getDataInList();
        lvDetail.setAdapter(new List_Adapter(context, data));
        registerForContextMenu(lvDetail);

        lvDetail.setChoiceMode(GridView.CHOICE_MODE_MULTIPLE_MODAL);
        lvDetail.setMultiChoiceModeListener(new AbsListView.MultiChoiceModeListener() {
            @Override
            public void onItemCheckedStateChanged(ActionMode mode, int position, long id, boolean checked) {

            }

            @Override
            public boolean onCreateActionMode(ActionMode mode, Menu menu) {
                return false;
            }

            @Override
            public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
                return false;
            }

            @Override
            public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
                return false;
            }

            @Override
            public void onDestroyActionMode(ActionMode mode) {

            }
        });

    }

    private void getDataInList()
    {
        SQLiteDatabase db = openOrCreateDatabase("mydb.db", Context.MODE_PRIVATE, null);
        Cursor c = db.rawQuery("SELECT * FROM STUDENT", null);
        while (c.moveToNext()) {
            STUDENT st=new STUDENT();
            st.setRn(c.getInt(0));
            st.setName(c.getString(1));
            st.setCpi(c.getString(2));
            data.add(st);
            Log.d("0000", c.getString(1));
            Log.d("1111", c.getString(2));
            Log.d("0011", c.getInt(0) + "");

        }

        db.close();
    }
/*
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo)
    {
        super.onCreateContextMenu(menu, v, menuInfo);
        AdapterView.AdapterContextMenuInfo info=(AdapterView.AdapterContextMenuInfo)menuInfo;
        STUDENT st1=(STUDENT)(data.get(info.position));
        menu.setHeaderTitle(st1.getName());
        menu.add(0, v.getId(), 0, "EDIT");//groupId, itemId, order, title
        menu.add(0, v.getId(), 0, "DELETE");




    }


    public boolean onContextItemSelected(MenuItem item){
        AdapterView.AdapterContextMenuInfo adapterContextMenuInfo= (AdapterView.AdapterContextMenuInfo)item.getMenuInfo();
        STUDENT st2=(STUDENT)(data.get(adapterContextMenuInfo.position));
        if(item.getTitle()=="EDIT")
        {

            Intent i=new Intent(Main2Activity.this,EditActivity.class);
            i.putExtra("name", st2.getRn());
            startActivity(i);
            Toast.makeText(getApplicationContext(), "EDIT DATA", Toast.LENGTH_LONG).show();
        }
        else if(item.getTitle()=="DELETE"){
            SQLiteDatabase db = openOrCreateDatabase("mydb.db", Context.MODE_PRIVATE, null);
            String sql="DELETE FROM STUDENT  WHERE sroll_no =" + st2.getRn();
            Log.d("sssqqqlll", sql);
            db.execSQL(sql);
            db.close();
            List_Adapter la=(List_Adapter)lvDetail.getAdapter();
            la.notifyDataSetChanged();
            getDataInList();
            lvDetail.setAdapter(la);
            registerForContextMenu(lvDetail);

            Toast.makeText(getApplicationContext(),"DELETED DATA",Toast.LENGTH_LONG).show();
        }else{
            return false;
        }
        return true;
    }
*/
}
