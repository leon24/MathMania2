package newton.mathmania;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import newton.mathmania.models.DatabaseModel;

public class LoginActivity extends AppCompatActivity {

    DatabaseModel mDatabaseModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mDatabaseModel = new DatabaseModel(this);

    }
}
