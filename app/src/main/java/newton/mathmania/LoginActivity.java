package newton.mathmania;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private EditText userName;
    private EditText userPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

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
