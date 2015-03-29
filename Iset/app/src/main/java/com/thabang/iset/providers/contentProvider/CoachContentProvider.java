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

import com.thabang.iset.providers.contentProviderUtil.CoachContentProviderUtil;
import com.thabang.iset.providers.databaseHelper.CoachDatabaseHelper;
import com.thabang.iset.providers.tables.CoachTable;

/**
 * Created by CodeTribe1 on 2015-03-29.
 */
public class CoachContentProvider extends ContentProvider {

    private static final String TAG = CoachContentProvider.class.getSimpleName();
    private CoachDatabaseHelper database;

    private static final UriMatcher uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);

    static {
        uriMatcher.addURI(CoachContentProviderUtil.COACH_AUTHORITY, CoachContentProviderUtil.COACH_BASE_PATH, CoachContentProviderUtil.QUERY_TYPE_LIST);
        uriMatcher.addURI(CoachContentProviderUtil.COACH_AUTHORITY, CoachContentProviderUtil.COACH_BASE_PATH + "/#", CoachContentProviderUtil.QUERY_TYPE_BY_COLUMN_ID);
        uriMatcher.addURI(CoachContentProviderUtil.COACH_AUTHORITY, CoachContentProviderUtil.COACH_BASE_PATH + "/studentID/*", CoachContentProviderUtil.QUERY_TYPE_BY_COACH_ID);
    }

    @Override
    public boolean onCreate() {
        return false;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        SQLiteQueryBuilder queryBuilder = new SQLiteQueryBuilder();
        queryBuilder.setTables(CoachTable.COACH_TABLE_NAME);

        //Is this a query by ID or by Global coach ID
        int requestType = uriMatcher.match(uri);
        switch (requestType) {
            case CoachContentProviderUtil.QUERY_TYPE_LIST:
                //retrieving all --> select * from coaches
                break;
            case CoachContentProviderUtil.QUERY_TYPE_BY_COLUMN_ID:
                //retrieving specific coach --> select * form coach where ID=x
                queryBuilder.appendWhere(CoachTable.COACH_CP_MONTOR_ID + "=" + uri.getLastPathSegment());
                break;
            case CoachContentProviderUtil.QUERY_TYPE_BY_COACH_ID:
                //retriving a coach with specific global ID
                queryBuilder.appendWhere(CoachTable.COACH_CP_MONTOR_ID + "=" + uri.getLastPathSegment());
                break;
            default:
                break;
        }
        Cursor cursor = null;
        SQLiteDatabase db = database.getWritableDatabase();
        try {
            cursor = queryBuilder.query(db, projection, selection, selectionArgs, null, null, CoachTable.COACH_ORDER_ORDER);
            if (cursor != null) {
                cursor.setNotificationUri(getContext().getContentResolver(), uri);
            }
        } catch (Exception e) {
            Log.e(TAG, "Error while retrieving Coaches ", e);
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
        if (requestType != CoachContentProviderUtil.QUERY_TYPE_LIST) {
            throw new IllegalArgumentException("Invalid URI pattern for insert Operation.");
        }
        SQLiteDatabase db = database.getWritableDatabase();
        long newCoachLocalID = db.insert(CoachTable.COACH_TABLE_NAME, null, contentValues);

        getContext().getContentResolver().notifyChange(uri, null);
        Uri newCoachURI = Uri.parse(CoachContentProviderUtil.COACH_CONTENT_URI.toString() + "/" + newCoachLocalID);
        Toast.makeText(getContext(), "Added Coach URI:: " + newCoachURI.toString(), Toast.LENGTH_LONG).show();
        return newCoachURI;

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
