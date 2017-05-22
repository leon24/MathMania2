package newton.mathmania;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import newton.mathmania.models.ResultData;

public class ResultActivity extends AppCompatActivity {

    private ListView resultList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        resultList = (ListView) findViewById(R.id.resultList);

        ResultData result = new ResultData("5x3", 15, true);

        ArrayList<ResultData> results = new ArrayList<>();

        results.add(result);

        String resultList1 = results.toString();

        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, results);

        resultList.setAdapter(arrayAdapter);

    }
}
