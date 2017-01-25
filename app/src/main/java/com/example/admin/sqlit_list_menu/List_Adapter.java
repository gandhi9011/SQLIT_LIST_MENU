package com.example.admin.sqlit_list_menu;

import android.app.Activity;
import android.content.Context;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Admin on 08-09-2016.
 */
public class List_Adapter extends BaseAdapter
{

    Context c;
    ArrayList mylist=new ArrayList();
    LinearLayout rl;
    STUDENT st;
    private SparseBooleanArray mSelectedItemsIds;

    public List_Adapter()
    {
    }

    public List_Adapter(Context c) {
        this.c = c;
    }

    public List_Adapter(Context c, ArrayList mylist) {
        this.c = c;
        this.mylist = mylist;
    }

    @Override
    public int getCount() {
        return mylist.size();
    }

    @Override
    public Object getItem(int position) {
        return mylist.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView tv1,tv2,tv;

        if(convertView==null)
        {
            LayoutInflater LI = ((Activity) c).getLayoutInflater();
            rl = (LinearLayout) LI.inflate(R.layout.hidden, null);
        }
        else
        {
            rl=(LinearLayout)convertView;
        }
        st=(STUDENT)mylist.get(position);
        tv1=(TextView)rl.findViewById(R.id.tv1);
        tv2=(TextView)rl.findViewById(R.id.tv2);
        tv=(TextView)rl.findViewById(R.id.tv);
        tv.setText(st.getRn()+"".toString());
        tv1.setText(st.getName().toString());
        tv2.setText(st.getCpi().toString());

        return rl;
    }

    public void remove(STUDENT object)
    {
        mylist.remove(object);
        notifyDataSetChanged();

    }
    public void toggleSelection(int position) {
        selectView(position, !mSelectedItemsIds.get(position));
    }
    public void removeSelection() {
        mSelectedItemsIds = new SparseBooleanArray();
        notifyDataSetChanged();
    }

    public void selectView(int position, boolean value) {
        if (value)
            mSelectedItemsIds.put(position, value);
        else
            mSelectedItemsIds.delete(position);
        notifyDataSetChanged();
    }

    public SparseBooleanArray getSelectedIds()
    {
        return mSelectedItemsIds;
    }
}
