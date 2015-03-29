package com.thabang.iset.providers.contentProviderUtil;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;

import com.thabang.iset.dto.EventsDTO;
import com.thabang.iset.providers.tables.EventsTable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by MokomaneMB
 */
public class EventsContentProvidersUtil {
    private static final String TAG = EventsContentProvidersUtil.class.getSimpleName();

    public static final String EVENTS_AUTHORITY = "com.thabang.iset.providers.contentProviderUtil";
    public static final String EVENTS_BASE_PATH = "event";
    public static final Uri EVENTS_CONTENT_URI = Uri.parse("content://"+EVENTS_AUTHORITY+"/"+EVENTS_BASE_PATH);

    //These are literal values for Content-Resolver Query Types
    //Query  Types

    public static final int QUERY_TYPE_BY_COLUMN_ID = 1;
    public static final int QUERY_TYPE_BY_EVENT_ID = 2;
    public static final int QUERY_TYPE_LIST = 3;


    //----------get list of languages---------------------------
    public static List<EventsDTO> getLanguages(ContentResolver contentResolver){
        List<EventsDTO> eventList = new ArrayList<EventsDTO>();
        Cursor eventListCursor = contentResolver.query(EVENTS_CONTENT_URI, EventsTable.DEFAULT_EVENTS_PROJECTIONS,null,null, EventsTable.DEFAULT_SORT_ORDER);
        if(eventListCursor != null){
            //we have the data, now we're iterating
            while(eventListCursor.moveToNext()){
                //get values from the cursor
                EventsDTO events = fromCursor(eventListCursor);
                eventList.add(events);
            }
        }

        return eventList;
    }

    //----------add events-------------------------------------
    public static Uri addevent(ContentResolver contentResolver, EventsDTO eventsDataObject){
        Log.i(TAG, "Events are being populated:: \n " + eventsDataObject);
        Uri newEventsUri = null;
        ContentValues newEventsValues = fromEventsDTO(eventsDataObject);
        if(newEventsValues != null){
            //use content-resolver to save into CP
            newEventsUri = contentResolver.insert(EVENTS_CONTENT_URI,newEventsValues);
        }
        return newEventsUri;
    }

    //---------get student from cursor--------------------------------
    private static EventsDTO fromCursor(Cursor cursor){
        String name=cursor.getString(cursor.getColumnIndex(EventsTable.COLUMN_EVENT_NAME));
        String location=cursor.getString(cursor.getColumnIndex(EventsTable.COLUMN_LOCATION));
        Date date = new Date(cursor.getColumnIndex(EventsTable.COLUMN_DATE));
        Integer eventid=cursor.getInt(cursor.getColumnIndex(EventsTable.COLUMN_EVENT_ID));
        Integer mentorid=cursor.getInt(cursor.getColumnIndex(EventsTable.COLUMN_MENTOR_ID));
        Integer userid=cursor.getInt(cursor.getColumnIndex(EventsTable.COLUMN_USERS_ID));
        byte[] photo = cursor.getBlob(cursor.getColumnIndex(EventsTable.COLUMN_PHOTO));

        EventsDTO events = new EventsDTO(0,name,location,date,mentorid,userid,photo);
        return  events;
    }
    //-----------get values to insert------------------------------------
    public static ContentValues fromEventsDTO(EventsDTO EventDataObject){
        if(EventDataObject==null){ return null;}

        ContentValues valuesToInsert = new ContentValues();

        valuesToInsert.put(EventsTable.COLUMN_EVENT_NAME,EventDataObject.getEventName());
        valuesToInsert.put(EventsTable.COLUMN_LOCATION,EventDataObject.getEventLocation());
        valuesToInsert.put(EventsTable.COLUMN_DATE, String.valueOf(EventDataObject.getEventDate()));
        valuesToInsert.put(EventsTable.COLUMN_EVENT_ID,EventDataObject.getEventID());
        valuesToInsert.put(EventsTable.COLUMN_MENTOR_ID,EventDataObject.getCoachMentorID());
        valuesToInsert.put(EventsTable.COLUMN_USERS_ID,EventDataObject.getIsetRootUsersID());
        valuesToInsert.put(EventsTable.COLUMN_PHOTO, String.valueOf(EventDataObject.getPhotouploadList()));

        return valuesToInsert;
    }
}
