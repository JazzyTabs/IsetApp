package com.thabang.iset.providers.tables;

import android.database.sqlite.SQLiteDatabase;

/**
 * Created by CodeTribe1 on 2015-03-29.
 */
public class IsetTable {
    public static final String ISET_TABLE_NAME="iset";
    public static final String COLUMN_NAME="name";
    public static final String COLUMN_LAST_NAME="last";
    public static final String COLUMN_ID_NUMBER="idnumber";
    public static final String COLUMN_CELL_NUM="cellnum";
    public static final String COLUMN_ADDRESS="address";
    public static final String COLUMN_EMAIL="email";
    public static final String COLUMN_MENTOR_ID="mentorid";
    public static final String COLUMN_TEAM_ID="teamid";

    //global ID
    public static final String COLUMN_ISET_ID = "isetid";
    //local ID
    public static final String COLUMN_CP_ISET_ID = "_ID";

    public static final String DEFAULT_SORT_ORDER = "_IDDesc";

    public static final String[] DEFAULT_ISET_PROJECTIONS={COLUMN_NAME,COLUMN_LAST_NAME,
            COLUMN_ID_NUMBER,COLUMN_CELL_NUM,COLUMN_ADDRESS,COLUMN_EMAIL,COLUMN_MENTOR_ID,COLUMN_TEAM_ID};

    private static final String CREATE_TABLE_QUERY = " CREATE TABLE "+ISET_TABLE_NAME+" "
            +" ( "+COLUMN_ISET_ID+" integer primary key autoincrement,"
            +COLUMN_ISET_ID+ " text, "
            +COLUMN_NAME+ " text not null, "
            +COLUMN_LAST_NAME+ " text not null, "
            +COLUMN_ID_NUMBER+ " text not null, "
            +COLUMN_CELL_NUM+ " text not null, "
            +COLUMN_ADDRESS+ " text not null, "
            +COLUMN_EMAIL+ " text , "
            +COLUMN_MENTOR_ID+ " text, "
            +COLUMN_TEAM_ID+ " text )";

    private static final String DROP_TABLE_QUERY = "DROP TABLE IF EXISTS "+ISET_TABLE_NAME;
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
