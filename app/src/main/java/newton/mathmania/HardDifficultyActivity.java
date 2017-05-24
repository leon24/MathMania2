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
        ViewModel viewmodel = new ViewModel(this);
        super.onCreate(savedInstanceState);
        ActivityHardDifficultyBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_hard_difficulty);
        binding.setViewModel(viewmodel);
        viewmodel.StartButtonPressed();
    }

}
