package id.tyangjawi03.belajarandroid.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by macbookair on 7/11/17.
 */

public class MyDataSource {

    private MySQLiteHelper dbHelper;
    private SQLiteDatabase database;
    private String TAG = "MyDataSource";

    public MyDataSource(Context context) {
        dbHelper = new MySQLiteHelper(context);
    }

    public void open() throws SQLException {
        database = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }

    public List<MyData> index() {
        List<MyData> myData = new ArrayList<MyData>();

        Cursor cursor = database.query(MySQLiteHelper.TABLE_NAME,
                new String[]{MySQLiteHelper.COLUMN_ID, MySQLiteHelper.COLUMN_TITLE, MySQLiteHelper.COLUMN_SUB_TITLE},
                null,
                null,
                null,
                null,
                "id DESC");

        if(!cursor.moveToFirst()) {
            Log.e(TAG, "DATA not found");
            return null;
        }

        while (!cursor.isAfterLast()) {
            MyData data = new MyData();
            data.setId(cursor.getInt(0));
            data.setTitle(cursor.getString(1));
            data.setSub_title(cursor.getString(2));

            myData.add(data);
            Log.e(TAG, data.getTitle() + " " + data.getSub_title());
            cursor.moveToNext();
        }

        cursor.close();

        return myData;
    }

    public long create(String title, String sub_title) {
        ContentValues values = new ContentValues();
        values.put(MySQLiteHelper.COLUMN_TITLE, title);
        values.put(MySQLiteHelper.COLUMN_SUB_TITLE, sub_title);

        long id = database.insert(MySQLiteHelper.TABLE_NAME, null, values);
        Log.e(TAG, "Create id : " + id);

        return id;
    }


}
