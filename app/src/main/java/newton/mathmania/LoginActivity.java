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

import newton.mathmania.models.DatabaseModel;
import newton.mathmania.models.userLogin;

public class LoginActivity extends AppCompatActivity {

    //DatabaseModel mDatabaseModel;
    private EditText userName;
    private EditText userPass;
    private ArrayList<userLogin> userlist = new ArrayList<userLogin>();
    private DatabaseModel mDatabaseModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mDatabaseModel = new DatabaseModel(this);

        userName = (EditText) findViewById(R.id.loginUserName);
        userPass = (EditText) findViewById(R.id.loginUserPass);

        Cursor c = mDatabaseModel.getData();
        c.moveToFirst();
        if(c.getCount()==0){
            Log.i("Database","Det finns inget i databasen");
            return;
        }
        else{
            while (c.moveToNext()){
                userlist.add(new userLogin(c.getString(1),c.getString(2)));

            }
        }
    }

    public void loginCheck(View v) {
        userLogin login = new userLogin(userName.getText().toString(),userPass.getText().toString());
        SQLiteDatabase db = mDatabaseModel.getWritableDatabase();
        String count = "SELECT count(*) FROM user_login";
        Cursor mcursor = db.rawQuery(count, null);
        mcursor.moveToFirst();
        int icount = mcursor.getInt(0);
        if(icount>0){}
        else{
            Log.i("Database","Lägger till Lösenord och användarnamn");
            mDatabaseModel.addUser("Admin","Admin");

        }
        for (userLogin member : userlist){
            Log.i("Database", member.toString());
        }
        Log.i("Database",login.toString()+"hej");

        if (userlist.get(0).getUserName().equals(login.getUserName())&& userlist.get(0).getPassword().equals(login.getPassword())){
            Intent intent = new Intent(LoginActivity.this, MenuActivity.class);
            LoginActivity.this.startActivity(intent);
        }
        else {
            toastMessage("Invalid username or password. Please try again.");
        }

    }

    private void toastMessage (String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
