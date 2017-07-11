package id.tyangjawi03.belajarandroid.model;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by macbookair on 7/11/17.
 */

public class MySQLiteHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "Database_Name";
    private static final int DATABASE_VERSION = 1;

    private String TABLE_NAME = "table_name";
    private String COLUMN_ID = "id";
    private String COLUMN_TITLE = "title";
    private String COLUMN_SUB_TITLE = "sub_title";

    public MySQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + "(" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOCORRECT, " +
                COLUMN_TITLE + " TEXT NOT NULL, " +
                COLUMN_SUB_TITLE + " TEXT NOT NULL);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

}
