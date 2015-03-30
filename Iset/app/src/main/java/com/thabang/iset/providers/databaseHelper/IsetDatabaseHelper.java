package com.thabang.iset.providers.databaseHelper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by CodeTribe1 on 2015-03-29.
 */
public class IsetDatabaseHelper extends SQLiteOpenHelper {

    private static final int version = 1;
    private static final String DATABASE_FILE="iset.db";

    public IsetDatabaseHelper(Context context) {
        super(context, DATABASE_FILE, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
