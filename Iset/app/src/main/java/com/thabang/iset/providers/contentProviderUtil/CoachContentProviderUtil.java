package com.thabang.iset.providers.contentProviderUtil;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;

import com.thabang.iset.dto.CoachmentorDTO;
import com.thabang.iset.providers.tables.CoachTable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by CodeTribe1 on 2015-03-29.
 */
public class CoachContentProviderUtil {
    private static final String TAG = CoachContentProviderUtil.class.getSimpleName();


    public static final String COACH_AUTHORITY = "com.thabang.iset.providers.contentProviderUtil";
    public static final String COACH_BASE_PATH = "coach";
    public static final Uri COACH_CONTENT_URI = Uri.parse("content://"+COACH_AUTHORITY+"/"+COACH_BASE_PATH);

    //These are literal values for Content-Resolver Query Types
    //Query Types
    public static final int QUERY_TYPE_BY_COLUMN_ID = 1;
    public static final int QUERY_TYPE_BY_COACH_ID = 2;
    public static final int QUERY_TYPE_LIST = 3;

    //----------getting list of coaaches---------------------------
    public static List<CoachmentorDTO> getLanguages(ContentResolver contentResolver){
        List<CoachmentorDTO> coachList = new ArrayList<CoachmentorDTO>();
        Cursor coaachListCursor = contentResolver.query(COACH_CONTENT_URI, CoachTable.DEFAULT_COACH_PROJECTIONS,null,null,CoachTable.COACH_CP_ORDER_ORDER);
        if(coaachListCursor != null){
            //we have the data, now we're iterating
            while(coaachListCursor.moveToNext()){
                //get values from the cursor
                CoachmentorDTO coach = fromCursor(coaachListCursor);
                coachList.add(coach);
            }
        }

        return coachList;
    }

    //----------add coach-------------------------------------
    public static Uri addcoach(ContentResolver contentResolver, CoachmentorDTO coachDataObject){
        Log.i(TAG, "Coach is being populated \n " + coachDataObject);
        Uri newCoachUri = null;
        ContentValues newCoachValues = fromLanguageDTO(coachDataObject);
        if(newCoachValues != null){
            //use content-resolver to save into CP
            newCoachUri = contentResolver.insert(COACH_CONTENT_URI,newCoachValues);
        }
        return newCoachUri;


    }

    //---------getting coach from cursor--------------------------------
    private static CoachmentorDTO fromCursor(Cursor cursor){
        String name=cursor.getString(cursor.getColumnIndex(CoachTable.COACH_MENTOR_NAME));
        String lastname=cursor.getString(cursor.getColumnIndex(CoachTable.COACH_LAST_NAME));
        Integer idnumber =cursor.getInt(cursor.getColumnIndex(CoachTable.COACH_ID_NUMBER));
        Integer cellnum= cursor.getInt(cursor.getColumnIndex(CoachTable.COACH_CELL_NUMBER));
        String address=cursor.getString(cursor.getColumnIndex(CoachTable.COACH_ADDRESS));
        String email=cursor.getString(cursor.getColumnIndex(CoachTable.COACH_EMAIL));
        Integer kid=cursor.getInt(cursor.getColumnIndex(CoachTable.COACH_KID_ID));


        CoachmentorDTO coach = new CoachmentorDTO(name,lastname,idnumber,cellnum,address,email,kid);
        return  coach;
    }
    //-----------get values to insert------------------------------------
    public static ContentValues fromLanguageDTO(CoachmentorDTO CoachDataObject){
        if(CoachDataObject==null){ return null;}

        ContentValues valuesToInsert = new ContentValues();
        valuesToInsert.put(CoachTable.COACH_MENTOR_NAME,CoachDataObject.getCoachMentorName());
        valuesToInsert.put(CoachTable.COACH_LAST_NAME,CoachDataObject.getCoachMentorLastName());
        valuesToInsert.put(CoachTable.COACH_ID_NUMBER,CoachDataObject.getCoachMentorIDNumber());
        valuesToInsert.put(CoachTable.COACH_CELL_NUMBER,CoachDataObject.getCoachMentorCellNum());
        valuesToInsert.put(CoachTable.COACH_ADDRESS,CoachDataObject.getCoachMentorAddress());
        valuesToInsert.put(CoachTable.COACH_EMAIL,CoachDataObject.getCoachMentorEmail());
        valuesToInsert.put(CoachTable.COACH_KID_ID,CoachDataObject.getKidsID());

        return valuesToInsert;
    }
}
