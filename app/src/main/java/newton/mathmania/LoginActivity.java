package newton.mathmania;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import newton.mathmania.models.DatabaseModel;

public class LoginActivity extends AppCompatActivity {

<<<<<<< HEAD
    DatabaseModel mDatabaseModel;
=======
    private EditText userName;
    private EditText userPass;
>>>>>>> origin/master

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
<<<<<<< HEAD
        mDatabaseModel = new DatabaseModel(this);
=======
>>>>>>> origin/master

        userName = (EditText) findViewById(R.id.loginUserName);
        userPass = (EditText) findViewById(R.id.loginUserPass);
    }

    public void loginCheck(View v) {

        if (userName.getText().toString().equals("test") && userPass.getText().toString().equals("test")) {

            Intent intent = new Intent(LoginActivity.this, MenuActivity.class);
            LoginActivity.this.startActivity(intent);
        } else {

            toastMessage("Invalid username or password. Please try again.");
        }
    }

    private void toastMessage (String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
