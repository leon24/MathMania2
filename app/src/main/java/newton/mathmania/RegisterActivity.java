package newton.mathmania;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import newton.mathmania.models.DatabaseHelper;

public class RegisterActivity extends AppCompatActivity {
    private EditText userName;
    private EditText userPass;
    private DatabaseHelper mDatabaseHelper;
    private String UserName1;
    private String PassWord1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        userName = (EditText) findViewById(R.id.loginUserName);
        userPass = (EditText) findViewById(R.id.loginUserPass);
        mDatabaseHelper = new DatabaseHelper(this);
    }

    public void registerUser(View v){
        UserName1 = userName.getText().toString();
        PassWord1 = userPass.getText().toString();
        mDatabaseHelper.addUser(UserName1,PassWord1);
        Intent intent = new Intent(RegisterActivity.this,LoginActivity.class);
        RegisterActivity.this.startActivity(intent);
    }
}