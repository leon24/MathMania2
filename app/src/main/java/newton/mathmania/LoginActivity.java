package newton.mathmania;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import java.util.ArrayList;

import newton.mathmania.models.DatabaseHelper;
import newton.mathmania.models.userLogin;

public class LoginActivity extends AppCompatActivity {

    //DatabaseHelper mDatabaseHelper;
    private EditText userName;
    private EditText userPass;
    private ArrayList<userLogin> userlist = new ArrayList<userLogin>();
    private DatabaseHelper mDatabaseHelper;
    public static userLogin login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mDatabaseHelper = new DatabaseHelper(this);

        userName = (EditText) findViewById(R.id.loginUserName);
        userPass = (EditText) findViewById(R.id.loginUserPass);
        login = new userLogin();
        SQLiteDatabase db = mDatabaseHelper.getWritableDatabase();
        String count = "SELECT count(*) FROM user_login";
        Cursor mcursor = db.rawQuery(count, null);
        mcursor.moveToFirst();
        int icount = mcursor.getInt(0);

        if (icount > 0) {
        } else {
            Log.i("Database", "Lägger till Lösenord och användarnamn");
            mDatabaseHelper.addUser("Admin", "Admin");
            mDatabaseHelper.addUser("Leon", "Leon");
            mDatabaseHelper.addUser("Remi", "Remi");
            mDatabaseHelper.addUser("Christian", "Christian");
            mDatabaseHelper.addUser("Tobias", "Tobias");
        }

        Cursor c = mDatabaseHelper.getData();
        c.moveToFirst();
        Log.i("Database", c.getCount() + "?");

        if (c.getCount() == 0) {
            Log.i("Database", "Det finns inget i databasen");
        } else {
            while (c.moveToNext()) {
                Log.i("Database", "While loop körs");
                userlist.add(new userLogin(c.getString(1), c.getString(2)));
            }
        }
    }

    public void loginCheck(View v) {
        login.setUserName(userName.getText().toString());
        login.setPassword(userPass.getText().toString());
        Log.i("Database", login.toString() + userlist.get(0).toString());

        Boolean loginBoolean = false;

        for (userLogin member : userlist) {
            Log.i("Database", member.toString());
        }

        for (int i = 0; i < userlist.size(); i++) {
            if (userlist.get(i).getUserName().equals(login.getUserName()) && userlist.get(i).getPassword().equals(login.getPassword())) {
                Intent intent = new Intent(LoginActivity.this, MenuActivity.class);
                intent.putExtra("User",login.getUserName());
                LoginActivity.this.startActivity(intent);

                loginBoolean = true;
                break;
            } else {
                userName.setText("");
                userPass.setText("");
            }
        }

        if (loginBoolean) {
            toastMessage("Login successful!");
        } else {
            toastMessage("Login failed - please try again!");
        }
    }

    private void toastMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    public void changeActivity(View v) {
        Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
        LoginActivity.this.startActivity(intent);
    }


    public LoginActivity() {}
}