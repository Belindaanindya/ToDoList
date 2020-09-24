package com.example.todolist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

public class ListViewAdapter extends ArrayAdapter<String> {
    int groupid;
    String[] item_list;
    Context context;
    public ListViewAdapter(Context context, int layoutResourceId, String[] item_list){
        super(context,layoutResourceId, item_list);
        this.context = context;
        this.groupid = layoutResourceId;
        this.item_list = item_list;

    }
    // Hold views of the ListView to improve its scrolling performance
    static class ViewHolder {
        public TextView textview;
        public Button edit;
        public Button delete;

    }

    public View getView(int position, View convertView, ViewGroup parent) {

        View rowView = convertView;
        ViewHolder viewHolder = null;
        if(rowView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            rowView = inflater.inflate(groupid, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.textview = (TextView) rowView.findViewById(R.id.text1);
            viewHolder.edit = (Button) rowView.findViewById(R.id.edit_btn);
            viewHolder.delete = (Button) rowView.findViewById(R.id.delete_btn);
            rowView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) rowView.getTag();
        }
        ViewHolder holder = (ViewHolder) rowView.getTag();
        holder.textview.setText(item_list[position]);
        return rowView;
    }
}
