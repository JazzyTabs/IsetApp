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

import com.thabang.iset.providers.contentProviderUtil.IsetContentProviderUtil;
import com.thabang.iset.providers.databaseHelper.IsetDatabaseHelper;
import com.thabang.iset.providers.tables.IsetTable;

/**
 * Created by CodeTribe1 on 2015-03-30.
 */
public class IsetContentProvider extends ContentProvider{

    private static final String TAG = IsetContentProvider.class.getSimpleName();
    private IsetDatabaseHelper database;

    private static final UriMatcher uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);

    static {
        uriMatcher.addURI(IsetContentProviderUtil.ISET_AUTHORITY, IsetContentProviderUtil.ISET_BASE_PATH, IsetContentProviderUtil.QUERY_TYPE_LIST);
        uriMatcher.addURI(IsetContentProviderUtil.ISET_AUTHORITY, IsetContentProviderUtil.ISET_BASE_PATH + "/#", IsetContentProviderUtil.QUERY_TYPE_BY_COLUMN_ID);
        uriMatcher.addURI(IsetContentProviderUtil.ISET_AUTHORITY, IsetContentProviderUtil.ISET_BASE_PATH + "/studentID/*", IsetContentProviderUtil.QUERY_TYPE_BY_ISET_ID);
    }

    @Override
    public boolean onCreate() {
        //instantiate my DB
        database = new IsetDatabaseHelper(getContext());
        return false;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        SQLiteQueryBuilder queryBuilder = new SQLiteQueryBuilder();
        queryBuilder.setTables(IsetTable.ISET_TABLE_NAME);

        //Is this a query by ID or by Global iset ID
        int requestType = uriMatcher.match(uri);
        switch (requestType) {
            case IsetContentProviderUtil.QUERY_TYPE_LIST:
                //retrieving all --> select * from iset
                break;
            case IsetContentProviderUtil.QUERY_TYPE_BY_COLUMN_ID:
                //retrieving specific isetuser --> select * form isetrootusers where ID=x
                queryBuilder.appendWhere(IsetTable.COLUMN_CP_ISET_ID + "=" + uri.getLastPathSegment());
                break;
            case IsetContentProviderUtil.QUERY_TYPE_BY_ISET_ID:
                //retriving a isetuser with specific global ID
                queryBuilder.appendWhere(IsetTable.COLUMN_ISET_ID + "=" + uri.getLastPathSegment());
                break;
            default:
                break;
        }
        Cursor cursor = null;
        SQLiteDatabase db = database.getWritableDatabase();
        try {
            cursor = queryBuilder.query(db, projection, selection, selectionArgs, null, null, IsetTable.DEFAULT_SORT_ORDER);
            if (cursor != null) {
                cursor.setNotificationUri(getContext().getContentResolver(), uri);
            }
        } catch (Exception e) {
            Log.e(TAG, "Error while retrieving isetUsers ", e);
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
        if (requestType != IsetContentProviderUtil.QUERY_TYPE_LIST) {
            throw new IllegalArgumentException("Invalid URI pattern for insert Operation.");
        }
        SQLiteDatabase db = database.getWritableDatabase();
        long newIsetLocalID = db.insert(IsetTable.ISET_TABLE_NAME, null, contentValues);

        getContext().getContentResolver().notifyChange(uri, null);
        Uri newIsetURI = Uri.parse(IsetContentProviderUtil.ISET_CONTENT_URI.toString() + "/" + newIsetLocalID);
        Toast.makeText(getContext(), "Added ISET URI:: " + newIsetURI.toString(), Toast.LENGTH_LONG).show();
        return newIsetURI;

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
