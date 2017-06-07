package newton.mathmania.models;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String TAG = "DatabaseHelper";
    private static final String DATABASE_NAME = "MathMania.db";
    private static final String TABLE_NAME = "user_login";
    private static final int DATABASE_VERSION = 6;
    private static final String COL1 = "ID";
    private static final String COL2 = "USERNAME";
    private static final String COL3 = "PASSWORD";
    private static final String COL4 = "EASYPOINTS";
    private static final String COL5 = "HARDPOINTS";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    //Skapar Databas
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                COL2 + " TEXT," + COL3 + " TEXT,"+COL4+" TEXT,"+COL5+" TEXT)" ;
        db.execSQL(createTable);
        Log.i(TAG,"onCreateRuns");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String upgradeQuery = "ALTER TABLE "+TABLE_NAME+" ADD COLUMN "+COL4+" TEXT";
        String upgradeQuery2= "ALTER TABLE "+TABLE_NAME+" ADD COLUMN "+COL5+" TEXT";
        if (oldVersion == 5 && newVersion == 6){
            db.execSQL(upgradeQuery);
            db.execSQL(upgradeQuery2);
        }
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    // Lägger till password och username till database
    public boolean addUser(String pass, String usern) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL2, usern);
        contentValues.put(COL3, pass);
        contentValues.put(COL4,"0");
        contentValues.put(COL5,"0");

        Log.i(TAG, "addData: AddingPassword and AddingUsername " + pass + " to " + TABLE_NAME);

        long result = db.insert(TABLE_NAME, null, contentValues);

        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }
    public void addPointsEasy(String points,String username){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COL4, points);
        db.update(TABLE_NAME, cv, COL2 + "='"+username+"'",null);
        Log.i("Database", "Addpoints method runs");

    }
    public void addPointsHard(String points,String username){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COL5, points);
        db.update(TABLE_NAME, cv, COL2 + "='"+username+"'",null);
        Log.i("Database", "Addpoints method runs");
    }

    //Hämtar Data från databas
    public Cursor getData() {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_NAME;
        Cursor data = db.rawQuery(query, null);

        return data;
    }
    public Cursor getPointsData(String username){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT '"+username+"' FROM " + TABLE_NAME;
        Cursor data = db.rawQuery(query, null);

        return data;
    }
    public int getIdFromClassName(String username){
        String query = "SELECT * FROM " + TABLE_NAME + " WHERE " + COL2 + " = '" + username + "'";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery(query, null);
        res.moveToFirst();

        return res.getInt(0);
    }
}