package newton.mathmania;

import android.content.Intent;
import android.support.annotation.BoolRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class ChooseDifficultyActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    String[] spinnerChoices = {"Multiplication Table 1","Multiplication Table 2","Multiplication Table 3","Multiplication Table 4","Multiplication Table 5", "Multiplication Table 6", "Multiplication Table 7", "Multiplication Table 8", "Multiplication Table 9", "Multiplication Table 10"};
    public static int multiplicationTableChoice;
    public static Boolean radioButtonDifficulty = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_difficulty);

        Spinner multiplicationTablesSpinner = (Spinner) findViewById(R.id.spinnerChooseMultiplicationTable);
        multiplicationTablesSpinner.setOnItemSelectedListener(this);

        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, spinnerChoices);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        multiplicationTablesSpinner.setAdapter(spinnerAdapter);

        RadioButton defaultRadioButtonCheck = (RadioButton) findViewById(R.id.easyDifficultyRadioButton);

        defaultRadioButtonCheck.setChecked(true);
    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.easyDifficultyRadioButton:
                if (checked)
                    radioButtonDifficulty = true;
                    break;
            case R.id.hardDifficultyRadioButton:
                if (checked)
                    radioButtonDifficulty = false;
                    break;
        }
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        switch (position) {
            case 0:
                multiplicationTableChoice = 1;
                break;
            case 1:
                multiplicationTableChoice = 2;
                break;
            case 2:
                multiplicationTableChoice = 3;
                break;
            case 3:
                multiplicationTableChoice = 4;
                break;
            case 4:
                multiplicationTableChoice = 5;
                break;
            case 5:
                multiplicationTableChoice = 6;
                break;
            case 6:
                multiplicationTableChoice = 7;
                break;
            case 7:
                multiplicationTableChoice = 8;
                break;
            case 8:
                multiplicationTableChoice = 9;
                break;
            case 9:
                multiplicationTableChoice = 10;
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void onClickPlayButtonTjofräs(View v) {

        if (radioButtonDifficulty == true) {
            Intent intent = new Intent(ChooseDifficultyActivity.this, EasyDifficultyActivity.class);
            ChooseDifficultyActivity.this.startActivity(intent);
        } else if (radioButtonDifficulty == false) {
            Intent intent = new Intent(ChooseDifficultyActivity.this, HardDifficultyActivity.class);
            ChooseDifficultyActivity.this.startActivity(intent);
        }
    }
}