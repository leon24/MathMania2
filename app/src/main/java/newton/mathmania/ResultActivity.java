package newton.mathmania;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import newton.mathmania.databinding.ActivityResultBinding;

import newton.mathmania.models.Answer;
import newton.mathmania.models.ResultListAdapter;
import newton.mathmania.models.ViewModel;

public class ResultActivity extends AppCompatActivity {

    private ArrayList<Answer> results = ViewModel.answerList;
    private ArrayList<String> resultList = new ArrayList<>();
    private ListView listView;
    private TextView score;
    private static ResultListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ViewModel viewmodel = new ViewModel(this);
        super.onCreate(savedInstanceState);
        ActivityResultBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_result);
        binding.setViewModel(viewmodel);

        score = (TextView) findViewById(R.id.textView2);
        listView = (ListView) findViewById(R.id.resultList);

        String scoreBuffer = ViewModel.points + " points!";
        score.setText(scoreBuffer);

        //transformAnswer();

        adapter = new ResultListAdapter(results, getApplicationContext());

        listView.setAdapter(adapter);

        //ArrayAdapter arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, resultList);
        //listView.setAdapter(arrayAdapter);
    }

    public void transformAnswer() {

        for (int i = 0; i < results.size(); i++) {

            String getQuestion = results.get(i).getQuestion();
            String getCorrectAnswer = Integer.toString(results.get(i).getCorrectAnswer());
            String getChosenAnswer = Integer.toString(results.get(i).getChosenAnswer());

            Log.i("Question", getQuestion);
            Log.i("CorrectAnswer", getCorrectAnswer);
            Log.i("ChosenAnswer", getChosenAnswer);

            resultList.add(getQuestion);
            resultList.add(getCorrectAnswer);
            resultList.add(getChosenAnswer);

        }



    }
}
