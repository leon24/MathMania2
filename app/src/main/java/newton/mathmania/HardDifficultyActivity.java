package newton.mathmania;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Collections;

import newton.mathmania.databinding.ActivityHardDifficultyBinding;
import newton.mathmania.models.ViewModel;

public class HardDifficultyActivity extends AppCompatActivity {
    ArrayList<Button> buttonList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ViewModel viewmodel = new ViewModel();
        super.onCreate(savedInstanceState);
        ActivityHardDifficultyBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_hard_difficulty);
        binding.setViewModel(viewmodel);
        viewmodel.StartButtonPressed();
    }
    public void shuffleButtonId(){
        Button b1 = (Button) findViewById(R.id.hButton1);
        Button b2 = (Button) findViewById(R.id.hButton2);
        Button b3 = (Button) findViewById(R.id.hButton3);
        Button b4 = (Button) findViewById(R.id.hButton4);
        Button b5 = (Button) findViewById(R.id.hButton5);
        Button b6 = (Button) findViewById(R.id.hButton6);
        buttonList.add(b1);
        buttonList.add(b2);
        buttonList.add(b3);
        buttonList.add(b4);
        buttonList.add(b5);
        buttonList.add(b6);
        Collections.shuffle(buttonList);
        b1 = (buttonList.get(0));
        b2 = (buttonList.get(1));
        b3 = (buttonList.get(2));
        b4 = (buttonList.get(3));
        b5 = (buttonList.get(4));
        b6 = (buttonList.get(5));



    }

}
