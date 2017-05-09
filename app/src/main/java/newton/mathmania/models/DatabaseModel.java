package newton.mathmania.models;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseModel extends SQLiteOpenHelper {

    private static final String TAG ="DatabaseModel";

    private static final String TABLE_NAME = "login";
    private static final String COL1="ID";
    private static final String COL2="username";
    private static final String COL3="password";

    public DatabaseModel(Context context) {
        super(context, TABLE_NAME, null, 1);
    }

    @Override
    //Skapar Databas
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COL2 +" TEXT, " + COL3 +" TEXT)" ;
        db.execSQL(createTable);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP IF TABLE EXISTS " + TABLE_NAME);
        onCreate(db);

    }
    // Lägger till password till Databas
    public boolean addPassword(String pass){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL3,pass);

        Log.i(TAG, "addData: AddingPassword "+ pass + " to "+ TABLE_NAME);

        long result = db.insert(TABLE_NAME, null, contentValues);

        if (result == -1) {
            return false;
        } else {
            return true;
            }
        }
    // Lägger till username till Databas
    public boolean addUsername(String user){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL2,user);

        Log.i(TAG, "addData: AddingPassword "+ user + " to "+ TABLE_NAME);

        long result = db.insert(TABLE_NAME, null, contentValues);

        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }
    //Hämtar Data från databas
    public Cursor getData(){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM "+ TABLE_NAME;
        Cursor data = db.rawQuery(query,null);
        return data;
    }

    }

