package newton.mathmania;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import org.json.JSONArray;
import org.json.JSONObject;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import newton.mathmania.databinding.ActivityEasyDifficultyBinding;
import newton.mathmania.databinding.ActivityHardDifficultyBinding;
import newton.mathmania.models.ViewModel;
import newton.mathmania.models.question;

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