package newton.mathmania.models;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by LeonsBärbara on 2017-05-08.
 */

public class DatabaseModel extends SQLiteOpenHelper {

    private static final String TAG = "DatabaseModel";
    private static final String DATABASE_NAME = "MathMania.db";
    private static final String TABLE_NAME = "user_login";
    private static final String COL1 = "ID";
    private static final String COL2 = "USERNAME";
    private static final String COL3 = "PASSWORD";

    public DatabaseModel(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    //Skapar Databas
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COL2 + " TEXT, " + COL3 + " TEXT)";
        db.execSQL(createTable);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP IF TABLE EXISTS " + TABLE_NAME);
        onCreate(db);

    }

    // Lägger till password och username till database
    public boolean addUser(String pass, String usern) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL2, usern);
        contentValues.put(COL3, pass);

        Log.i(TAG, "addData: AddingPassword and AddingUsername " + pass + " to " + TABLE_NAME);

        long result = db.insert(TABLE_NAME, null, contentValues);

        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    //Hämtar Data från databas
    public Cursor getData() {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_NAME;
        Cursor data = db.rawQuery(query, null);
        return data;


    }
}





