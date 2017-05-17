package newton.mathmania;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import newton.mathmania.databinding.ActivityHardDifficultyBinding;

public class HardDifficultyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hard_difficulty);
        ActivityHardDifficultyBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_hard_difficulty);
    }

}
