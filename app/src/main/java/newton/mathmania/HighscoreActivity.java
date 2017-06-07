package newton.mathmania;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import newton.mathmania.models.DatabaseHelper;

public class HighscoreActivity extends AppCompatActivity {
    private DatabaseHelper database;
    private String userName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_highscore);

        TextView highscore = (TextView) findViewById(R.id.highscoreText);
        TextView highscore2 = (TextView) findViewById(R.id.highscoreText2);
        userName = LoginActivity.login.getUserName();
        database = new DatabaseHelper(this);
        Cursor c = database.getData();
        int i = database.getIdFromClassName(userName);
        c.moveToPosition(i-1);
        highscore.setText("Easy Highscore: "+c.getString(3));
        highscore2.setText("Hard Highscore: "+c.getString(4));

    }
}
