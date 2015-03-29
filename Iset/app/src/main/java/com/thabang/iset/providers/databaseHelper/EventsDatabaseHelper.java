package com.thabang.iset.providers.databaseHelper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.thabang.iset.providers.tables.EventsTable;

/**
 * Created by MokomaneMB
 */
public class EventsDatabaseHelper extends SQLiteOpenHelper{
    private static final int version = 1;
    private static final String DATABASE_FILE="events.db";

    public EventsDatabaseHelper(Context context) {
        super(context, DATABASE_FILE, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        EventsTable.onCreate(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        EventsTable.onUpgrade(db);
    }
}
