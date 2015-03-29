package com.thabang.iset.providers.contentProvider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import android.util.Log;
import android.widget.Toast;

import com.thabang.iset.providers.contentProviderUtil.EventsContentProvidersUtil;
import com.thabang.iset.providers.databaseHelper.EventsDatabaseHelper;
import com.thabang.iset.providers.tables.EventsTable;

/**
 * Created by Mokomane MB
 */
public class EventContentProvider  extends ContentProvider{
    private static final String TAG = EventsContentProvidersUtil.class.getSimpleName();
    private EventsDatabaseHelper database;

    private static final UriMatcher uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
    static {
        uriMatcher.addURI(EventsContentProvidersUtil.EVENTS_AUTHORITY,EventsContentProvidersUtil.EVENTS_BASE_PATH,EventsContentProvidersUtil.QUERY_TYPE_LIST);
        uriMatcher.addURI(EventsContentProvidersUtil.EVENTS_AUTHORITY,EventsContentProvidersUtil.EVENTS_BASE_PATH +"/#",EventsContentProvidersUtil.QUERY_TYPE_BY_COLUMN_ID);
        uriMatcher.addURI(EventsContentProvidersUtil.EVENTS_AUTHORITY,EventsContentProvidersUtil.EVENTS_BASE_PATH +"/eventID/*",EventsContentProvidersUtil.QUERY_TYPE_BY_EVENT_ID);
    }

    @Override
    public boolean onCreate() {
        //I instantiate my db
        database = new EventsDatabaseHelper(getContext());
        return false;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        SQLiteQueryBuilder queryBuilder = new SQLiteQueryBuilder();
        queryBuilder.setTables(EventsTable.EVENTS_TABLE_NAME);
        //Is this a query by ID or by Global student ID
        int requestType= uriMatcher.match(uri);
        switch (requestType){
            case EventsContentProvidersUtil.QUERY_TYPE_LIST:
                //retrieving all --> select * from events
                break;
            case EventsContentProvidersUtil.QUERY_TYPE_BY_COLUMN_ID:
                //retrieving specific event --> select * form event where ID=x
                queryBuilder.appendWhere(EventsTable.COLUMN_CP_EVENT_ID+"="+uri.getLastPathSegment());
                break;
            case EventsContentProvidersUtil.QUERY_TYPE_BY_EVENT_ID:
                //retriving a event with specific global ID
                queryBuilder.appendWhere(EventsTable.COLUMN_EVENT_ID+"="+uri.getLastPathSegment());
                break;
            default:
                break;
        }
        Cursor cursor=null;
        SQLiteDatabase db = database.getWritableDatabase();
        try{
            cursor = queryBuilder.query(db,projection, selection,selectionArgs,null,null,EventsTable.DEFAULT_SORT_ORDER);
            if(cursor != null){ cursor.setNotificationUri(getContext().getContentResolver(), uri);}
        }catch (Exception e){
            Log.e(TAG, "Error while retrieving Events) ", e);
        }
        return cursor;

    }

    @Override
    public String getType(Uri uri) {
        return null;
    }

    @Override
    public Uri insert(Uri uri, ContentValues contentValues) {

        int requestType = uriMatcher.match(uri);
        if(requestType != EventsContentProvidersUtil.QUERY_TYPE_LIST){
            throw new IllegalArgumentException("Invalid URI pattern for insert Operation.");
        }
        SQLiteDatabase db = database.getWritableDatabase();
        long newLanguageLocalID = db.insert(EventsTable.EVENTS_TABLE_NAME,null,contentValues);

        getContext().getContentResolver().notifyChange(uri,null);
        Uri newEventsURI = Uri.parse(EventsContentProvidersUtil.EVENTS_CONTENT_URI.toString()+"/"+newLanguageLocalID);
        Toast.makeText(getContext(), "Added Event URI:: " + newEventsURI.toString(), Toast.LENGTH_LONG).show();
        return newEventsURI;
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        return 0;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        return 0;
    }
}
