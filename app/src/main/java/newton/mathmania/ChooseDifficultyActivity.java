package newton.mathmania;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class ChooseDifficultyActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    String[] spinnerChoices = {"Multiplication Table 1","Multiplication Table 2","Multiplication Table 3","Multiplication Table 4","Multiplication Table 5", "Multiplication Table 6", "Multiplication Table 7", "Multiplication Table 8", "Multiplication Table 9", "Multiplication Table 10"};
    String spinnerBuffer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_difficulty);

        Spinner multiplicationTablesSpinner = (Spinner) findViewById(R.id.spinnerChooseMultiplicationTable);
        multiplicationTablesSpinner.setOnItemSelectedListener(this);

        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, spinnerChoices);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        multiplicationTablesSpinner.setAdapter(spinnerAdapter);
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
