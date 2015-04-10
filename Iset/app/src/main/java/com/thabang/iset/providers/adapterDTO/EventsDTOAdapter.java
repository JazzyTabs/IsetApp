package com.thabang.iset.providers.adapterDTO;

/**
 * Created by CodeTribe1 on 2015-04-10.
 */

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;


import com.thabang.iset.dto.EventsDTO;

import java.util.List;

import data.android.unisa.com.iset.R;

/**
 * Created by Mokomane on 2015-04-10.
 */
public class EventsDTOAdapter extends BaseAdapter {

    Context mCtx;
    List<String> mList;
    List<EventsDTO>eventList;

    public EventsDTOAdapter(Context mCtx, List<EventsDTO> eventList) {
        this.mCtx = mCtx;
        this.eventList = eventList;
    }

    @Override
    public int getCount() {
        return eventList.size();
    }

    @Override
    public Object getItem(int position) {
        return eventList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        holder h;
        //code to recycle the views

        if(convertView ==null){
            h = new holder();
            LayoutInflater inflater = (LayoutInflater) mCtx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.list_events, parent, false);
            h.title = (TextView) convertView.findViewById(R.id.title);
            convertView.setTag(h);
        }else{
            h = (holder) convertView.getTag();
        }
        String title = eventList.get(position).getEventName();
        h.title.setText(title);
        return convertView;
    }
    class holder{
        TextView title;
    }
}

