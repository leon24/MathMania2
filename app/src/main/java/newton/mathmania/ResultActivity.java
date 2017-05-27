package newton.mathmania;

import android.content.Intent;
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
import newton.mathmania.models.ResultListAdapter;
import newton.mathmania.models.ViewModel;

public class ResultActivity extends AppCompatActivity {

    private boolean difficultyBuffer;
    private String difficulty;
    private int score;

    ResultListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ViewModel viewmodel = new ViewModel(this);
        super.onCreate(savedInstanceState);
        ActivityResultBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_result);
        binding.setViewModel(viewmodel);

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

    public void checkDifficulty() {

        if (difficultyBuffer) {
            difficulty = "easy";
        } else {
            difficulty = "hard";
        }

        Log.i("string", difficulty);
        Log.i("boolean", String.valueOf(difficultyBuffer));
    }

    public void resetGame() {

        ViewModel.points = 0;
        ViewModel.answerList.clear();

        adapter.notifyDataSetChanged();

        ChooseDifficultyActivity.radioButtonDifficulty = true;
    }

    public void doneButtonClick(View v) {

        Intent intent = new Intent(ResultActivity.this, MenuActivity.class);
        ResultActivity.this.startActivity(intent);

        resetGame();
    }
}