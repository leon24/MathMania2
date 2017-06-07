package newton.mathmania;

import android.content.Intent;
import android.database.Cursor;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import newton.mathmania.databinding.ActivityResultBinding;
import newton.mathmania.models.DatabaseHelper;
import newton.mathmania.models.ResultListAdapter;
import newton.mathmania.models.ViewModel;

public class ResultActivity extends AppCompatActivity {

    private boolean difficultyBuffer;
    private String difficulty;
    private int score;
    private String scoreString;
    private String userName;
    private LoginActivity login;
    private DatabaseHelper database;

    ResultListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ViewModel viewmodel = new ViewModel(this);
        super.onCreate(savedInstanceState);
        ActivityResultBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_result);
        binding.setViewModel(viewmodel);
        database = new DatabaseHelper(this);
        login = new LoginActivity();

        userName = LoginActivity.login.getUserName();

        Intent intent = getIntent();
        Bundle results = intent.getExtras();

        if(results != null)
        {
            difficultyBuffer = results.getBoolean("difficulty");
            score = results.getInt("score");
        }

        TextView points = (TextView) findViewById(R.id.pointsMessage2);
        ListView listView = (ListView) findViewById(R.id.resultList);

        checkDifficulty();

        String scoreBuffer = score + " points on " + difficulty + " difficulty!";
        points.setText(scoreBuffer);

        adapter = new ResultListAdapter(ViewModel.answerList, getApplicationContext());

        LayoutInflater inflater = getLayoutInflater();
        ViewGroup header = (ViewGroup) inflater.inflate(R.layout.listview_header, listView, false);

        listView.addHeaderView(header, null, false);
        listView.setAdapter(adapter);


    }

    @Override
    public void onBackPressed() {
    }

    public void checkDifficulty() {

        Cursor c = database.getData();
        int i = database.getIdFromClassName(userName);
        c.moveToPosition(i-1);
        String easyPoints = c.getString(3);
        String hardPoints = c.getString(4);
        int e = Integer.parseInt(easyPoints);
        int h = Integer.parseInt(hardPoints);

        if (difficultyBuffer) {
            difficulty = "easy";
            if(score>e) {
                scoreString = score + "";
                database.addPointsEasy(scoreString, userName);
            }
        } else {
            difficulty = "hard";
            if(score>h) {
                scoreString = score + "";
                database.addPointsHard(scoreString, userName);
            }
        }

        Log.i("string", difficulty);
        Log.i("boolean", String.valueOf(difficultyBuffer));
    }

    public void resetGame() {

        ViewModel.points = 0;
        ViewModel.answerList.clear();
        ViewModel.questionList.clear();

        adapter.notifyDataSetChanged();

        ChooseDifficultyActivity.radioButtonDifficulty = true;
    }

    public void doneButtonClick(View v) {

        Intent intent = new Intent(ResultActivity.this, MenuActivity.class);
        ResultActivity.this.startActivity(intent);


        Cursor c = database.getData();
        int i = database.getIdFromClassName(userName);
        c.moveToPosition(i-1);
        Log.i("Database:", c.getString(1)+" "+c.getString(3)+" "+c.getString(4));

        resetGame();
    }
}