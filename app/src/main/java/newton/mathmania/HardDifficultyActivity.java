package newton.mathmania;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import newton.mathmania.databinding.ActivityHardDifficultyBinding;
import newton.mathmania.models.ViewModel;

public class HardDifficultyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ViewModel viewmodel = new ViewModel();
        super.onCreate(savedInstanceState);
        ActivityHardDifficultyBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_hard_difficulty);
        binding.setViewModel(viewmodel);
        viewmodel.StartButtonPressed();
    }

}
