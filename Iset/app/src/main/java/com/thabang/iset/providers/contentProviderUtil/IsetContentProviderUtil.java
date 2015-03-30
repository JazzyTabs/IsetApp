package com.thabang.iset.providers.contentProviderUtil;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;

import com.thabang.iset.dto.IsetrootusersDTO;
import com.thabang.iset.providers.tables.IsetTable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by CodeTribe1 on 2015-03-29.
 */
public class IsetContentProviderUtil {
    private static final String TAG = IsetContentProviderUtil.class.getSimpleName();


    public static final String ISET_AUTHORITY = "com.thabang.iset.providers.contentProviderUtil";
    public static final String ISET_BASE_PATH = "language";
    public static final Uri ISET_CONTENT_URI = Uri.parse("content://"+ISET_AUTHORITY+"/"+ISET_BASE_PATH);

    //These are literal values for Content-Resolver Query Types
    //Query Types
    public static final int QUERY_TYPE_BY_COLUMN_ID = 1;
    public static final int QUERY_TYPE_BY_ISET_ID = 2;
    public static final int QUERY_TYPE_LIST = 3;

    //----------get list of languages---------------------------
    public static List<IsetrootusersDTO> getLanguages(ContentResolver contentResolver){
        List<IsetrootusersDTO> languageList = new ArrayList<IsetrootusersDTO>();
        Cursor languageListCursor = contentResolver.query(ISET_CONTENT_URI, IsetTable.DEFAULT_ISET_PROJECTIONS,null,null,IsetTable.DEFAULT_SORT_ORDER);
        if(languageListCursor != null){
            //we have the data, now we're iterating
            while(languageListCursor.moveToNext()){
                //get values from the cursor
                IsetrootusersDTO language = fromCursor(languageListCursor);
                languageList.add(language);
            }
        }

        return languageList;
    }

    //----------add language-------------------------------------
    public static Uri addlanguage(ContentResolver contentResolver, IsetrootusersDTO languageDataObject){
        Log.i(TAG, "Adding Language:: \n " + languageDataObject);
        Uri newLanguageUri = null;
        ContentValues newLanguageValues = fromLanguageDTO(languageDataObject);
        if(newLanguageValues != null){
            //use content-resolver to save into CP
            newLanguageUri = contentResolver.insert(ISET_CONTENT_URI,newLanguageValues);
        }
        return newLanguageUri;


    }

    //---------get student from cursor--------------------------------
    private static IsetrootusersDTO fromCursor(Cursor cursor){
        String name=cursor.getString(cursor.getColumnIndex(IsetTable.COLUMN_NAME));
        String lastname=cursor.getString(cursor.getColumnIndex(IsetTable.COLUMN_LAST_NAME));
        Integer idnumber =cursor.getInt(cursor.getColumnIndex(IsetTable.COLUMN_ID_NUMBER));
        Integer cellnum= cursor.getInt(cursor.getColumnIndex(IsetTable.COLUMN_CELL_NUM));
        String address=cursor.getString(cursor.getColumnIndex(IsetTable.COLUMN_ADDRESS));
        String email=cursor.getString(cursor.getColumnIndex(IsetTable.COLUMN_EMAIL));
        Integer mentorid=cursor.getInt(cursor.getColumnIndex(IsetTable.COLUMN_MENTOR_ID));
        Integer teamid=cursor.getInt(cursor.getColumnIndex(IsetTable.COLUMN_TEAM_ID));
        Integer globalisetid=cursor.getInt(cursor.getColumnIndex(IsetTable.COLUMN_ISET_ID));
        // int id=cursor.getInt(cursor.getColumnIndex(StudentsTable.COLUMN_CP_STUDENT_ID));

        IsetrootusersDTO iset = new IsetrootusersDTO(0,name,lastname,1,2,address,email,3,4);
        return  iset;
    }
    //-----------get values to insert------------------------------------
    public static ContentValues fromLanguageDTO(IsetrootusersDTO IsetDataObject){
        if(IsetDataObject==null){ return null;}

        ContentValues valuesToInsert = new ContentValues();
        valuesToInsert.put(IsetTable.COLUMN_NAME,IsetDataObject.getIsetRootUsersName());
        valuesToInsert.put(IsetTable.COLUMN_LAST_NAME,IsetDataObject.getIsetRootUsersLastName());
        valuesToInsert.put(IsetTable.COLUMN_ID_NUMBER,IsetDataObject.getIsetRootUsersID());
        valuesToInsert.put(IsetTable.COLUMN_CELL_NUM,IsetDataObject.getIsetRootUsersID());
        valuesToInsert.put(IsetTable.COLUMN_ADDRESS,IsetDataObject.getIsetRootUsersID());
        valuesToInsert.put(IsetTable.COLUMN_EMAIL,IsetDataObject.getIsetRootUsersID());

        return valuesToInsert;
    }
}
