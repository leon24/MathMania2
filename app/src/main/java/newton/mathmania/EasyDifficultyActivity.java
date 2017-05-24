package newton.mathmania;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import newton.mathmania.databinding.ActivityEasyDifficultyBinding;
import newton.mathmania.models.ViewModel;

public class EasyDifficultyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ViewModel viewmodel = new ViewModel();
        super.onCreate(savedInstanceState);
        ActivityEasyDifficultyBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_easy_difficulty);
        binding.setViewModel(viewmodel);
        viewmodel.StartButtonPressed();
    }
}