package com.thabang.iset.providers.tables;

import android.database.sqlite.SQLiteDatabase;

/**
 * Created by CodeTribe1 on 2015-03-29.
 */
public class CoachTable {
    public static final String COACH_TABLE_NAME="coach";
    public static final String COACH_MENTOR_NAME="name";
    public static final String COACH_LAST_NAME="lastname";
    public static final String COACH_ID_NUMBER="idnumber";
    public static final String COACH_CELL_NUMBER="cellnumber";
    public static final String COACH_ADDRESS="address";
    public static final String COACH_EMAIL="email";

    public static final String COACH_KID_ID="kidid";

    //global
    public static final String COACH_MENTOR_ID="mentorid";
    //local
    public static final String COACH_CP_MONTOR_ID="_ID";

    public static final String COACH_ORDER_ORDER="_IDDESC";

    public static final String[] DEFAULT_COACH_PROJECTIONS={COACH_MENTOR_NAME,COACH_LAST_NAME,COACH_ID_NUMBER,
            COACH_CELL_NUMBER,COACH_ADDRESS,COACH_EMAIL,COACH_KID_ID};

    private static final String CREATE_TABLE_QUERY = " CREATE TABLE "+COACH_TABLE_NAME+" "
            +" ( "+COACH_CP_MONTOR_ID+" integer primary key autoincrement,"
            +COACH_MENTOR_ID+ " text, "
            +COACH_MENTOR_NAME+ " text not null, "
            +COACH_LAST_NAME+ " text not null, "
            +COACH_ID_NUMBER+ " text not null, "
            +COACH_CELL_NUMBER+ " text not null, "
            +COACH_ADDRESS+ " text not null, "
            +COACH_EMAIL+ " text not null)";

    private static final String DROP_TABLE_QUERY = "DROP TABLE IF EXISTS "+COACH_TABLE_NAME;

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
