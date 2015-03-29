package com.thabang.iset.providers.tables;

import android.database.sqlite.SQLiteDatabase;

/**
 * Created by MokomaneMB
 */
public class EventsTable {
    public static final String EVENTS_TABLE_NAME = "events";
    public static final String COLUMN_EVENT_NAME = "name";
    public static final String COLUMN_LOCATION = "location";
    public static final String COLUMN_DATE = "date";
    public static final String COLUMN_MENTOR_ID = "mentor";
    public static final String COLUMN_USERS_ID = "user";
    public static final String COLUMN_PHOTO = "photo";
    //this is a global
    public static final String COLUMN_EVENT_ID = "eventID";
    //this local
    public static final String COLUMN_CP_EVENT_ID = "_ID";

    public static final String DEFAULT_SORT_ORDER="_ID Desc" ;

    public static final String[] DEFAULT_EVENTS_PROJECTIONS={EVENTS_TABLE_NAME,COLUMN_EVENT_NAME,
            COLUMN_LOCATION,COLUMN_DATE,COLUMN_EVENT_ID,COLUMN_MENTOR_ID,COLUMN_USERS_ID,COLUMN_PHOTO};

    private static final String CREATE_TABLE_QUERY = " CREATE TABLE "+EVENTS_TABLE_NAME+" "
            +" ( "+COLUMN_CP_EVENT_ID+" integer primary key autoincrement,"
            +COLUMN_EVENT_NAME+ " text, "
            +COLUMN_LOCATION+ " text not null, "
            +COLUMN_DATE+ " text not null, "
            +COLUMN_MENTOR_ID+ " integer, "
            +COLUMN_USERS_ID+ " integer, "
            +COLUMN_PHOTO+ "blob)";

    private static final String DROP_TABLE_QUERY = "DROP TABLE IF EXISTS "+EVENTS_TABLE_NAME;


    public static void onCreate(SQLiteDatabase database){
        //create a database/table
        database.execSQL(CREATE_TABLE_QUERY);
    }

    public static void onUpgrade(SQLiteDatabase database){
        //update the database/table
        database.execSQL(DROP_TABLE_QUERY);
        onCreate(database);
    }



}

